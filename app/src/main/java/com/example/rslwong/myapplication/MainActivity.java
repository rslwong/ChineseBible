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
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class MainActivity extends AppCompatActivity {

    int verse=-1;
    String book="";
    static int savedProgress = 5;
    static float fontSize = -1f;
   // final TextView tv=findViewById(R.id.textView);

    public void dumpText(TextView tv, String fileName){

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
        tv.setMovementMethod(ScrollingMovementMethod.getInstance());
        if (fontSize==-1)
            fontSize = getResources().getDimension(R.dimen.text_size5);

        tv.setTextSize(TypedValue.COMPLEX_UNIT_PX, fontSize);
        this.setTitle(book);
    }

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
        dumpText(tv, fileName);

        final Button button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (verse==1) {
                    int index = Item.getIndex(book);
                    if (index==1)  // ignore if first book, first chapter
                        return;
                    Item prevItem = Item.ITEMS[index-1];
                    verse = prevItem.getChapters();
                    if (verse==-1) {
                        prevItem = Item.ITEMS[index-2];
                        verse = prevItem.getChapters();
                    }
                    book = prevItem.getName();

                } else {
                    verse--;
                }
                tv.setText("");
                String fileName = book+'/'+book+'.'+verse;
                dumpText(tv, fileName);
            }
        });

        final Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int index = Item.getIndex(book);
                int maxVerse = Item.ITEMS[index].getChapters();
                if (verse==maxVerse) {
                    if (index == Item.ITEMS.length-1)
                        return;
                    Item nextItem = Item.ITEMS[index+1];
                    if (nextItem.getChapters() == -1) {
                        nextItem = Item.ITEMS[index+2];
                    }
                    book = nextItem.getName();
                    verse = 1;
                } else {
                    verse++;
                }
                tv.setText("");
                String fileName = book+'/'+book+'.'+verse;
                dumpText(tv, fileName);
            }
        });

        final SeekBar sk=(SeekBar) findViewById(R.id.seekBar1);
        sk.setProgress(savedProgress);
        sk.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // TODO Auto-generated method stub
                switch(progress) {
                    case 0:  fontSize = getResources().getDimension(R.dimen.text_size0); break;
                    case 1:  fontSize = getResources().getDimension(R.dimen.text_size1); break;
                    case 2:  fontSize = getResources().getDimension(R.dimen.text_size2); break;
                    case 3:  fontSize = getResources().getDimension(R.dimen.text_size3); break;
                    case 4:  fontSize = getResources().getDimension(R.dimen.text_size4); break;
                    case 5:  fontSize = getResources().getDimension(R.dimen.text_size5); break;
                    case 6:  fontSize = getResources().getDimension(R.dimen.text_size6); break;
                    case 7:  fontSize = getResources().getDimension(R.dimen.text_size7); break;
                    case 8:  fontSize = getResources().getDimension(R.dimen.text_size8); break;
                    case 9:  fontSize = getResources().getDimension(R.dimen.text_size9); break;
                    case 10:  fontSize = getResources().getDimension(R.dimen.text_size10); break;
                    default: fontSize = getResources().getDimension(R.dimen.text_size5); break;
                }
                savedProgress = progress;
                tv.setTextSize(TypedValue.COMPLEX_UNIT_PX, fontSize);
            }
        });
    }
}
