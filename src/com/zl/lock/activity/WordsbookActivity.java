/**
 * 
 */
package com.zl.lock.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.zl.lock.R;
import com.zl.lock.R.id;
import com.zl.lock.R.layout;
import com.zl.lock.adapter.MyAdapter;
import com.zl.lock.bean.WordBean;
import com.zl.lock.db.dao.Wordsdao;

import android.app.Activity;
import android.content.Context;
import android.net.sip.SipRegistrationListener;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 单词本界面
 * 
 * @author ZLE
 * @data 2013.11.3
 */
public class WordsbookActivity extends Activity {
	public  MyAdapter myadapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.wordsbook);
		Toast.makeText(this, "好好学习，day day up!", 0).show();
		ListView lv = (ListView) findViewById(R.id.lv);
		Wordsdao ws = new Wordsdao(this);
		List<WordBean> words = ws.findAll();
		// ---------------------初始化adapter参数----------------------------------------------
		List<Map<String, String>> data = new ArrayList<Map<String, String>>();
		for (WordBean word : words) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("spell", word.getSpell());
			map.put("translate", word.getTranslate());
			map.put("content", word.getContent());
			data.add(map);
		}
		String[] from = { "spell", "translate", "content" };
		int[] to = { R.id.lv_spell, R.id.lv_translate, R.id.lv_content };
		// ---------------------初始化adapter参数完毕----------------------------------------------
		// 为listview设置数据适配器
		myadapter = new MyAdapter(this, data, R.layout.lv_item, from, to);
		lv.setAdapter(myadapter);
	}

	
}
