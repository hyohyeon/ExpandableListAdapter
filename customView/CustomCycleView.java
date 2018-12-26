package com.example.java.a_zapp.customView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Toast;

import com.example.java.a_zapp.R;

/**
 * Created by hyohyeon on 2018-12-26.
 */

public class CustomCycleView extends View{

    Context context;
    int value, size, strokeSize, textSize, width, height;

    public CustomCycleView(Context context) {
        super(context);
        init();
    }

    public CustomCycleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init();
    }

    public CustomCycleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        init();
    }

    private void init(){
        size = getResources().getDimensionPixelSize(R.dimen.donut_size);
        strokeSize = getResources().getDimensionPixelSize(R.dimen.donut_stroke_size);
        textSize = getResources().getDimensionPixelSize(R.dimen.donut_text_size);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        width = MeasureSpec.getSize(widthMeasureSpec);
        height = MeasureSpec.getSize(heightMeasureSpec);
    }
    public void setValue(int value){
        this.value = value;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.alpha(Color.CYAN));
        // 원형그리기
        RectF rectF=new RectF(20, 20, size-20, size-20);
        Paint paint=new Paint();
        paint.setColor(Color.LTGRAY);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(strokeSize);

        canvas.drawArc(rectF, 0, 360, false, paint);

        paint.setColor(Color.RED);
        paint.setStrokeJoin(Paint.Join.ROUND);
        canvas.drawArc(rectF, -90, value, false, paint);

        paint.setTextSize(textSize);
        paint.setStrokeWidth(5);

        String txt=String.valueOf(value);
        int xPos=width/2 - (int)(paint.measureText(txt)/2);
        int yPos=(int)(height/2 - ((paint.descent()+paint.ascent())/2));

        canvas.drawText(txt, xPos, yPos, paint);

        if(txt.equals("360")){
            Toast.makeText(context, "FINISH~",Toast.LENGTH_SHORT).show();
        }
    }
}
