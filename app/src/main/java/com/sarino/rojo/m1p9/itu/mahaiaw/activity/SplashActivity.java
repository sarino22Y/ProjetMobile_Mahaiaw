package com.sarino.rojo.m1p9.itu.mahaiaw.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.sarino.rojo.m1p9.itu.mahaiaw.R;
import com.sarino.rojo.m1p9.itu.mahaiaw.customclasses.Constant;
import com.sarino.rojo.m1p9.itu.mahaiaw.utils.Utils;

public class SplashActivity extends AppCompatActivity{

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getSupportActionBar().hide();
        context = this;
        callApi();

    }

    public void callApi() {
        successCall();
        handler.postDelayed(myRunnable, 10000);
    }

    private void successCall() {
        if (Utils.getPref(this, Constant.SPLASH_SCREEN_COUNT, 1) == 1) {
            Log.e("TAG", "successCall::::IFFFFF " + Utils.getPref(this, Constant.SPLASH_SCREEN_COUNT, 1));
            Utils.setPref(this, Constant.SPLASH_SCREEN_COUNT, 2);
            startNextActivity(4000);
        } else {
            Log.e("TAG", "successCall::::ELSEEE " + Utils.getPref(this, Constant.SPLASH_SCREEN_COUNT, 1));
        }
    }

    /* private void checkAd() {
        if (Utils.getPref(this, Constant.STATUS_ENABLE_DISABLE, "").equals(Constant.ENABLE)) {
            if (Utils.getPref(this, Constant.AD_TYPE_FB_GOOGLE, "").equals(Constant.AD_GOOGLE)) {
                Log.e("TAG", "checkAd:Google::::  ");
            } else if (Utils.getPref(this, Constant.AD_TYPE_FB_GOOGLE, "").equals(Constant.AD_FACEBOOK)) {
                Log.e("TAG", "checkAd:Facebook:::: ");
            }
            if (Utils.getPref(this, Constant.STATUS_ENABLE_DISABLE, "").equals(Constant.ENABLE)) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (Utils.getPref(SplashActivity.this, Constant.AD_TYPE_FB_GOOGLE, "").equals(Constant.AD_GOOGLE)) {
                        } else if (Utils.getPref(SplashActivity.this, Constant.AD_TYPE_FB_GOOGLE, "").equals(Constant.AD_FACEBOOK)) {
                        } else {
                            startNextActivity(0);
                        }
                    }

                }, 3000);
                Utils.setPref(this, Constant.SPLASH_SCREEN_COUNT, 1);

            } else {
                startNextActivity(0);
            }
        } else {
            Utils.setPref(this, Constant.SPLASH_SCREEN_COUNT, 1);
            Log.e("TAG", "checkAd:ELSE:::: " + Utils.getPref(this, Constant.STATUS_ENABLE_DISABLE, ""));
            startNextActivity(1000);
        }
    } */


    public void startNextActivity(Integer time) {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, time);
    }

    private Boolean isLoaded = false;

    private Handler handler = new Handler();
    private Runnable myRunnable = new Runnable() {
        @Override
        public void run() {
            if (Utils.isNetworkConnected(SplashActivity.this)) {
                    startNextActivity(0);
            }
        }
    };

    @Override
    protected void onStop() {
        super.onStop();
        handler.removeCallbacks(myRunnable);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(myRunnable);
    }
}

