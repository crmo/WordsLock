package com.zl.lock.db.dao;

import java.util.ArrayList;
import java.util.List;

import com.zl.lock.bean.WordBean;
import com.zl.lock.db.MNameSpace;
import com.zl.lock.db.WordsBookDBHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * 实现了对words数据库的各种操作
 * 
 * @author zl
 * 
 */
public class Wordsdao {
	private SQLiteOpenHelper help;

	/**
	 * 完成对WordsBookDBHelper的初始化
	 * 
	 * @param context
	 */
	public Wordsdao(Context context) {
		help = new WordsBookDBHelper(context);
	}

	/**
	 * 
	 * @param spell单词
	 * @param translate翻译
	 * @param content备注
	 * @return -1表示失败
	 */
	public long add(String spell, String translate, String content) {
		ContentValues values = new ContentValues();
		values.put("spell", spell);
		values.put("translate", translate);
		values.put("content", content);
		SQLiteDatabase database = help.getWritableDatabase();
		long result = database.insert(MNameSpace.DBName, null, values);
		database.close();
		return result;
	}

	/**
	 * 删除单词
	 * @param spell
	 *            单词
	 * @return 0表示失败
	 */
	public long delet(String spell) {
		SQLiteDatabase database = help.getWritableDatabase();
		long result = database.delete(MNameSpace.DBName, "spell = ?",
				new String[] { spell });
		database.close();
		return result;
	}

	/**
	 * 查询所有单词
	 * 
	 * @return Word类的集合
	 */
	public List<WordBean> findAll() {
		SQLiteDatabase database = help.getWritableDatabase();
		List<WordBean> words = new ArrayList<WordBean>();
		Cursor cursor = database.query(MNameSpace.DBName, null, null, null,
				null, null, null);
		while (cursor.moveToNext()) {
			int id = cursor.getInt(cursor.getColumnIndex("id"));
			String spell = cursor.getString(cursor.getColumnIndex("spell"));
			String translate = cursor.getString(cursor
					.getColumnIndex("translate"));
			String content = cursor.getString(cursor.getColumnIndex("content"));
			WordBean word = new WordBean(id, spell, content, translate);
			words.add(word);
		}
		database.close();
		return words;
	}
}
