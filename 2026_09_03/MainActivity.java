package com.example.myapplication;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button rzut;
    ImageView kosc1;
    ImageView kosc2;
    ImageView kosc3;
    ImageView kosc4;
    ImageView kosc5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        rzut = findViewById(R.id.Rzut);
        kosc1 = findViewById(R.id.kosc1);
        kosc2 = findViewById(R.id.kosc2);
        kosc3 = findViewById(R.id.kosc3);
        kosc4 = findViewById(R.id.kosc4);
        kosc5 = findViewById(R.id.kosc5);

        rzut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int tablicaKosci[] = {(int)Math.random()*5+1,(int)Math.random()*5+1,(int)Math.random()*5+1,(int)Math.random()*5+1,(int)Math.random()*5+1};

                int iloscWynikow[] = {0,0,0,0,0,0};

                int wynik = 0;

                for(int i = 0; i< tablicaKosci.length; i++){
                    switch (tablicaKosci[i]){
                        case 1:
                            iloscWynikow[0]+=1;
                            break;
                        case 2:
                            iloscWynikow[1]+=1;
                            break;
                        case 3:
                            iloscWynikow[2]+=1;
                            break;
                        case 4:
                            iloscWynikow[3]+=1;
                            break;
                        case 5:
                            iloscWynikow[4]+=1;
                            break;
                        case 6:
                            iloscWynikow[5]+=1;
                            break;
                    }
                }
                for(int i = 0; i< iloscWynikow.length; i++){
                    if(iloscWynikow[i]>1){
                        wynik = wynik + iloscWynikow[i] * (i+1);
                    }
                }
            }
        });

    }
}