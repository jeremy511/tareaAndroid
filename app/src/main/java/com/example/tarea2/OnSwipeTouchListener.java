package com.example.tarea2;
import android.annotation.SuppressLint;
import android.content.Context;
import android.text.Layout;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.EditText;
import android.widget.TextView;


public class OnSwipeTouchListener implements OnTouchListener {

    TextView cabecera;
    EditText intro;
    View backg;

    private final GestureDetector gestureDetector;

    public OnSwipeTouchListener(GestureDetector gestureDetector){
        this.gestureDetector = gestureDetector;

        cabecera = (TextView) cabecera.findViewById(R.id.cabecera);
        intro = (EditText) intro.findViewById(R.id.intro);
        backg = (View) backg.findViewById(R.id.elaidi);

    }

    public OnSwipeTouchListener(Context context) {
        gestureDetector = new GestureDetector(context, new GestureListener());

    }

    public void onSwipeLeft() {
    }

    public void onSwipeRight() {
    }



    public boolean onTouch(View v, MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }

    private final class GestureListener extends SimpleOnGestureListener {

        private static final int SWIPE_DISTANCE_THRESHOLD = 100;
        private static final int SWIPE_VELOCITY_THRESHOLD = 100;

        @Override
        public boolean onDown(MotionEvent e) {
            return true;
        }

        @SuppressLint("ResourceAsColor")
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            float distanceX = e2.getX() - e1.getX();
            float distanceY = e2.getY() - e1.getY();
            if (Math.abs(distanceX) > Math.abs(distanceY) && Math.abs(distanceX) > SWIPE_DISTANCE_THRESHOLD && Math.abs(velocityX) > SWIPE_VELOCITY_THRESHOLD) {
                if (distanceX > 0){
                 System.exit(0);}
                else{
                    intro.setText("");
                return true;}
            }

            else if (Math.abs(distanceY) > SWIPE_DISTANCE_THRESHOLD && Math.abs(velocityY) > SWIPE_VELOCITY_THRESHOLD){
                if (distanceY> 0)
                {
                 backg.setBackgroundColor(android.R.color.black);
                }

                else {
                    backg.setBackgroundColor(android.R.color.white);

                }}





            return false;
        }
    }
}
