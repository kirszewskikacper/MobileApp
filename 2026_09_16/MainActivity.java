package com.example.egzamin;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        EditText editText;
        Button zatwierdz;
        Button wlacz_wylacz;
        TextView numer_prania;
        TextView stan_odkurzacza;


        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        editText = findViewById(R.id.edit_text_id);
        zatwierdz = findViewById(R.id.button_id1);
        wlacz_wylacz = findViewById(R.id.button_id2);
        numer_prania = findViewById(R.id.numer_prania);
        stan_odkurzacza = findViewById(R.id.status_odkurzacza);

        zatwierdz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!editText.getText().toString().isEmpty()){
                    int liczba = Integer.parseInt(editText.getText().toString());
                    if(liczba > 0 && liczba < 13){
                        numer_prania.setText("Numer prania: " + liczba);
                    }
                }
            }
        });

        wlacz_wylacz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(wlacz_wylacz.getText().toString()=="Włącz"){
                    wlacz_wylacz.setText("Wyłącz");
                    stan_odkurzacza.setText("Odkurzacz włączony");
                }
                else{
                    wlacz_wylacz.setText("Włącz");
                    stan_odkurzacza.setText("Odkurzacz wyłączony");
                }
            }
        });
    }
}