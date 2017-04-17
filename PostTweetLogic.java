package model;

import java.util.List;

// 引数に指定したTweetをTweetリストの一番上に追加
public class PostTweetLogic {
	public void execute(Tweet tweet,List<Tweet> tweetList){
		// リストの先頭に追加
		tweetList.add(0,tweet);
	}

}
