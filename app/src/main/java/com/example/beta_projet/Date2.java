package com.example.beta_projet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Date2 extends AppCompatActivity {
    private Button button_retour2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date2);


        button_retour2 = (Button) findViewById(R.id.button_retour2);

        button_retour2.setOnClickListener(new View.OnClickListener() {
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
