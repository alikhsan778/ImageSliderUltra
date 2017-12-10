package com.anggastudio.imageslider;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.tmall.ultraviewpager.UltraViewPager;
import com.tmall.ultraviewpager.transformer.UltraDepthScaleTransformer;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    UltraViewPager ultraViewPager;
    UltraPagerAdapter adapter;
    Button btnLove;
    Button btnTry;
    TextView tvAction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ultraViewPager = (UltraViewPager) findViewById(R.id.ultra_viewpager);
        btnLove = (Button) findViewById(R.id.love_button);
        btnTry = (Button) findViewById(R.id.try_button);
        tvAction = (TextView) findViewById(R.id.text_after_tap_button);

        setSlider();
        btnLove.setOnClickListener(this);
        btnTry.setOnClickListener(this);

    }

    private void setSlider() {

        ultraViewPager.setScrollMode(UltraViewPager.ScrollMode.HORIZONTAL);

        //initialize UltraPagerAdapter，and add child view to UltraViewPager
        adapter = new UltraPagerAdapter(true);
        ultraViewPager.setAdapter(adapter);

        //initialize built-in indicator
        ultraViewPager.initIndicator();

        //set style of indicators
        ultraViewPager.getIndicator()
                .setOrientation(UltraViewPager.Orientation.HORIZONTAL)
                .setFocusColor(Color.GREEN)
                .setNormalColor(Color.WHITE);

        //set the alignment
        ultraViewPager.getIndicator().setGravity(Gravity.CENTER_HORIZONTAL | Gravity.BOTTOM);

        //set an infinite loop
        ultraViewPager.setInfiniteLoop(true);

        // set multi screen
        ultraViewPager.setMultiScreen(0.6f);
        ultraViewPager.setItemRatio(1.0f);
        ultraViewPager.setAutoMeasureHeight(true);
        ultraViewPager.setPageTransformer(false, new UltraDepthScaleTransformer());
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.love_button:
                loveEvent();
                break;
            case R.id.try_button:
                tryEvent();
                break;
            default:
                break;
        }
    }

    private void loveEvent() {
        int imagePos = ultraViewPager.getCurrentItem();
        tvAction.setText("I love image number " + imagePos);
    }

    private void tryEvent() {
        int imagePos = ultraViewPager.getCurrentItem();
        tvAction.setText("I'll try image number " + imagePos);
    }
}
