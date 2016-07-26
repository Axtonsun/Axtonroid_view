package com.example.axtonsun.axtonroid_view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Scroller;

/**
 * Created by AxtonSun on 2016/7/26.
 */
public class CustomView extends View {
    private int lastX;
    private int lastY;
    private Scroller mScroller;

    public CustomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mScroller = new Scroller(context);
    }

    public CustomView(Context context) {
        super(context);
    }
    public boolean onTouchEvent(MotionEvent event) {
        //获取到手指处的横坐标和纵坐标
        int x = (int) event.getX();
        int y = (int) event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                lastX = x;
                lastY = y;
                break;

            case MotionEvent.ACTION_MOVE:

                //计算移动的距离
                int offsetX = x - lastX;
                int offsetY = y - lastY;

                //调用layout方法来重新放置它的位置
                //Button不滑动    自定义的滑动
     /*           layout(getLeft()+offsetX, getTop()+offsetY,
                        getRight()+offsetX , getBottom()+offsetY);*/

/*              //Button不滑动    自定义的滑动
                //对left和right进行偏移
                offsetLeftAndRight(offsetX);
                //对top和bottom进行偏移
                offsetTopAndBottom(offsetY);*/

                //使用MarginLayoutParams
                //Button不滑动 自定义的滑动
                LinearLayout.LayoutParams layoutParams= (LinearLayout.LayoutParams) getLayoutParams();
                layoutParams.leftMargin = getLeft() + offsetX;
                layoutParams.topMargin = getTop() + offsetY;
                setLayoutParams(layoutParams);

    /*            //使用scrollBy
                //Button和自定义一起滑动 相对位置不变化
                ((View)getParent()).scrollBy(-offsetX,-offsetY);*/
                break;
        }

        return true;
    }

    @Override
    public void computeScroll() {
        super.computeScroll();
        if (mScroller.computeScrollOffset()) {
            ((View)getParent()).scrollTo(mScroller.getCurrX(),mScroller.getCurrY());
            invalidate();
        }
    }
    public void smoothScrollTo(int destX,int destY){
        int scrollX = getScrollX();
        int delta = destX-destY;
        //1000秒内滑向dextX
        mScroller.startScroll(scrollX,0,delta,0,2000);
        invalidate();
    }
}
