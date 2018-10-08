package com.example.owner.zhangqiuyangday20181008.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.owner.zhangqiuyangday20181008.R;

public class WaterView extends View {
    private Paint mTopPaint,mBottomPaint;
    private Path mTopPath,mButtomPath;
    private float a;
    private int typedArrayColor;
    public WaterView(Context context) {
        super(context);
        init(context);
    }

    public WaterView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        /**
         * 自定义属性
         */
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.WaterView);
        typedArrayColor = typedArray.getColor(R.styleable.WaterView_theColor, 0);

        init(context);
    }

    public WaterView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        //创建两个画笔
        mTopPaint = new Paint();
        mTopPaint.setColor(typedArrayColor);
        mTopPaint.setAntiAlias(true);

         mBottomPaint = new Paint();
        mBottomPaint.setColor(Color.RED);
        mBottomPaint.setAntiAlias(true);
        mBottomPaint.setAlpha(60);//设置透明度

        //创建两个路径
         mTopPath = new Path();
         mButtomPath = new Path();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //重置
        mTopPath.reset();
        mButtomPath.reset();

        //设置开始路径
        mTopPath.moveTo(getLeft(),getBottom());
        mButtomPath.moveTo(getLeft(),getBottom());

        //获取每个宽度值所占的宽度
        double mY =  Math.PI * 2 / getWidth();

        a-=0.1f;

        //获取移动的坐标
        for (float x = 0;x<= getWidth();x+=20){
            float y = (float) (10 * Math.cos(mY * x + a) + 10);
            mTopPath.lineTo(x,y);
            mButtomPath.lineTo(x, (float) (10*Math.sin(mY*x+a)));
            linner.success(y);
        }
        //路径终止位置
        mTopPath.lineTo(getRight(),getBottom());
        mButtomPath.lineTo(getRight(),getBottom());

        canvas.drawPath(mTopPath,mTopPaint);
        canvas.drawPath(mButtomPath,mBottomPaint);
        //刷新
        postInvalidateDelayed(20);
    }
    /**
     * 接口回调
     */
    private getBigView linner;
    public void animation(getBigView linner) {
        this.linner = linner;
    }

    public interface getBigView{
        void success(float y);
    }
}
