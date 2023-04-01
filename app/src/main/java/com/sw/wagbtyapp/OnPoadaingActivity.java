package com.sw.wagbtyapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

public class OnPoadaingActivity extends AppCompatActivity {


    private ImageView imageView, group;
    private TextView tv_text;
    private int click = 1;
    private AppCompatButton btn_next, btn_skip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_poadaing);
        changeClor();
        initView();
        listenr();
    }


    private void initView() {

        imageView = findViewById(R.id.image);
        tv_text = findViewById(R.id.tv_text);
        group = findViewById(R.id.image_groub);
        btn_next = findViewById(R.id.btn_next);
        btn_skip = findViewById(R.id.btn_skip);

    }


    private void listenr() {
        btn_next.setOnClickListener(view -> {
            switch (click) {
                case 0:
                    setData(R.drawable.ic_image_1, R.drawable.group, getString(R.string.text_1));
                    click = 1;
                    break;
                case 1:
                    setData(R.drawable.ic_image_2, R.drawable.group_2, getString(R.string.text_2));
                    click = 2;
                    break;
                case 2:
                    setData(R.drawable.ic_image_3, R.drawable.group_3, getString(R.string.text_3));
                    click = 3;
                    break;
                case 3:
                    startMainActivity();
                    break;
            }
        });

        btn_skip.setOnClickListener(view -> {
            startMainActivity();
        });
    }


    private void startMainActivity() {
        startActivity(new Intent(OnPoadaingActivity.this, LoginActivity.class));
        finish();
    }

    private void setData(int mImage, int group, String text) {
        imageView.setImageResource(mImage);
        this.group.setImageResource(group);
        tv_text.setText(text);
    }

    private void changeClor() {
        Window window = this.getWindow();

// clear FLAG_TRANSLUCENT_STATUS flag:
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

// add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

// finally change the color
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.white));
    }
}