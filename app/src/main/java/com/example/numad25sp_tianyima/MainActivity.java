package com.example.numad25sp_tianyima;

import android.os.Bundle;
import android.widget.Button;
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
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button b = findViewById(R.id.about_me_button);
        b.setOnClickListener( v -> {
            Toast.makeText(this,"Name: Tianyi Ma\nEmail: ma.tianyi@northeastern.edu", Toast.LENGTH_LONG ).show();
        });
        showWelcomeDialog();
    }

    private void showWelcomeDialog() {
        // create AlertDialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Welcome");
        builder.setMessage("Welcome to my app!");
        builder.setPositiveButton("OK", (dialog, which) -> {
            dialog.dismiss(); // click OK to close alert
        });

        // show alert
        AlertDialog welcomeDialog = builder.create();
        welcomeDialog.show();
    }
}