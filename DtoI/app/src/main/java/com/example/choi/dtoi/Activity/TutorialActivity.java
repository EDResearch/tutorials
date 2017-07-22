package com.example.choi.dtoi.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.choi.dtoi.Adapter.PagerAdapter;
import com.example.choi.dtoi.R;
import com.example.choi.dtoi.Service.CustomIndicator;

/**
 * Created by choi on 2017. 7. 22..
 */

public class TutorialActivity extends AppCompatActivity {
    CustomIndicator customIndicator;
    ViewPager viewPager;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);
        viewPager = (ViewPager) findViewById(R.id.tutorial_pager);
        customIndicator = (CustomIndicator) findViewById(R.id.custom_indicator);
        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
        viewPager.setCurrentItem(0);
        customIndicator.creatIndicator(pagerAdapter.getCount(),30);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                customIndicator.select(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
