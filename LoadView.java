package appupdate.bitpai.comz.testz;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class LoadView extends View {

    //背景颜色，圆环，字
    int color_bg,color_circle,color_tv;

    //背景圆半径，字，圆环宽度，加载时间
    int size_cicle,size_tv,size_circle_width,size_time;
    //字的长度
    float length_tv;
    //圆环的开始角度和结束角度
    float angle_start=-90,angle_end;
//背景画笔
    Paint paint_bg=new Paint();
    Paint paint_cicle=new Paint();
    Paint paint_tv=new Paint();
    //圆环大小，位置
    RectF rectF;
    Path path = new Path();
    ValueAnimator animator;

    public LoadView(Context context) {
        this(context, null, 0);
    }

    public LoadView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LoadView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init();
    }



    public void init(){

        color_bg= Color.parseColor("#4D161515");
        color_circle=Color.WHITE;
        color_tv=Color.WHITE;

        size_cicle=dip2px(getContext(),18);
        size_tv=dip2px(getContext(),12);

        paint_bg.setColor(color_bg);
        paint_bg.setAntiAlias(true);


        size_circle_width=dip2px(getContext(),2);
        paint_cicle.setStyle(Paint.Style.STROKE);
        paint_cicle.setStrokeWidth(size_circle_width);
        paint_cicle.setColor(color_circle);
        paint_cicle.setAntiAlias(true);


        paint_tv.setTextSize(size_tv);
        paint_tv.setColor(color_tv);
        paint_tv.setAntiAlias(true);

        length_tv= paint_tv.measureText("跳过");

        size_time=2000;

        rectF=new RectF(size_circle_width,size_circle_width,size_cicle*2-size_circle_width,size_cicle*2-size_circle_width);

        animator=ValueAnimator.ofFloat(0,1);
        animator.setDuration(2000);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {

                if(animation.getAnimatedFraction()==1){
                    if(getEndListener()!=null){
                        getEndListener().end();
                    }
                }
                path.reset();
                path.addArc(rectF,-90,360*animation.getAnimatedFraction());
                invalidate();


            }
        });

    }


    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);


        canvas.drawCircle(size_cicle,size_cicle,size_cicle,paint_bg);
        canvas.drawText("跳过",size_cicle-length_tv/2,size_cicle+size_tv/2,paint_tv);
        canvas.drawPath(path,paint_cicle);


    }

    public void start(){

        animator.start();

    }

    public void end(){
        animator.end();
    }



    public static int dip2px(Context context, float dpValue) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    private EndListener endListener;

    public interface EndListener{
        public void end();
    }

    public EndListener getEndListener() {
        return endListener;
    }

    public void setEndListener(EndListener endListener) {
        this.endListener = endListener;
    }
}
