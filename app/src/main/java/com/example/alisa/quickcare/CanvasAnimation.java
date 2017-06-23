package com.example.alisa.quickcare;

import android.content.Context;
import android.graphics.Bitmap;
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

    int canvasWidth;
    int canvasHeight;

    public CanvasAnimation (Context context, int canvas_Height, int canvas_Width) {
        super(context);
        canvasWidth = canvas_Width;
        canvasHeight = canvas_Height;
    }

    public void run() {
        drawCourt();
    }

    public void drawCourt() {
        if (ourHolder.getSurface().isValid()) {
            canvas = ourHolder.lockCanvas();
            canvas.drawColor(Color.BLACK);//the background
            canvas.drawBitmap(bitmap, 0, 0, paint); //Draws the bitmap to the canvas

            //Paint paint = new Paint();
            paint.setColor(Color.argb(255, 255, 255, 255));
            paint.setTextSize(45);
            ourHolder.unlockCanvasAndPost(canvas);
        }
    }


}
