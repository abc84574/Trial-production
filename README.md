# Trial-production
## 名前
Chat
## 概要
チャットのWEBアプリケーション
##　説明
jsp&サーブレット&JavaBeansのMVCモデルを使った簡単なチャットのWEBアプリケーションです。サーバーはTomcat8を使用します。
Java EEでファイル→新規→動的WEBプロジェクト作成でchatプロジェクト作成します。作成が完了したらサーバーにchatプロジェクトを追加してください。
まずは初期設定として以下を行います。

[Model]
chat/javaリソース/src/modelに
LoginLogic.java
PostTweetLogic.java
Tweet.java
User.java
を配置

[Controller]
chat/javaリソース/src/servletに
Login.java
Logout.java
Main.java
を配置

[View]
chat/WebContent/WEB-INFに
index.jsp
を配置

chat/WebContent/WEB-INF/jspに
loginResult.jsp
logout.jsp
main.jsp
を配置

chatプロジェクトを右クリックで実行→サーバで実行をします。
ログイン画面が表示されますので任意のユーザー名とパスワード1234を入力してログインをしてください。
パスワードを知っていれば誰でも入室できる仕組みです。テキストボックスに文字を入力し投稿ボタンを押すと
画面にユーザー名と入力した文字が表示されます。アプリケーションスコープに情報を保持させていますので、
サーバを停止させると入力した文字の情報はすべて破棄されます。
