package com.example.rslwong.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.util.TypedValue;
import android.view.Gravity;

import android.widget.TextView;

public class MainEntAct extends Activity implements AdapterView.OnItemClickListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grid);

        // Setup the GridView and set the adapter
        GridView mGridView = (GridView) findViewById(R.id.grid);
        mGridView.setOnItemClickListener(this);
        GridAdapter mAdapter = new GridAdapter();
        mGridView.setAdapter(mAdapter);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        Item item = (Item) adapterView.getItemAtPosition(position);
        int totalChapters = item.getChapters();
        if (totalChapters==-1)
            return;

        // Construct an Intent as normal
        Intent intent = new Intent(this, MainEntActPage2.class);
        Bundle b = new Bundle();
        b.putString("book",item.getName());
        b.putInt("totalChapters", totalChapters);
        intent.putExtras(b);
       // intent.putExtra(MainActivity.EXTRA_PARAM_ID, item.getId());
        startActivity(intent);
    }


    private class GridAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return Item.ITEMS.length;
        }

        @Override
        public Item getItem(int position) {
            return Item.ITEMS[position];
        }

        @Override
        public long getItemId(int position) {
            return getItem(position).getId();
        }

        @Override
        public View getView(int position, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = getLayoutInflater().inflate(R.layout.grid_item, viewGroup, false);
            }

            final Item item = getItem(position);

            // Set the TextView's contents
            TextView name = (TextView) view.findViewById(R.id.textview_name);
            name.setText(item.getName());
            if (item.getChapters()==-1) {
                name.setBackgroundColor(Color.GRAY);
                name.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.text_huge));
                name.setGravity(Gravity.CENTER);
            } else {
                name.setBackgroundColor(Color.WHITE);
                name.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.text_medium));
                name.setGravity(Gravity.LEFT);
            }
            return view;
        }
    }
}