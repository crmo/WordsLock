package com.zl.lock.adapter;

import java.util.List;
import java.util.Map;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.zl.lock.R;
import com.zl.lock.activity.WordsbookActivity;
import com.zl.lock.db.dao.Wordsdao;

//---------------------listview适配器-------------------
public class MyAdapter extends BaseAdapter {
	public MyAdapter(Context context, List<? extends Map<String, ?>> data,
			int resource, String[] from, int[] to) {
		super();
		// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!妈蛋！在这花了一节课！！！记住！！！！！
		inflater = (LayoutInflater) context
				.getSystemService(context.LAYOUT_INFLATER_SERVICE);
		this.data = (List<Map<String, String>>) data;
		this.context = context;
		// TODO 自动生成的构造函数存根
	}

	LayoutInflater inflater;
	List<Map<String, String>> data;
	Context context;

	// public MyAdapter(WordsbookActivity wordsbookActivity,
	// List<Map<String, String>> data) {
	// this.data = data;
	// }

	@Override
	public int getCount() {
		return data.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO 自动生成的方法存根
		return arg0;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO 自动生成的方法存根
		return arg0;
	}

	@Override
	public View getView(int arg0, View convertView, ViewGroup arg2) {
		// View view = null;
		if (convertView == null) {
			convertView = inflater.inflate(R.layout.lv_item, null);
		} else {

		}
		TextView tv_spell = (TextView) convertView.findViewById(R.id.lv_spell);
		TextView lv_translate = (TextView) convertView
				.findViewById(R.id.lv_translate);
		TextView lv_content = (TextView) convertView
				.findViewById(R.id.lv_content);
		tv_spell.setText(data.get(arg0).get("spell"));
		lv_translate.setText(data.get(arg0).get("translate"));
		lv_content.setText(data.get(arg0).get("content"));
		// ----------------------长按删除功能实现--------------------------------
		convertView.setOnLongClickListener(new OnLongClickListener() {
			@Override
			public boolean onLongClick(View v) {
				Wordsdao ws = new Wordsdao(context);
				Long a = ws.delet(((TextView) v.findViewById(R.id.lv_spell))
						.getText().toString());
				Toast.makeText(context, "删除成功！", 0).show();
				getView(0, null, null);
				// ------据说可以刷新界面
				//-------瞎说的。别信！！！！
				//WordsbookActivity.clear();
				//WordsbookActivity.refreash();
				return true;
			}
		});
		// ------------------------------------------------------------------
		return convertView;
	}


}
// ---------------------listview适配器-------------------
// ---------------------end-------------------
