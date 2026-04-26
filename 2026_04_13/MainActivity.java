package edu.zsk.zadanie;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.concurrent.atomic.AtomicInteger;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        
        ViewCompat.setOnApplyWindowInsetsListener(
            findViewById(R.id.main), 
            (view, insets) -> {
                Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                return insets;
            }
        );

        AtomicInteger clickCounter = new AtomicInteger(0);

        Button incrementButton = findViewById(R.id.btn);
        incrementButton.setOnClickListener(clickListener -> {
            EditText nameField = findViewById(R.id.name);
            String userName = nameField.getText().toString();

            EditText emailField = findViewById(R.id.email);
            String userEmail = emailField.getText().toString();

            if (userName.isEmpty() || userEmail.isEmpty()) {
                Toast.makeText(MainActivity.this, "Najpierw uzupełnij swoje dane", Toast.LENGTH_SHORT).show();
            }
            else {
                int currentCount = clickCounter.incrementAndGet();
                
                TextView counterDisplay = findViewById(R.id.txt2);
                counterDisplay.setText("Kliknąłeś przycisk " + currentCount + " razy");

                TextView greetingDisplay = findViewById(R.id.txt1);
                greetingDisplay.setText("Witaj, " + userName + "! Twój adres e-mail to: " + userEmail);
            }
        });
    }
}