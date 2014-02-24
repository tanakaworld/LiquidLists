package com.example.liquidlists;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends Activity {

	private static final int ITEMCOUNT = 20;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.item_layout);

		ListView list = (ListView) findViewById(R.id.listView);
		ArrayList<String> labelList = new ArrayList<String>();

		String label = getString(R.string.item_label);

		for (int i = 1; i <= ITEMCOUNT; i++) {
			labelList.add(label + i);
			System.out.println(i);
		}

		CustomAdapter mAdapter = new CustomAdapter(this, 0, labelList);
		list.setAdapter(mAdapter);

		list.setDivider(null);
	}
}
