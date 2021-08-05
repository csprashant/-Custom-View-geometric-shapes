package com.example.geometricalshapes.Views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

public class CustomView  extends View {
    Paint p1;
    Paint p2;
    Paint p3;
    Paint p4;
    int x,y,SQUARE_SIZE;
    float cx,cy,radious=150f;
    Rect rect,rect1;

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
        p1=new Paint(Paint.ANTI_ALIAS_FLAG);
        p2=new Paint(Paint.ANTI_ALIAS_FLAG);
        p3=new Paint(Paint.ANTI_ALIAS_FLAG);
        p4=new Paint(Paint.ANTI_ALIAS_FLAG);
        p1.setColor(Color.BLUE);
        p2.setColor(Color.YELLOW);
        p3.setColor(Color.RED);
        p4.setColor(Color.GRAY);
        x= (int) getX();
        y= (int) getY();
        rect=new Rect();
        rect1=new Rect();
        SQUARE_SIZE=300;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //---------- square------
        rect.left=x+50;
        rect.top=y+50;
        rect.right=rect.left+SQUARE_SIZE;
        rect.bottom=rect.top+SQUARE_SIZE;
        canvas.drawRect(rect,p1);
        //-------- circle-------

        cx=rect.right+100+radious;
        cy=rect.top+SQUARE_SIZE/2;
        canvas.drawCircle(cx,cy,radious,p2);
        //---------rectangle-----
        rect1.left=x+50;
        rect1.top=rect.bottom+50;
        rect1.right=rect1.left+500;
        rect1.bottom=rect1.top+250;
        canvas.drawRect(rect1,p3);
        //----- Line-----------
        int hw=100;
        int x1=700;
        int y1=250+SQUARE_SIZE;
        Path linePath=new Path();
        linePath.moveTo(x1,y1-hw);
        linePath.lineTo(x1-hw,y1+hw);
        linePath.lineTo(x1+hw,y1+hw);
        linePath.lineTo(x1,y1-hw);
        linePath.close();
        canvas.drawPath(linePath,p4);
    }
    public void swapColor(){
        p1.setColor(p1.getColor()==Color.BLUE?Color.RED:Color.BLUE);
        p2.setColor(p2.getColor()==Color.YELLOW?Color.GREEN:Color.YELLOW);
        p3.setColor(p3.getColor()==Color.RED?Color.MAGENTA:Color.RED);
        p4.setColor(p4.getColor()==Color.GRAY?Color.CYAN:Color.GRAY);
        postInvalidate();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        boolean value= super.onTouchEvent(event);
        switch(event.getAction()) {
            case MotionEvent.ACTION_DOWN: {
                float x=event.getX();
                float y=event.getY();
                if(rect.left <x && rect.right>x)
                    if(rect.top<y && rect.bottom>y)
                    {
                        radious+=10f;
                       postInvalidate();
                    }
                if(rect1.left <x && rect1.right>x)
                    if(rect1.top<y && rect1.bottom>y)
                    {
                        radious-=10f;
                        postInvalidate();
                    }
                        return true;
            }

        }
        return  value;
    }
}
