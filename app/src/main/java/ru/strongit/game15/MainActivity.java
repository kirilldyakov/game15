package ru.strongit.game15;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    float dX, dY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Context ctx = getApplicationContext();
        Game game = new Game(ctx);
        game.init();
        Log.d("TAG", "onCreate: " + "\n" + game.toString());
        game.block_12.moveDown();
        Log.d("TAG", "onCreate: " + "\n" + game.toString());
        game.block_8.moveDown();
        Log.d("TAG", "onCreate: " + "\n" + game.toString());
        game.block_7.moveRight();
        Log.d("TAG", "onCreate: " + "\n" + game.toString());
        game.block_3.moveDown();
        Log.d("TAG", "onCreate: " + "\n" + game.toString());
//        game.moveDown(2, 3);
//        Log.d("TAG", "onCreate: " + "\n" + game.toString());
//        game.moveDown(1, 3);
//        Log.d("TAG", "onCreate: " + "\n" + game.toString());
//        game.moveRight(1, 2);
//        Log.d("TAG", "onCreate: " + "\n" + game.toString());
//        game.moveUp(2, 2);
//        Log.d("TAG", "onCreate: " + "\n" + game.toString());
//        game.moveRight(2, 1);
//        Log.d("TAG", "onCreate: " + "\n" + game.toString());

        TextView tv = (TextView) findViewById(R.id.k07);
        tv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                float x, y;
                switch (event.getAction()) {

                    case MotionEvent.ACTION_DOWN:

                        dX = view.getX() ;//- event.getRawX();
                        dY = view.getY() - event.getRawY();
                        break;

                    case MotionEvent.ACTION_MOVE:
                        x = dX;
                        y = event.getRawY() + dY;
                        view.animate()
                                //.x(event.getRawX() + dX)
                                .x(x)
                                .y(y)
                                .setDuration(0)
                                .start();
                        break;
                    case MotionEvent.ACTION_UP:
                        x= view.getX();
                        y =view.getY();
                        if (view.getY()>250)
                            y=400;
                        else
                            y=50;
                        view.animate()
                                //.x(event.getRawX() + dX)
                                .x(x)
                                .y(y)
                                .setDuration(100)
                                .start();
                        break;
                    default:
                        return false;
                }
                return true;
            }
        });
    }


}
