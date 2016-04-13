package com.example.hiu.kasoku;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

//実際に描画を担当するView
public class MyView extends View {
    int width;
    int height;
    Paint paint = new Paint();
    float x;
    float y;
    float z;
    public MyView(Context context) {
        super(context);
    }

    @Override
    protected void onSizeChanged (int w, int h, int oldw, int oldh) {
        width = w;
        height = h;
    }

    @Override
    public void onDraw(Canvas canvas) {
        paint.setColor(Color.BLUE);
        float xx = width/2-x*width/10;
        float yy = height/2+y*height/10;
        float zz = 30*Math.abs(z)+5;
        canvas.drawCircle(xx,yy,zz,paint);
    }
}
