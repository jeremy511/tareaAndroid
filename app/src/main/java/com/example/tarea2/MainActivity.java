package com.example.tarea2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    public EditText campo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        campo = findViewById(R.id.intro);


    }

    public boolean dispatchKeyEvent(KeyEvent event) {
        int action = event.getAction();
        int keyCode = event.getKeyCode();
        switch (keyCode) {
            case KeyEvent.KEYCODE_VOLUME_UP:
                if (action == KeyEvent.ACTION_DOWN) {
                    campo = findViewById(R.id.intro);
                    String entero =  campo.getText().toString();
                    int enterovalor=Integer.parseInt(entero);

                    int billetes50 = enterovalor / 50;
                    int billetes100 = enterovalor/100;
                    int monedas20 = enterovalor/20;
                    int monedas10 = enterovalor/10;

                    String result = "Usted tiene" + billetes100 + "billetes de 100 ,\n" +
                            billetes50 +"billetes de 50, \n" +
                            monedas20 + "monedas de 20,  \n" +
                            monedas10 + "monedas de 10, \n";

                    setContentView(R.layout.activity_main);
                    TextView resultado = (TextView) findViewById(R.id.result);
                    resultado.setText(result);
                }
                return true;
            case KeyEvent.KEYCODE_VOLUME_DOWN:
                if (action == KeyEvent.ACTION_DOWN) {
                    TextView resultado = (TextView) findViewById(R.id.result);
                    resultado.setText("Recuerde ingresar una cantidad");
                }
                return true;
            default:
                return super.dispatchKeyEvent(event);
        }
    }








    }













