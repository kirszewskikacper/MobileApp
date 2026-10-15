package com.example.egzamin;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView polubienia;
    Button polub;
    Button usun;

    private int ilosc_polubien = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        polubienia = findViewById(R.id.polubienia);
        polub = findViewById(R.id.polub);
        usun = findViewById(R.id.usun);

        polub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ilosc_polubien++;
                polubienia.setText(ilosc_polubien + " polubień");
            }
        });

        usun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ilosc_polubien>0){
                    ilosc_polubien--;
                }
                polubienia.setText(ilosc_polubien + " polubień");
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}