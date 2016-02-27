package com.zl.lock.bean;

/**
 * 定义一个单词类 Word
 * 
 * @author zl
 * 
 */
public class WordBean {
	private int id;
	private String spell;
	private String content;
	private String translate;
	@Override
	public String toString() {
		return  spell + ":"+translate+"("+content+")";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSpell() {
		return spell;
	}

	public void setSpell(String spell) {
		this.spell = spell;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTranslate() {
		return translate;
	}

	public void setTranslate(String translate) {
		this.translate = translate;
	}



	public WordBean(int id, String spell, String content, String translate) {
		super();
		this.id = id;
		this.spell = spell;
		this.content = content;
		this.translate = translate;
	}
}
