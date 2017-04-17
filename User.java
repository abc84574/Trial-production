package model;

import java.io.Serializable;

public class User implements Serializable{
	private String name; // ユーザー名
	private String pass; // パスワード

	// コンストラクタ
	public User() {}
	public User(String name, String pass) {
		this.name = name;
		this.pass = pass;
	}

	// プロパティ
	public String getName() { return name; }
	public String getPass() { return pass; }
}
