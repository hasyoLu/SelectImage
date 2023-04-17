package com.example.selectimage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageButton;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private AppCompatEditText edit;
    private AppCompatButton searchButton;
    private TextView textView;
    private ImageView imageView;
    private ImageCity imageCity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageCity = ImageCity.getSingleton();

        initView();

        searchImage("人物");
    }

    private void initView() {
        edit = findViewById(R.id.ic_editView);
        searchButton = findViewById(R.id.ic_imageCity);
        textView = findViewById(R.id.ic_text);
        imageView = findViewById(R.id.ic_imageView);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String key = Objects.requireNonNull(edit.getText()).toString();
                if(!key.equals("")) {
                   searchImage(key);
                }
            }
        });
    }

    private void searchImage(String key) {
        String path = imageCity.getPath(key);
        if(!Objects.equals(path, "")) {
            textView.setText(key);
            Glide.with(this)
                    .load(path)
                    .into(imageView);
        } else {
            Toast.makeText(this, "失败", Toast.LENGTH_SHORT).show();
        }
    }


}