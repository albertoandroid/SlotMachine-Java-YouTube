package com.androiddesdecero.myapplication;

import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView mSlot1, mSlot2, mSlot3;
    private TextView mGanancias;
    private Button mJugar;
    private RelativeLayout mRelative;

    private Random mRandom;
    private int mIntSlot1, mIntSlot2, mIntSlot3, mIntGanancias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSlot1 = findViewById(R.id.mainActivitySlot1);
        mSlot2 = findViewById(R.id.mainActivitySlot2);
        mSlot3 = findViewById(R.id.mainActivitySlot3);
        mGanancias = findViewById(R.id.mainActivityTvGanancias);
        mJugar = findViewById(R.id.mainActivityBtJugar);
        mRelative = findViewById(R.id.mainActivityRl);

        mRandom = new Random();
        mIntGanancias = 5;

        mJugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Has Lanzado: -1 €", Toast.LENGTH_SHORT).show();

                mSlot1.setImageResource(R.drawable.animation);
                final AnimationDrawable slot1Anin = (AnimationDrawable) mSlot1.getDrawable();
                slot1Anin.start();
                mSlot2.setImageResource(R.drawable.animation);
                final AnimationDrawable slot2Anin = (AnimationDrawable) mSlot2.getDrawable();
                slot2Anin.start();
                mSlot3.setImageResource(R.drawable.animation);
                final AnimationDrawable slot3Anin = (AnimationDrawable) mSlot3.getDrawable();
                slot3Anin.start();

                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        slot1Anin.stop();
                        slot2Anin.stop();
                        slot3Anin.stop();


                        ponerImagenes();
                        dineroAcumulado();
                    }
                },1000);
            }
        });
    }

    private void ponerImagenes(){
        mIntSlot1 = mRandom.nextInt(5);
        mIntSlot2 = mRandom.nextInt(5);
        mIntSlot3 = mRandom.nextInt(5);

        Log.d("TAG", mIntSlot1+mIntSlot2+mIntSlot3+"");

        switch (mIntSlot1){
            case 0:
                mSlot1.setImageResource(R.drawable.ic_avion);
                break;
            case 1:
                mSlot1.setImageResource(R.drawable.ic_barco2);
                break;
            case 2:
                mSlot1.setImageResource(R.drawable.ic_bici);
                break;
            case 3:
                mSlot1.setImageResource(R.drawable.ic_camion);
                break;
            case 4:
                mSlot1.setImageResource(R.drawable.ic_tren);
                break;
        }

        switch (mIntSlot2){
            case 0:
                mSlot2.setImageResource(R.drawable.ic_avion);
                break;
            case 1:
                mSlot2.setImageResource(R.drawable.ic_barco2);
                break;
            case 2:
                mSlot2.setImageResource(R.drawable.ic_bici);
                break;
            case 3:
                mSlot2.setImageResource(R.drawable.ic_camion);
                break;
            case 4:
                mSlot2.setImageResource(R.drawable.ic_tren);
                break;
        }

        switch (mIntSlot3){
            case 0:
                mSlot3.setImageResource(R.drawable.ic_avion);
                break;
            case 1:
                mSlot3.setImageResource(R.drawable.ic_barco2);
                break;
            case 2:
                mSlot3.setImageResource(R.drawable.ic_bici);
                break;
            case 3:
                mSlot3.setImageResource(R.drawable.ic_camion);
                break;
            case 4:
                mSlot3.setImageResource(R.drawable.ic_tren);
                break;
        }
    }

    private void dineroAcumulado(){
        if((mIntSlot1 == mIntSlot2)&&(mIntSlot1==mIntSlot3)){
            Snackbar.make(mRelative, "Has Ganando 100€", Snackbar.LENGTH_SHORT).show();
            mIntGanancias = mIntGanancias + 100;
        }else if((mIntSlot1 == mIntSlot2)||(mIntSlot1 == mIntSlot3)||(mIntSlot3 == mIntSlot2)){
            Snackbar.make(mRelative, "Has Ganando 5€", Snackbar.LENGTH_SHORT).show();
            mIntGanancias = mIntGanancias + 5;
        }
        mIntGanancias = mIntGanancias - 1;
        mGanancias.setText(String.valueOf(mIntGanancias));

    }
}
