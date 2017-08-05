package com.hencoder.hencoderpracticedraw4.practice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw4.R;

public class Practice10MatrixSkewView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap;
    Point point1 = new Point(200, 200);
    Point point2 = new Point(600, 200);
    Matrix matrix = new Matrix();

    public Practice10MatrixSkewView(Context context) {
        super(context);
    }

    public Practice10MatrixSkewView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice10MatrixSkewView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maps);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        matrix.reset();
//        matrix.postSkew(0, 0.5f);
//        matrix.postTranslate(0, -200);
//
//        canvas.save();
//        canvas.setMatrix(matrix);
//        canvas.drawBitmap(bitmap, point1.x, point1.y, paint);
//        canvas.restore();
//
//        matrix.reset();
//        matrix.postSkew(-0.5f, 0);
//        matrix.postTranslate(200, 0);
//
//        canvas.save();
//        canvas.setMatrix(matrix);
//        canvas.drawBitmap(bitmap, point2.x, point2.y, paint);
//        canvas.restore();

        int bitmapWidth = bitmap.getWidth();
        int bitmapHeight = bitmap.getHeight();

        float left = point1.x;
        float top = point1.y;
        float right = point1.x + bitmapWidth;
        float bottom = point1.y + bitmapHeight;

        float[] pointsSrc = {left, top, right, top, left, bottom, right, bottom};
        float[] pointsDst = {left - 10, top + 50, right + 120, top - 90, left + 20, bottom + 30, right + 20, bottom + 60};

        matrix.reset();
        matrix.setPolyToPoly(pointsSrc, 0, pointsDst, 0, 4);

        canvas.save();
        canvas.setMatrix(matrix);
        canvas.drawBitmap(bitmap, point1.x, point1.y, paint);
        canvas.restore();

        canvas.drawBitmap(bitmap, point2.x, point2.y, paint);
    }
}
