package com.zl.lock.activity;



import com.zl.lock.R;
import com.zl.lock.R.id;
import com.zl.lock.R.layout;
import com.zl.lock.db.dao.Wordsdao;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * 添加单词
 * 
 * @author zl
 * 
 */
public class AddWordActivity extends Activity {
	EditText et_spell = null;
	EditText et_translate = null;
	EditText et_content = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_word);
		et_spell = (EditText) findViewById(R.id.et_spell);
		et_translate = (EditText) findViewById(R.id.et_translate);
		et_content = (EditText) findViewById(R.id.et_content);

	}

	public void add(View v) {
		Wordsdao ws = new Wordsdao(this);
		String spell = et_spell.getText().toString();
		String translate = et_translate.getText().toString();
		String content = et_content.getText().toString();
		long result = ws.add(spell, translate, content);
		if (result == -1) {
			Toast.makeText(this, "添加失败！", Toast.LENGTH_SHORT).show();
		}else Toast.makeText(this, "添加成功！", Toast.LENGTH_SHORT).show();
		finish();

	}
}
