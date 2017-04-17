package model;

import java.io.Serializable;

public class Tweet implements Serializable {
	private String userName; // ユーザー名
	private String text;	  // Tweet内容

	 //コンストラクタ
	public Tweet() {}
	public Tweet(String userName, String text) {
		this.userName = userName;
		this.text = text;
	}

	//プロパティ
	public String getUserName() { return userName; }
	public String getText() { return text; }

}
