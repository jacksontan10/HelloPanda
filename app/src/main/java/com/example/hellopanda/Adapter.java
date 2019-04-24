package com.example.hellopanda;

import android.content.Context;
import android.graphics.ColorSpace;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

public class Adapter extends PagerAdapter {

    private List<LearnBasicsModel> basicsmodels;
    private LayoutInflater layoutInflater;
    private Context context;

    public Adapter(List<LearnBasicsModel> basicsmodels, Context context) {
        this.basicsmodels = basicsmodels;
        this.context = context;
    }

    @Override
    public int getCount() {
        return basicsmodels.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view.equals(o);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item_learn_basics, container, false);

        ImageView imageView;

        imageView = view.findViewById(R.id.image);

        imageView.setImageResource(basicsmodels.get(position).getImage());

        container.addView(view, 0);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
