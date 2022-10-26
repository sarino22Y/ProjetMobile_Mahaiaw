package com.sarino.rojo.m1p9.itu.mahaiaw.activity;

import android.content.Context;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.sarino.rojo.m1p9.itu.mahaiaw.R;
import com.sarino.rojo.m1p9.itu.mahaiaw.adapter.SubHomeAdapter;
import com.sarino.rojo.m1p9.itu.mahaiaw.model.LearningDataModel;

import java.util.ArrayList;

public class SubActivity extends AppCompatActivity {

    Context context;
    RelativeLayout llAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        getSupportActionBar().hide();
        context = this;
        initDefine();
        llAdView = findViewById(R.id.llAdView);
    }

    TextView txtTitleSubHome;
    int position;
    int TYPE;
    private void initDefine() {
        rvSubHome = findViewById(R.id.rvSubHome);
        txtTitleSubHome = findViewById(R.id.txtTitleSubHome);
        Intent intent = getIntent();
        position = intent.getIntExtra("categoryPosition", 0);
        String category = intent.getStringExtra("Category");
        TYPE=intent.getIntExtra("Type",0);
        txtTitleSubHome.setText(category);
        prepareDataForLearning(position);
    }

    ArrayList<LearningDataModel> learningDataModelArrayList;

    public void prepareDataForLearning(int i2) {
        if (i2 == 0) {
            learningDataModelArrayList = new ArrayList();
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.zero_0, "Zero", "Zero"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.one_1, "Un", "Un"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.two_2, "Deux", "Deux"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.three_3, "Trois", "Trois"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.four_4, "Quatre", "Quatre"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.five_5, "Cinq", "Cinq"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.six_6, "Six", "Six"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.seven_7, "Sept", "Sept"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.eight_8, "Huit", "Huit"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.nine_9, "Neuf", "Neuf"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.ten_10, "Dix", "Dix"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.eleven_11, "Onze", "Onze"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.twelve_12, "Douze", "Douze"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.thirteen_13, "Treize", "Treize"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.fourteen_14, "Quatorze", "Quatorze"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.fifteen_15, "Quinze", "Quinze"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.sixteen_16, "Seize", "Seize"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.seventeen_17, "Dix-sept", "Dix-sept"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.eighteen_18, "Dix-huit", "Dix-huit"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.nineteen_19, "Dix-neuf", "Dix-neuf"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.twenty_20, "Vingt", "Vingt"));
        } else if (i2 == 1) {
            learningDataModelArrayList = new ArrayList();
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.green, "Vert", "Vert"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.pink, "Rose", "Rose"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.red, "Rouge", "Rouge"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.black, "Noir", "Noir"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.aqua, "Aqua", "Aqua"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.blue, "Bleu", "Bleu"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.brown, "Marron", "Marron"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.slate, "Gris", "Gris"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.violet, "Violet", "Violet"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.white, "Blanc", "Blanc"));
            learningDataModelArrayList.add(new LearningDataModel(R.drawable.yellow, "Jaune", "Jaune"));
        }
        setRvAdapter();
    }

    SubHomeAdapter subHomeAdapter;
    RecyclerView rvSubHome;

    private void setRvAdapter() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false);
        rvSubHome.setLayoutManager(gridLayoutManager);
        subHomeAdapter = new SubHomeAdapter(context, learningDataModelArrayList,position,TYPE);
        rvSubHome.setAdapter(subHomeAdapter);
    }

    public void onClickBack(View view) {
        finish();
    }
}
