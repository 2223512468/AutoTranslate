package com.autotranslate;

import android.app.Activity;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private int[] imageId = new int[]{
            R.drawable.bg01, R.drawable.bg02, R.drawable.bg03,
            R.drawable.bg04, R.drawable.bg05
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Gallery gallery = (Gallery) findViewById(R.id.gallery);

        BaseAdapter adapter = new BaseAdapter() {

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                ImageView imageview = new ImageView(MainActivity.this);
                imageview.setScaleType(ImageView.ScaleType.FIT_XY);
                imageview.setLayoutParams(new Gallery.LayoutParams(180, 135));
                TypedArray typearray = obtainStyledAttributes(R.styleable.Gallery);
                imageview.setBackgroundResource(typearray.getResourceId(R.styleable.Gallery_android_galleryItemBackground, 0));
                imageview.setPadding(5, 0, 5, 0);
                imageview.setImageResource(imageId[position % imageId.length]);
                return imageview;
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public Object getItem(int position) {
                return position;
            }

            @Override
            public int getCount() {
                return Integer.MAX_VALUE;
            }
        };

        gallery.setAdapter(adapter);
        gallery.setSelection(imageId.length / 2);

        gallery.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {
                Toast.makeText(MainActivity.this, String.valueOf(arg2), Toast.LENGTH_SHORT).show();

            }
        });

    }

}
