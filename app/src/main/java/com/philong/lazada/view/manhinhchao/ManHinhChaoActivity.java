package com.philong.lazada.view.manhinhchao;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import com.philong.lazada.R;
import com.philong.lazada.view.trangchu.TrangChuActivity;

/**
 * Created by Long on 23/04/2017.
 */

public class ManHinhChaoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.man_hinh_chao_activity);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent iTrangChu = new Intent(ManHinhChaoActivity.this, TrangChuActivity.class);
                startActivity(iTrangChu);
                finish();
            }
        }, 3000);


    }
}
