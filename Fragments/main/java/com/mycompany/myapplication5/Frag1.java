package com.mycompany.myapplication5;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class Frag1 extends Fragment {
    public Frag1() {
    }

    @Override
    public View onCreateView(LayoutInflater l, ViewGroup container,
                             Bundle savedInstanceState) {
        return l.inflate(R.layout.news_articles1, container, false);
    }
}