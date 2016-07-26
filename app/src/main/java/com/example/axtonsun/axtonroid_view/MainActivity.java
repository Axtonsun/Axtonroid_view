package com.example.axtonsun.axtonroid_view;

import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.animation.AnimationUtils;

public class MainActivity extends AppCompatActivity {

    private CustomView customView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        customView = (CustomView) findViewById(R.id.customview);
        //View动画
        //如果不设置android:fillAfter="true"  会发生滑动后的复原
        //customView.setAnimation(AnimationUtils.loadAnimation(this,R.anim.translate));
        //属性动画
        //解决了上述View动画的问题    可以解决==》新位置的单击事件的问题
        //ObjectAnimator.ofFloat(customView,"translationX",0,300).setDuration(1000).start();
        //customView.smoothScrollTo(-400,0);
    }

}
