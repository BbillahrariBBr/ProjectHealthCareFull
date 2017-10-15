package com.collegeproject.dev3dot.projecthealthcare;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class WelcomeActivity extends AppCompatActivity implements View.OnClickListener {

    ViewPager mPager; // view pager value
    private int[] layouts = {R.layout.firstslide, R.layout.secondslide, R.layout.thirdslide, R.layout.fourthslide, R.layout.fifthslide};
    //layout resouese id taken
    private MpagerAdapter mpagerAdapter;

    private LinearLayout Dots_layout;
    private ImageView[] dots;
    private Button BnNext;
    private Button BnSkip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();


        if (new PreferenceManager(this).checkPreference()) {
            loadHome();
        }

        if (Build.VERSION.SDK_INT >= 19) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        } else {
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        mPager = (ViewPager) findViewById(R.id.viewPager);
        mpagerAdapter = new MpagerAdapter(layouts, this);
        mPager.setAdapter(mpagerAdapter);

        Dots_layout = (LinearLayout) findViewById(R.id.dotslayout);
        BnNext = (Button) findViewById(R.id.bnnext);
        BnSkip = (Button) findViewById(R.id.bnskip);
        BnNext.setOnClickListener(this);
        BnSkip.setOnClickListener(this);


        createDots(0);

        mPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                createDots(position);

                if (position == layouts.length - 1) {
                    BnNext.setText("Start");
                    BnSkip.setVisibility(View.INVISIBLE);
                } else {
                    BnNext.setText("Next");
                    BnSkip.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }

    private void createDots(int current_postion) {

        if (Dots_layout != null) {
            Dots_layout.removeAllViews();
        }

        dots = new ImageView[layouts.length];

        for (int i = 0; i < layouts.length; i++) {

            dots[i] = new ImageView(this);

            if (i == current_postion) {
                dots[i].setImageDrawable(ContextCompat.getDrawable(this, R.drawable.active_dots));
            } else {
                dots[i].setImageDrawable(ContextCompat.getDrawable(this, R.drawable.default_dots));
            }

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
            params.setMargins(4, 0, 4, 0);
            Dots_layout.addView(dots[i], params);
        }

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.bnnext:
                loadNextSlide();
                break;

            case R.id.bnskip:
                loadHome();
                new PreferenceManager(this).writePreference();
                break;
        }

    }

    //for Main or homeActivity
    private void loadHome() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    //handle next click

    private void loadNextSlide() {

        int next_slide = mPager.getCurrentItem() + 1;

        if (next_slide < layouts.length) {
            mPager.setCurrentItem(next_slide);
        } else {
            loadHome();
            new PreferenceManager(this).writePreference();
            //new PreferenceManager(this).clearPreference();
            //finish();
        }
    }
}
