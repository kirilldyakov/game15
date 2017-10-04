package ru.strongit.game15;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import ru.strongit.game15.ui.Game;

public class MainActivity extends AppCompatActivity {


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


        //TextView tv = (TextView) findViewById(R.id.k07);
        //tv.setOnTouchListener(otListener);

    }


}
