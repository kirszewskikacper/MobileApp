package edu.zsk.zadanie;

import static android.app.PendingIntent.getActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        
        View mainView = findViewById(R.id.main);
        ViewCompat.setOnApplyWindowInsetsListener(mainView, (currentView, windowInsets) -> {
            Insets systemBarInsets = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars());
            currentView.setPadding(systemBarInsets.left, systemBarInsets.top, systemBarInsets.right, systemBarInsets.bottom);
            return windowInsets;
        });
    }

    public void showFirstImage(View clickedView) {
        dialog imageDialog = dialog.createInstance(R.drawable.creativecanvas_dwarf_8923325);
        imageDialog.show(getSupportFragmentManager(), "image_dialog");
    }

    public void showSecondImage(View clickedView) {
        dialog imageDialog = dialog.createInstance(R.drawable.jcoope12_ai_generated_8671788);
        imageDialog.show(getSupportFragmentManager(), "image_dialog");
    }

    public void showThirdImage(View clickedView) {
        dialog imageDialog = dialog.createInstance(R.drawable.jcoope12_ai_generated_8820927);
        imageDialog.show(getSupportFragmentManager(), "image_dialog");
    }
}