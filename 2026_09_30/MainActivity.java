package com.example.egzmain;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Button dodaj = findViewById(R.id.dodaj);
        EditText nowyElement = findViewById(R.id.nowyElement);
        ListView lista = findViewById(R.id.lista);

        ArrayList<String> elementy = new ArrayList<>();
        elementy.add("Zakupy: chleb, masło, ser");
        elementy.add("Do zrobienia: obiad, umyć podłogi");
        elementy.add("weekend: kino, spacer z psem");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, elementy);
        lista.setAdapter(adapter);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        dodaj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                elementy.add(nowyElement.getText().toString());
                adapter.notifyDataSetChanged();
                nowyElement.setText("");
            }
        });
    }
}