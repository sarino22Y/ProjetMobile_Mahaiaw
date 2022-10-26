package com.sarino.rojo.m1p9.itu.mahaiaw.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sarino.rojo.m1p9.itu.mahaiaw.R;
import com.sarino.rojo.m1p9.itu.mahaiaw.adapter.HomeCategoriesAdapter;

public class Menu extends AppCompatActivity {

    Context context;
    RelativeLayout llAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        getSupportActionBar().hide();
        context = this;
        initDefine();
        llAdView = findViewById(R.id.llAdView);
    }

    public int[] mainCategoryList;
    String[] homeCategoryTitles;
    TextView txtExamTitle;
    int type=1;
    private void initDefine() {
        rvHomeCategories = findViewById(R.id.rvHomeCategories);
        txtExamTitle = findViewById(R.id.txtTitleSubHome);
        Intent intent=getIntent();
        type=intent.getIntExtra("Type",1);

        if(type==1){
            txtExamTitle.setText("Menu");
        }

        homeCategoryTitles = new String[]{"Nombres", "Couleurs"};
        mainCategoryList = new int[]{R.drawable.home_number, R.drawable.home_color};
        setRvAdapter();
    }

    HomeCategoriesAdapter homeCategoriesAdapter;
    RecyclerView rvHomeCategories;

    private void setRvAdapter() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false);
        rvHomeCategories.setLayoutManager(gridLayoutManager);
        homeCategoriesAdapter = new HomeCategoriesAdapter(context, mainCategoryList,homeCategoryTitles,type);
        rvHomeCategories.setAdapter(homeCategoriesAdapter);
    }

    public void onClickBack(View view) {
        finish();
    }
}
