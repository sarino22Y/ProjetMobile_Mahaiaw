package com.sarino.rojo.m1p9.itu.mahaiaw.activity;

import android.content.Context;
import android.content.Intent;
import android.speech.tts.TextToSpeech;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.sarino.rojo.m1p9.itu.mahaiaw.R;
import com.sarino.rojo.m1p9.itu.mahaiaw.customclasses.AppControl;
import com.sarino.rojo.m1p9.itu.mahaiaw.customclasses.Constant;
import com.sarino.rojo.m1p9.itu.mahaiaw.customclasses.NonSwipeAbleViewPager;
import com.sarino.rojo.m1p9.itu.mahaiaw.model.LearningDataModel;
import com.sarino.rojo.m1p9.itu.mahaiaw.utils.Utils;

import java.util.ArrayList;

public class FullScreenActivity extends AppCompatActivity {

    Context context;
    int categoryPosition, selectedPosition;
    RelativeLayout llAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screen);
        getSupportActionBar().hide();
        context = this;
        initDefine();
    }

    TextView tvItemName;

    private void initDefine() {
        viewPager = findViewById(R.id.viewPager);
        tvItemName = findViewById(R.id.tvItemName);
        imgBtnNext = findViewById(R.id.imgBtnNext);
        imgBtnPrev = findViewById(R.id.imgBtnPrev);

        llAdView = findViewById(R.id.llAdView);

        Intent intent = getIntent();
        categoryPosition = intent.getIntExtra("categoryPosition", 0);
        selectedPosition = intent.getIntExtra("selectedPosition", 0);
        prepareDataForLearning(categoryPosition);
        setViewPagerAdapter(learningDataModelArrayList);
    }

    NonSwipeAbleViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;
    ArrayList<LearningDataModel> arrayOfImages;

    private void setViewPagerAdapter(ArrayList<LearningDataModel> learningDataModelArrayList) {
        this.arrayOfImages = learningDataModelArrayList;
        viewPagerAdapter = new ViewPagerAdapter(learningDataModelArrayList);
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.setCurrentItem(selectedPosition);
        tvItemName.setText(learningDataModelArrayList.get(selectedPosition).showTitle);
        tvItemName.startAnimation(AnimationUtils.loadAnimation(context, R.anim.rotation));
        YoYo.with(Techniques.RubberBand).duration(1200).repeat(1).playOn(tvItemName);
        if (Utils.getPref(Constant.SOUND, true)) {
            AppControl.textToSpeech.speak(learningDataModelArrayList.get(selectedPosition).getSpeakTitle(), TextToSpeech.QUEUE_FLUSH, null);
        }

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {
            }

            @Override
            public void onPageSelected(int i) {
                tvItemName.setText(arrayOfImages.get(i).showTitle);
                YoYo.with(Techniques.RubberBand).duration(1200).repeat(1).playOn(tvItemName);
                if (Utils.getPref(Constant.SOUND, true)) {
                    AppControl.textToSpeech.speak(arrayOfImages.get(i).getSpeakTitle(), TextToSpeech.QUEUE_FLUSH, null);
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }

    public void onClickBack(View view) {
        finish();
    }

    public void onClickPrev(View view) {
        if (viewPager.getCurrentItem() > 0) {
            viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
        }
    }

    public void onClickNext(View view) {
        if (viewPager.getCurrentItem() < learningDataModelArrayList.size() - 1) {
            viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
        }
    }


    ImageView imageView;
    class ViewPagerAdapter extends PagerAdapter {

        ArrayList<LearningDataModel> arrayOfImages;
        LayoutInflater inflater;

        ViewPagerAdapter(ArrayList<LearningDataModel> arrayOfImages) {
            this.arrayOfImages = arrayOfImages;
            inflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return arrayOfImages.size();
        }


        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view == object;
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            View itemView = inflater.inflate(R.layout.viewpager_layout, container, false);
            imageView = itemView.findViewById(R.id.cellImgViewPager);
            Glide.with(context)
                    .load(arrayOfImages.get(position).image)
                    .apply(new RequestOptions().diskCacheStrategy(DiskCacheStrategy.ALL))
                    .into(imageView);

            YoYo.with(Techniques.Tada).duration(1200).repeat(1).playOn(imageView);

            container.addView(itemView);

            return itemView;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView((RelativeLayout) object);
        }
    }

    ImageView imgBtnPrev,imgBtnNext;

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
        setViewPagerAdapter(learningDataModelArrayList);
    }
}
