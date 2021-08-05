package com.example.geometricalshapes.Views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

public class CustomView  extends View {
    Paint p1;
    Paint p2;
    Paint p3;
    Paint p4;
    int x,y;
    Rect rect;

    public CustomView(Context context) {
        super(context);
        init(null);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }
    public void init(AttributeSet attr) {
        p1=new Paint();
        p2=new Paint();
        p3=new Paint();
        p4=new Paint();
        x= (int) getX();
        y= (int) getY();
        rect=new Rect();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        rect.left=x;
        rect.top=y;
        rect.right=rect.left+100;
        rect.bottom=rect.top+100;
        p1.setColor(Color.BLUE);
        canvas.drawRect(rect,p1);
    }
}
