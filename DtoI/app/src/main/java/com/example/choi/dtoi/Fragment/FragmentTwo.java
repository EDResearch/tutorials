package com.example.choi.dtoi.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.choi.dtoi.R;

/**
 * Created by choi on 2017. 7. 22..
 */

public class FragmentTwo extends Fragment {
    Animation anim;
    ImageView light;
    public FragmentTwo() {
    }
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        RelativeLayout layout = (RelativeLayout) inflater.inflate(R.layout.fragment_tutorial_two, container, false);
        anim = AnimationUtils.loadAnimation(getContext(),R.anim.tutorial_alpha);
        light = (ImageView) layout.findViewById(R.id.light);
        light.startAnimation(anim);

        return layout;
    }
}
