package com.example.hellopanda;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

public class LearnAnimalsAdapter extends PagerAdapter {

    private List<LearnAnimalsModel> animalsmodels;
    private LayoutInflater layoutInflater;
    private Context context;

    public LearnAnimalsAdapter(List<LearnAnimalsModel> animalsmodels, Context context) {
        this.animalsmodels = animalsmodels;
        this.context = context;
    }

    @Override
    public int getCount() {
        return animalsmodels.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view.equals(o);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item_learn_animals, container, false);

        ImageView imageView;

        imageView = view.findViewById(R.id.image);

        imageView.setImageResource(animalsmodels.get(position).getImage());

        container.addView(view, 0);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}

//sourcecode created with the help from "Android 👆 Swipe Views using ViewPager • haerulmuttaqin" https://www.youtube.com/watch?v=UsXv6VRqZKs
