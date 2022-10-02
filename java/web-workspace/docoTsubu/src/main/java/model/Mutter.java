package model;

import java.io.Serializable;

public class Mutter implements Serializable {
	private int id;
	private String userName;	// ユーザ名
	private String text;		// つぶやき内容

	public Mutter() {}
	public Mutter(String userName, String text) {
		this.userName = userName;
		this.text = text;
	}

	public Mutter(int id, String userName, String text) {
		this.id = id;
		this.userName = userName;
		this.text = text;
	}

	public int getId() {
		return id;
	}

	public String getUserName() {
		return userName;
	}

	public String getText() {
		return text;
	}
}
