package com.example.hellopanda.learn;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.example.hellopanda.R;

import java.util.List;

    public class LearnVideosAdapter extends PagerAdapter {

        private List<LearnVideosModel> videosmodels;
        private LayoutInflater layoutInflater;
        private Context context;
        private WebView webView;

        public LearnVideosAdapter() {
        }

        public LearnVideosAdapter (List<LearnVideosModel> videosmodels, Context context) {
            this.videosmodels = videosmodels;
            this.context = context;
        }

        @Override
        public int getCount() {
            return videosmodels.size();
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
            return view.equals(o);
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            layoutInflater = LayoutInflater.from(context);
            View view = layoutInflater.inflate(R.layout.item_learn_videos, container, false);

            webView = view.findViewById(R.id.video);

            webView.getSettings().setJavaScriptEnabled(true);

            webView.loadData( videosmodels.get(position).getVideoUrl(), "text/html", "utf-8");

            container.addView(view, 0);

            return view;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView((View)object);
            }
        }

