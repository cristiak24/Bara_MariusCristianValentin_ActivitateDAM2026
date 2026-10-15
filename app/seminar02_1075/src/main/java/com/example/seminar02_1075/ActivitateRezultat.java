package com.example.seminar02_1075;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ActivitateRezultat extends AppCompatActivity {

    private int valoare1, valoare2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_activitate_rezultat);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Bundle primit = getIntent().getExtras();
        if (primit != null) {
            String mesaj = primit.getString("mesaj");
            valoare1 = primit.getInt("valoare1");
            valoare2 = primit.getInt("valoare2");
            Toast.makeText(this,
                    mesaj + "\nValori: " + valoare1 + " și " + valoare2,
                    Toast.LENGTH_LONG).show();
        }
    }

    public void trimiteInapoi(View view) {
        Intent rezultat = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString("mesaj_inapoi", "Salut inapoi din activitaterezultat");
        bundle.putInt("suma", valoare1 + valoare2);
        rezultat.putExtras(bundle);

        setResult(RESULT_OK, rezultat);
        finish();
    }
}