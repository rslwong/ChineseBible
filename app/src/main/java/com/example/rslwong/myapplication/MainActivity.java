package com.example.rslwong.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.text.method.ScrollingMovementMethod;
import android.util.TypedValue;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class MainActivity extends AppCompatActivity {

    int verse=-1;
    String book="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView tv=findViewById(R.id.textView);

        Bundle b = getIntent().getExtras();
        if(b != null) {
            book = b.getString("book");
            verse = b.getInt("verse");
        }

        String fileName = book+'/'+book+'.'+verse;

        BufferedReader reader;

        try{
            final InputStream file = getAssets().open(fileName);
            reader = new BufferedReader(new InputStreamReader(file));
            String line = reader.readLine();
            while(line != null){
                tv.append(line+'\n');
                line = reader.readLine();
            }
        } catch(IOException ioe){
            ioe.printStackTrace();
        }

        //tv.setMovementMethod(new ScrollingMovementMethod());
        tv.setMaxLines(1000);
        tv.setMovementMethod(ScrollingMovementMethod.getInstance());

        tv.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.text_medium));

        this.setTitle(book);

        final Button button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                float size = tv.getTextSize()*0.9f;
                tv.setTextSize(TypedValue.COMPLEX_UNIT_PX, size);
            }
        });

        final Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                float size = tv.getTextSize()*1.1f;
                tv.setTextSize(TypedValue.COMPLEX_UNIT_PX, size);            }
        });

    }
}
