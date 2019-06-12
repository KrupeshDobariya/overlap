package com.example.overlap;

import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

import static android.view.animation.Animation.*;

public class MainActivity extends AppCompatActivity {




   static Point point;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    //    final FrameLayout layout2 = (FrameLayout) findViewById(R.id.layout2);
      final LinearLayout layout = (LinearLayout)findViewById(R.id.layout);
     /*   FrameLayout.LayoutParams params = (FrameLayout.LayoutParams)layout.getLayoutParams();
        params.setMargins(300, 0, 0, 0);
        layout.setGravity(Gravity.END);
        layout.setLayoutParams(params);*/



       /* FrameLayout.LayoutParams params = (FrameLayout.LayoutParams)layout.getLayoutParams();
        params.setMargins(0, 0, -300, 0);
        layout.setLayoutParams(params);
        layout.setGravity(Gravity.END);*/


        final Button button = (Button) findViewById(R.id.btn);
        final Button b = (Button) findViewById(R.id.b);
        b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Toast.makeText(MainActivity.this, "Clicked", Toast.LENGTH_SHORT).show();

            }
        }
        );

                point = getCenterPointOfView(button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {




                layout.startAnimation(outToLeftAnimation());
                outToLeftAnimation().setFillAfter(true);
                outToLeftAnimation().setAnimationListener(new AnimationListener() {
                    public void onAnimationStart(Animation anim)
                    {
                    };
                    public void onAnimationRepeat(Animation anim)
                    {
                    };
                    public void onAnimationEnd(Animation anim)
                    {
                        final Button b = (Button) findViewById(R.id.b);


                        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(b.getWidth(), b.getHeight());

                        params.leftMargin = 100; //for example you want to shift 100 px from left

                        params.rightMargin = -b.getWidth(); //this will avoid your view
                        //from shrinking and make it as wide as its width was, and - negative value will
                        //move it towards right

                        b.setLayoutParams(params);








                        b.layout(150, 0, button.getWidth() + 150, button.getHeight());
                        FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(layout.getWidth(), layout.getHeight());
                        lp.setMargins(50, 100, 0, 0);
                        layout.setLayoutParams(lp);

                    /*    FrameLayout.LayoutParams params = (FrameLayout.LayoutParams)b.getLayoutParams();
                        params.setMargins(30, 0, 0, 0);
                        b.setGravity(Gravity.START);
                        layout.setLayoutParams(params);*/

                      /*  layout.clearAnimation();
                        FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(layout.getWidth(), layout.getHeight());
                        lp.setMargins(50, 100, 0, 0);
                        layout.setLayoutParams(lp);
*/

                   //     layout.animate().x(50).y(100);



                        /*
                         FrameLayout.LayoutParams params = (FrameLayout.LayoutParams)layout.getLayoutParams();
                         params.setMargins(30, 0, 0, 0);
                         layout.setGravity(Gravity.START);
                         layout.setLayoutParams(params);*/
                   /*     final Button button = (Button) findViewById(R.id.btn);

                        button.layout(150, 0, button.getWidth() + 150, button.getHeight());*/
                    };
                });


/*


                final LinearLayout layout = (LinearLayout)findViewById(R.id.layout);
                FrameLayout.LayoutParams params = (FrameLayout.LayoutParams)layout.getLayoutParams();
                params.setMargins(100, 0, 0, 0);
              //  layout.setGravity(Gravity.END);
                layout.setLayoutParams(params);
*/



          /*      Animation a = new Animation() {

                    @Override
                    protected void applyTransformation(float interpolatedTime, Transformation t) {


              *//*          final LinearLayout layout = (LinearLayout)findViewById(R.id.layout);
                        FrameLayout.LayoutParams params = (FrameLayout.LayoutParams)layout.getLayoutParams();
                        params.setMargins(100, 0, 0, 0);
                        layout.setLayoutParams(params);*//*


                        FrameLayout.LayoutParams params = (FrameLayout.LayoutParams)layout.getLayoutParams();
                        params.rightMargin = (int)(100 * interpolatedTime);
                        layout.setLayoutParams(params);
                    }
                };
                a.setDuration(500); // in ms
                layout.startAnimation(a);


*/
            }
        });
    }




    private Point getCenterPointOfView(View view) {
        int[] location = new int[2];
        view.getLocationInWindow(location);
        int x = location[0] + view.getWidth() / 2;
        int y = location[1] + view.getHeight() / 2;
        return new Point(x, y);
    }

    private Animation outToLeftAnimation() {
        Animation outtoLeft = new TranslateAnimation(
                RELATIVE_TO_PARENT, 0.0f,
                RELATIVE_TO_PARENT, -1.0f,
                RELATIVE_TO_PARENT, 0.0f,
                RELATIVE_TO_PARENT, 0.0f);
        outtoLeft.setFillAfter(true);
        outtoLeft.setDuration(500);
        outtoLeft.setInterpolator(new AccelerateInterpolator());
        return outtoLeft;
    }



}
