package com.example.beta_projet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;


public class MainActivity extends AppCompatActivity {
    private Button btn;
    private EditText produit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


       // produit = (EditText)findViewById(R.id.produit);
        btn = (Button) findViewById(R.id.valider);


        //btn.setText("Validez");
        btn.setOnClickListener(new View.OnClickListener() {


            @Override
             public void onClick(View view) {
             System.out.println(produit.getText());
             visualiser_la_suite();

             }
             });
             }
             /* SmsManager sms = SmsManager.getDefault();
             String X = "0646890981"; //numéro à appeler
              String texte = "Salut de ma superbe appli Android"; //texte à envoyer
              sms.sendTextMessage(X, null, texte, null, null);
                  */
             

             private void visualiser_la_suite()
             {
             Intent intent = new Intent(this, Date.class);
             startActivity(intent);
             }
        }

    
