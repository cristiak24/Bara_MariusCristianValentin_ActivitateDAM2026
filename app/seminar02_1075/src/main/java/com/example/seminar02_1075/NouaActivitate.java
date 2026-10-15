package com.example.seminar02_1075;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class NouaActivitate extends AppCompatActivity {
    private final ActivityResultLauncher<Intent> launcher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                    Bundle date = result.getData().getExtras();
                    String mesaj = date.getString("mesaj_inapoi");
                    int suma = date.getInt("suma");
                    Toast.makeText(this, mesaj + "\nSuma: " + suma, Toast.LENGTH_LONG).show();
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_noua_activitate);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void openActivity(View view) {
        Intent it = new Intent(this, ActivitateRezultat.class);
        Bundle bundle = new Bundle();
        bundle.putString("mesaj", "salut din NouaActivitate!");
        bundle.putInt("valoare1", 7);
        bundle.putInt("valoare2", 5);
        it.putExtras(bundle);

        launcher.launch(it);
    }
}