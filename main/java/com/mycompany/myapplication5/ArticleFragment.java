package com.mycompany.myapplication5;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class ArticleFragment extends Fragment {
    public static String ARG_POSITION = "wer";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.news_articles, container, false);
    }

    public void updateArticleView(int position) {
    }
}
