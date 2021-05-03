package com.prakpapb2.simplecanvas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private Canvas mCanvas;
    private Paint mPaint = new Paint();
    private Paint mPaintText = new Paint(Paint.UNDERLINE_TEXT_FLAG);
    private Bitmap mBitmap;
    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImageView = findViewById(R.id.my_imageview);
        mPaint.setColor(Color.YELLOW);
        mPaintText.setColor(ResourcesCompat.getColor(getResources(),
                R.color.purple_200, null));
        mPaintText.setTextSize(60);
    }

    public void drawSomething(View view) {
        int vWidth = view.getWidth();
        int vHeight = view.getHeight();
        mBitmap = Bitmap.createBitmap(vWidth, vHeight, Bitmap.Config.ARGB_8888);
        mImageView.setImageBitmap(mBitmap);
        mCanvas = new Canvas(mBitmap);
        mCanvas.drawColor(Color.GREEN);
        mCanvas.drawText("HELLO WORLD", 50, 50, mPaintText);

        mPaint.setColor(Color.BLUE);
        mPaint.setStrokeWidth(5);
        mCanvas.drawLine(100, 100, 300, 200, mPaint);

        mPaint.setColor(Color.RED);
        Rect mRect = new Rect();
        mRect.set(100, 200, 500, 400);
        mCanvas.drawRect(mRect, mPaint);
        mPaint.setColor(Color.YELLOW);

        mCanvas.drawCircle(200, 500, 100, mPaint);

        Path path = new Path();
                path.moveTo(100, 600);
                path.lineTo(300, 750);
                path.lineTo(500, 650);
                path.lineTo(700, 800);
                mPaint.setColor(Color.MAGENTA);
                mCanvas.drawPath(path, mPaint);

                view.invalidate();
    }
}