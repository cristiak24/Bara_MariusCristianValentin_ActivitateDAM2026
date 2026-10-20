package com.example.seminarul4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private static final int COD_ADAUGARE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activitate_cuai);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void deschideAdaugare(View view) {
        Intent intent = new Intent(this, AdaugaCasaActivity.class);
        startActivityForResult(intent, COD_ADAUGARE);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == COD_ADAUGARE && resultCode == RESULT_OK && data != null) {
            Bundle bundle = data.getExtras();
            Casa casa = (Casa) bundle.getSerializable("casa");
            TextView tv = findViewById(R.id.TV_rezultat);
            tv.setText(casa.toString());
            Toast.makeText(this, casa.toString(), Toast.LENGTH_LONG).show();
        }
    }
}