package com.ggave.sharedpreferencesapp.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.ggave.sharedpreferencesapp.R;

public class EncuestaActivity extends AppCompatActivity {

    private EditText fullname;
    private EditText carrera;
    private RadioGroup radio;
    private Button enviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encuesta);

        fullname = findViewById(R.id.fullname_edit);
        carrera = findViewById(R.id.carrera_input);
        radio = findViewById(R.id.radioGroup);
        enviar = findViewById(R.id.enviar_button);

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }
}
