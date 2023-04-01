package com.sw.wagbtyapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {


    private AppCompatButton btn_logon;
    private TextView tv_regester;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        changeClor();
        initView();
        listener();
    }

    private void initView() {
        btn_logon = findViewById(R.id.btn_login);
        tv_regester = findViewById(R.id.tv_regester_2);
    }

    private void listener() {
        btn_logon.setOnClickListener(view -> {
            startActivity(new Intent(this, MainActivity.class));
            finish();
        });

        tv_regester.setOnClickListener(view -> startActivity(
                new Intent(this, RegesterActivity.class)));
    }

    private void changeClor() {
        Window window = this.getWindow();

// clear FLAG_TRANSLUCENT_STATUS flag:
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

// add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

// finally change the color
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.backgound));
    }
}