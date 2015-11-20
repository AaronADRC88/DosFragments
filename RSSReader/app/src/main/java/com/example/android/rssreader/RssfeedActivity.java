package com.example.android.rssreader;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class RssfeedActivity extends AppCompatActivity implements DetailFragment.OnItemSelectedListener, MyListFragment.Onfrag2Listener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rssfeed);
    }

    @Override
    public void onRssItemSelected(String link) {

        MyListFragment fragment2 = (MyListFragment) getFragmentManager()
                .findFragmentById(R.id.listFragment);
        fragment2.setText(link);

    }

    @Override
    public void onItemSelected(String link) {
        DetailFragment fragment = (DetailFragment) getFragmentManager()
                .findFragmentById(R.id.detailFragment);
        fragment.setText(link);
    }
}

