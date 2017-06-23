package com.example.alisa.quickcare;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import static android.R.attr.bitmap;

/**
 * Created by Jordan Kang on 6/22/2017.
 */

class CanvasAnimation extends SurfaceView implements Runnable {

    Canvas canvas;
    SurfaceHolder ourHolder;
    Paint paint;
    Bitmap bitmap;
    volatile boolean CanDraw;

    public CanvasAnimation (Context context) {
        super(context);
        ourHolder = getHolder();
    }

    @Override
    public void run() {
        while(CanDraw) {
            drawCourt();
        }
    }

    public void drawCourt() {
        if (ourHolder.getSurface().isValid()) {
            canvas = ourHolder.lockCanvas();
            canvas.drawColor(Color.BLACK);//the background
            canvas.drawBitmap(bitmap, 0, 0, paint); //Draws the bitmap to the canvas

            //Paint paint = new Paint();
            paint.setColor(Color.argb(255, 255, 255, 255));
            ourHolder.unlockCanvasAndPost(canvas);
        }
    }
}
