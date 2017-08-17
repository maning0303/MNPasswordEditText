package com.maning.mnpasswordedittext;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.maning.pswedittextlibrary.MNPasswordEditText;

public class MainActivity extends AppCompatActivity {

    private MNPasswordEditText mPswEditText;
    private TextView tvShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvShow = (TextView) findViewById(R.id.tvShow);
        mPswEditText = (MNPasswordEditText) findViewById(R.id.mPswEditText);
        mPswEditText.setOnPasswordChangeListener(new MNPasswordEditText.OnPasswordChangeListener() {
            @Override
            public void onPasswordChange(String password) {
                tvShow.setText(password);
            }
        });


    }
}
