package com.example.liquidlists;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class CustomAdapter extends ArrayAdapter<String> {

	static class ViewHolder {
		TextView labelText;
	}

	private LayoutInflater inflater;

	public CustomAdapter(Context context, int textViewResourceId,
			ArrayList<String> labelList) {
		super(context, textViewResourceId, labelList);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		View view = convertView;

		if (view == null) {
			inflater = (LayoutInflater) getContext().getSystemService(
					Context.LAYOUT_INFLATER_SERVICE);
			view = inflater.inflate(R.layout.item_layout, null);
			TextView label = (TextView) view.findViewById(R.id.tv);
			holder = new ViewHolder();
			holder.labelText = label;
			view.setTag(holder);
		} else {
			holder = (ViewHolder) view.getTag();
		}

		// 特定の行のデータを取得
		String text = getItem(position);

		if (!TextUtils.isEmpty(text)) {
			holder.labelText.setText(text);
		}

		// 行毎に背景色を変える
		if (position % 2 == 0) {
			holder.labelText.setBackgroundColor(Color.parseColor("#aa0000"));
		} else {
			holder.labelText.setBackgroundColor(Color.parseColor("#880000"));
		}

		Animation anim = AnimationUtils.loadAnimation(getContext(),
				R.anim.item_motion);
		view.startAnimation(anim);

		return view;
	}
}
