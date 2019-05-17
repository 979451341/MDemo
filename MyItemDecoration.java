package com.simplemobiletools.gallery.test;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class MyItemDecoration extends RecyclerView.ItemDecoration {

    Context context;

    Paint paint=new Paint();
    Paint paint_circle=new Paint();
    public MyItemDecoration(Context context) {

        this.context=context;
        paint.setColor( context.getResources().getColor(R.color.line)  );
        paint.setStrokeWidth(dip2px(context,2));


        paint_circle.setStyle(Paint.Style.STROKE);
        paint_circle.setStrokeWidth(dip2px(context,1));
        paint_circle.setColor(context.getResources().getColor(R.color.orange));
        paint_circle.setAntiAlias(true);

    }


    @Override
    public void onDraw(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.onDraw(c, parent, state);

        for(int i=0;i<parent.getChildCount();i++){

            paint.setColor( context.getResources().getColor(R.color.line)  );

            View child=parent.getChildAt(i);

            int cx=dip2px(context,14);
            c.drawLine(cx,child.getTop(),cx,child.getTop()+child.getHeight(),paint);

            if(i==0){
                paint.setColor( context.getResources().getColor(R.color.orange)  );
                int radius_center=dip2px(context,5);
                c.drawCircle(cx,child.getTop()+child.getHeight()/2,radius_center,paint);

                paint.setColor( context.getResources().getColor(R.color.orange_stroke)  );
                int radius_stroke=dip2px(context,10);
                c.drawCircle(cx,child.getTop()+child.getHeight()/2,radius_stroke,paint);

                c.drawCircle(cx,child.getTop()+child.getHeight()/2,radius_stroke,paint_circle);


            }else{
                int radius=dip2px(context,5);
                c.drawCircle(cx,child.getTop()+child.getHeight()/2,radius,paint);
            }


        }



    }


    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.left = dip2px(context,30);

    }


    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);

    }
}
