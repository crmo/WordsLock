package com.zl.lock.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * 创建SQLiteOpenHelper类 WordsBookDBHelper
 * 
 * @author zl
 * 
 */
public class WordsBookDBHelper extends SQLiteOpenHelper {
	/**
	 * 默认创建单词本数据库words.db 版本号v1.0
	 * 
	 * @param context
	 */
	public WordsBookDBHelper(Context context) {
		super(context, MNameSpace.DBFName, null, 1);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// 初始化表的结构
		String sql = "create table words (id integer primary key autoincrement,spell varchar,translate varchar,content varchar)";
		db.execSQL(sql);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO 自动生成的方法存根

	}

}
