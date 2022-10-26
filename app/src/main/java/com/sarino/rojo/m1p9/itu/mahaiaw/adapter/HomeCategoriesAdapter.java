package com.sarino.rojo.m1p9.itu.mahaiaw.adapter;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.sarino.rojo.m1p9.itu.mahaiaw.R;
import com.sarino.rojo.m1p9.itu.mahaiaw.activity.SubActivity;

public class HomeCategoriesAdapter extends RecyclerView.Adapter<HomeCategoriesAdapter.ViewHolder> {

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgHomeCategory;
        LinearLayout lloutHome;

        ViewHolder(@NonNull View view) {
            super(view);
            this.imgHomeCategory = view.findViewById(R.id.imgHomeCategory);
            this.lloutHome = view.findViewById(R.id.lloutCardHome);
        }
    }

    Context context;
    int[] mainCategoryList;
    String[] homeCategoryTitles;
    int TYPE;

    public HomeCategoriesAdapter(Context context, int[] mainCategoryList, String[] homeCategoryTitles, int type) {
        this.context = context;
        this.mainCategoryList = mainCategoryList;
        this.homeCategoryTitles = homeCategoryTitles;
        this.TYPE = type;
    }

    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.card_list_home, viewGroup, false));
    }

    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        Glide.with(context).load(mainCategoryList[i]).apply(new RequestOptions().diskCacheStrategy(DiskCacheStrategy.ALL)).into(viewHolder.imgHomeCategory);

        viewHolder.lloutHome.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (TYPE == 1) {
                    Intent intent = new Intent(context, SubActivity.class);
                    intent.putExtra("categoryPosition", i);
                    intent.putExtra("Category", homeCategoryTitles[i]);
                    intent.putExtra("Type",TYPE);
                    context.startActivity(intent);
                }
            }
        });
    }

    public int getItemCount() {
        return mainCategoryList.length;
    }
}