package com.example.seminarul4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AdaugaCasaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_adauga_casa);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void culegereDate(View view) {
        EditText et = findViewById(R.id.ET_nume);
        EditText etSuprafata = findViewById(R.id.ET_suprafata);
        RadioGroup rg = findViewById(R.id.RG_tip);
        Spinner sp = findViewById(R.id.SP_oras);
        Switch sw = findViewById(R.id.SW_piscina);
        RatingBar rb = findViewById(R.id.RB_rating);
        CheckBox cb = findViewById(R.id.CB_seminar_nou);

        String text = et.getText().toString();
        String suprafataText = etSuprafata.getText().toString();
        Boolean esteSeminarNou = cb.isChecked();

        if (text.isEmpty() || suprafataText.isEmpty()) {
            Toast.makeText(this, "Completeaza numele si suprafata", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!esteSeminarNou) {
            Toast.makeText(this, "Bifeaza confirmarea", Toast.LENGTH_SHORT).show();
            return;
        }

        int suprafata = Integer.parseInt(suprafataText);
        RadioButton rbSelectat = findViewById(rg.getCheckedRadioButtonId());
        String tip = rbSelectat.getText().toString();
        String oras = sp.getSelectedItem().toString();
        boolean arePiscina = sw.isChecked();
        float rating = rb.getRating();

        Casa casa = new Casa(text, suprafata, tip, oras, arePiscina, rating);

        Bundle bundle = new Bundle();
        bundle.putSerializable("casa", casa);
        Intent intent = new Intent();
        intent.putExtras(bundle);
        setResult(RESULT_OK, intent);
        finish();
    }
}