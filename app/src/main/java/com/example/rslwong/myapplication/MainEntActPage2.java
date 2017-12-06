package com.example.rslwong.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

public class MainEntActPage2 extends Activity implements AdapterView.OnItemClickListener {

    private GridView mGridView;
    private GridAdapter mAdapter;
    int totalChapters=-1;
    String book="";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grid);

        Bundle b = getIntent().getExtras();
        if(b != null) {
            book = b.getString("book");
            totalChapters = b.getInt("totalChapters");
        }
        // Setup the GridView and set the adapter
        mGridView = (GridView) findViewById(R.id.grid);   // grid.xml
        mGridView.setOnItemClickListener(this);
        mAdapter = new GridAdapter();
        mGridView.setAdapter(mAdapter);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        if (position==0)
            return;

        // Construct an Intent as normal
        Intent intent = new Intent(this, MainActivity.class);
        Bundle b = new Bundle();
        b.putString("book",book);
        b.putInt("verse", position);
        intent.putExtras(b);
        startActivity(intent);
    }


    private class GridAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return totalChapters+1;
        }

        @Override
        public ItemPage2 getItem(int position) {
            return new ItemPage2(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = getLayoutInflater().inflate(R.layout.grid_item, viewGroup, false);
            }

            final ItemPage2 item = getItem(position);

            // Set the TextView's contents
            TextView name = (TextView) view.findViewById(R.id.textview_name);
            if (position==0) {
                name.setBackgroundColor(Color.GRAY);
                name.setText(book);
                name.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.text_huge));
                name.setGravity(Gravity.CENTER);
            } else {
                name.setBackgroundColor(Color.WHITE);
                name.setText(String.valueOf(position));
                name.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.text_medium));
                name.setGravity(Gravity.LEFT);
            }
            return view;
        }
    }
}