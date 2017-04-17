package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.PostTweetLogic;
import model.Tweet;
import model.User;


@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public Main() {
        super();

    }

    //URL入力、リンク、ブックマークからのGETリクエスト
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Tweetリストをアプリケーションスコープから取得
		ServletContext application = this.getServletContext();
		List<Tweet> tweetList = (List<Tweet>) application.getAttribute("tweetList");

		// 取得できなかった場合は、Tweetリストを新規作成(new)してアプリケーションスコープに保存
		if(tweetList == null) {
			tweetList = new ArrayList<Tweet>();
			application.setAttribute("tweetList", tweetList);
		}

		// ログインしているか確認するためにセッションスコープからユーザー情報を取得
		HttpSession session = request.getSession();
		User loginUser = (User)session.getAttribute("loginUser");

		// ログインしていない場合はログイン画面(index.jsp)へリダイレクト
		if(loginUser == null) {
			response.sendRedirect("/chat/");
		} else {
		// ログインしている場合はメイン画面(main.jsp)へフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
			dispatcher.forward(request, response);
		}

	}

	// main.jspからのPOSTリクエスト
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {

		// リクエストパラメータ(Tweet内容)の取得
		request.setCharacterEncoding("UTF-8");
		String text = request.getParameter("text");

		// ユーザー名が保存されてるかどうかチェック
		if(text != null && text.length() != 0) {
			// アプリケーションスコープに保存されたTweetリストを取得
			ServletContext application = this.getServletContext();
			List<Tweet> tweetList = (List<Tweet>) application.getAttribute("tweetList");

			// セッションスコープに保存されたユーザー情報を取得
			HttpSession session = request.getSession();
			User loginUser = (User) session.getAttribute("loginUser");

			// TweetをTweetリストに追加
			Tweet tweet = new Tweet(loginUser.getName(), text); // ログイン中のユーザー名とTweet内容
			PostTweetLogic postTweetLogic = new PostTweetLogic();
			postTweetLogic.execute(tweet, tweetList);

			// アプリケーションスコープにTweetリストを保存
			application.setAttribute("tweetList", tweetList);
		} else {
			// エラーメッセージをリクエストスコープに保存
			request.setAttribute("errorMsg", "Tweet内容が入力されてません");
		}

		//メイン画面(main.jsp)にフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
		dispatcher.forward(request, response);

	}


}
