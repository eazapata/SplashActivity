package com.example.a2048;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {

    private float firstTouchX;
    private float firstTouchY;
    private TextView[][] textViews;
    private int[][] textViewValues = new int[4][4];
    private GridLayout grid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.textViews = fillArray();
        this.grid = (GridLayout) findViewById(R.id.grid);
        this.grid.setOnTouchListener(this);
        setRandomNumber();
    }


    @Override
    public boolean onTouch(View v, MotionEvent event) {
        String direction = null;
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                //Aqui guardas en una variable privada de clase las coordenadas del primer toque:
                firstTouchX = event.getX();
                firstTouchY = event.getY();

                break;
            case MotionEvent.ACTION_MOVE:
                //Aqui ya podemos determinar los tipos de movimientos:
               if (firstTouchX > event.getX()) {
                    //Toast.makeText(this, "izquierda", Toast.LENGTH_SHORT).show();
                    direction = "left";
                    moveNumbers(direction);

                } else if (firstTouchX < event.getX()){
                    //Hacia la derecha
                    Toast.makeText(this, "derecha", Toast.LENGTH_SHORT).show();
                    direction ="right";
                    moveNumbers(direction);

                }
                 if (firstTouchY > event.getY()) {
                    // Toast.makeText(this, "arriba", Toast.LENGTH_SHORT).show();
                    //Hacia arriba
                    direction = "up";
                    moveNumbers(direction);
                } else if (firstTouchY > event.getY()) {
                    // Toast.makeText(this, "abajo", Toast.LENGTH_SHORT).show();
                    //Hacia abajo
                    direction = "down";
                    moveNumbers(direction);
                }
                break;
        }

        return true;
    }

    public void setRandomNumber() {
        Random random = new Random();
        int pos1 = random.nextInt(4);
        int pos2 = random.nextInt(4);
        int value = random.nextInt(10);
        this.textViewValues[pos1][pos2] = value;
        this.textViews[pos1][pos2].setText(String.valueOf(this.textViewValues[pos1][pos2]));
    }

    private TextView[][] fillArray() {
        TextView textView1 = (TextView) findViewById(R.id.one);
        TextView textView2 = (TextView) findViewById(R.id.two);
        TextView textView3 = (TextView) findViewById(R.id.three);
        TextView textView4 = (TextView) findViewById(R.id.four);
        TextView textView5 = (TextView) findViewById(R.id.five);
        TextView textView6 = (TextView) findViewById(R.id.six);
        TextView textView7 = (TextView) findViewById(R.id.seven);
        TextView textView8 = (TextView) findViewById(R.id.eight);
        TextView textView9 = (TextView) findViewById(R.id.nine);
        TextView textView10 = (TextView) findViewById(R.id.ten);
        TextView textView11 = (TextView) findViewById(R.id.eleven);
        TextView textView12 = (TextView) findViewById(R.id.twelve);
        TextView textView13 = (TextView) findViewById(R.id.thirteen);
        TextView textView14 = (TextView) findViewById(R.id.fourteen);
        TextView textView15 = (TextView) findViewById(R.id.fifteen);
        TextView textView16 = (TextView) findViewById(R.id.sixteen);
        TextView[][] arrayText = {
                {textView1, textView2, textView3, textView4},
                {textView5, textView6, textView7, textView8},
                {textView9, textView10, textView11, textView12},
                {textView13, textView14, textView15, textView16}};
        return arrayText;
    }

    private void moveNumbers(String direction){
        switch (direction){
            case "left":
                for (int i = 0; i < this.textViewValues.length; i++) {
                    for (int j = 0; j < this.textViewValues[i].length ; j++) {
                        if(textViewValues[i][j] != 0){
                            this.textViews[i][j].setText("");
                            this.textViewValues[i][0] = this.textViewValues[i][j];
                            this.textViews[i][0].setText(String.valueOf(this.textViewValues[i][j]));
                        }
                    }
                }
                break;
            case "right":
                for (int i = 0; i < this.textViewValues.length; i++) {
                    for (int j = 0; j < this.textViewValues[i].length ; j++) {
                        if(textViewValues[i][j] != 0){
                            this.textViews[i][j].setText("");
                            this.textViewValues[i][textViewValues[i].length - 1] = this.textViewValues[i][j];
                            this.textViews[i][textViewValues[i].length - 1].setText(String.valueOf(this.textViewValues[i][j]));

                        }
                    }
                }
                break;
            case "up":
                for (int i = 0; i < this.textViewValues.length; i++) {
                    for (int j = 0; j < this.textViewValues[i].length ; j++) {
                        if(textViewValues[i][j] != 0){
                            this.textViews[i][j].setText("");
                            this.textViewValues[0][j] = this.textViewValues[i][j];
                            this.textViews[0][j].setText(String.valueOf(this.textViewValues[i][j]));
                        }
                    }
                }
                break;
            case "down":
                for (int i = 0; i < this.textViewValues.length; i++) {
                    for (int j = 0; j < this.textViewValues[i].length ; j++) {
                        if(textViewValues[i][j] != 0){
                            this.textViews[i][j].setText("");
                            this.textViewValues[textViewValues.length - 1][j] = this.textViewValues[i][j];
                            this.textViews[textViewValues.length - 1][j].setText(String.valueOf(this.textViewValues[i][j]));
                        }
                    }
                }

                break;
            default:
                Log.d("Move Numbers", "moveNumbers: ");
        }

    }
}