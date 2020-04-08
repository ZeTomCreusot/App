package com.example.beta_projet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BDS_P extends AppCompatActivity {

    private Button button_retour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bds__p);

        button_retour = (Button) findViewById(R.id.button_retour2);

        button_retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                visualiser_la_suite();
            }
        });
    }

    private void visualiser_la_suite()
    {
        Intent intent = new Intent(this, Date.class);
        startActivity(intent);
    }
}
