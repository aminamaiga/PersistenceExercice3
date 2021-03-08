package fr.umontpellier.persistenceexercice3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleObserver;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private EditText editTexNom, editTextPrenom, editTextAge, editTextPhone;
    private Button soumettre;
    TextView nbFois;
    MainActivity2Utilisation m =  new MainActivity2Utilisation();
    int count_save = 0;
    final static String COUNT = "COUNT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTexNom = (EditText) findViewById(R.id.editext_nom);
        editTextPrenom = (EditText) findViewById(R.id.editext_prenom);
        editTextAge = (EditText) findViewById(R.id.editext_age);
        editTextPhone = (EditText) findViewById(R.id.editext_phone);
        soumettre = (Button)findViewById(R.id.soumettre);
        nbFois = (TextView)findViewById(R.id.nb_fois);

        if (savedInstanceState != null && savedInstanceState.containsKey(COUNT))
        {
           count_save = savedInstanceState.getInt(COUNT);
        }

        soumettre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count_save = m.count;
                nbFois.setText(count_save + "");
                Toast.makeText(getApplicationContext(),
                        "COUNT : " + count_save +
                                     "\n Prenom : " + editTextPrenom.getText().toString() +
                                     "\n Nom : " + editTexNom.getText().toString() +
                                     "\n Age : " + editTextAge.getText().toString() +
                                      "\n Téléphone : " + editTextPhone.getText().toString()
                        ,
                       Toast.LENGTH_LONG ).show();
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        getLifecycle().addObserver((LifecycleObserver) new MainActivity2Utilisation());
        Toast.makeText(getApplicationContext(), "OnResume", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(COUNT, count_save);
    }
}