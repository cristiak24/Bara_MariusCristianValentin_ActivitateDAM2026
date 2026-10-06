package com.example.seminar02_1075;

import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.util.Log;

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
    }
//
//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
//        super.onCreate(savedInstanceState, persistentState);
//    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("Seminar", "Start");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.w("seminar", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("seminar", "onPause");
    }


    @Override
    protected void onStop() {
        super.onStop();
        Log.i("seminar","onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v("seminar","onDestroy");
    }


}