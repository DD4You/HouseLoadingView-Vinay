package com.digitalduniya4you.houseloadingview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.digitalduniya4you.houseloadinglibrary.HouseLoadingView;

public class MainActivity extends AppCompatActivity {

HouseLoadingView mView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mView = new HouseLoadingView();
        findViewById(R.id.button).setOnClickListener(
                new View.OnClickListener() {
                    @Override public void onClick(View v) {
                        showDialog();
                    }
                });
    }

    public void showDialog() {
        mView.show(getSupportFragmentManager(), "");
    }

}
