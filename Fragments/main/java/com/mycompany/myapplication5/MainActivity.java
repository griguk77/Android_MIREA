package com.mycompany.myapplication5;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void add(View v) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.f1, new Frag1());
        Toast.makeText(this, R.string.added, Toast.LENGTH_SHORT).show();
        ft.addToBackStack(null);
        ft.commit();
    }

    public void delete(View v) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        if (fm.getBackStackEntryCount() > 0) {
            fm.popBackStack();
            Toast.makeText(this, R.string.deleted, Toast.LENGTH_SHORT).show();
        }
        ft.commit();
    }

    public void replace(View v) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.f1, new Frag2());
        Toast.makeText(this, R.string.replaced, Toast.LENGTH_SHORT).show();
        ft.addToBackStack(null);
        ft.commit();
    }
}