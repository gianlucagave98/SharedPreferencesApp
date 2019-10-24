package com.ggave.sharedpreferencesapp.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.ggave.sharedpreferencesapp.R;
import com.ggave.sharedpreferencesapp.models.User;
import com.ggave.sharedpreferencesapp.repository.UserRepository;

public class LoginActivity extends AppCompatActivity {

    private View loginPanel;
    private EditText usernameInput;
    private EditText passwordInput;
    private Button signinButton;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginPanel = findViewById(R.id.login_panel);
        usernameInput = findViewById(R.id.username_input);
        passwordInput = findViewById(R.id.password_input);
        signinButton = findViewById(R.id.signin_button);
        progressBar = findViewById(R.id.progressbar);

        signinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dologin();
            }
        });
    }
    private void dologin(){
        String username = usernameInput.getText().toString();
        String password = passwordInput.getText().toString();
        if(username.isEmpty()){
            usernameInput.setError("Ingrese usuario");
            Toast.makeText(this,"Ingrese usuario", Toast.LENGTH_SHORT).show();
            return;
        }
        if(password.isEmpty()){
            passwordInput.setError("Ingrese password");
            Toast.makeText(this,"Ingrese password", Toast.LENGTH_SHORT).show();
            return;
        }
        loginPanel.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);
        User user = UserRepository.login(username,password);
        if(user==null){
            Toast.makeText(this,"Clave e usuario invalido", Toast.LENGTH_SHORT).show();
            loginPanel.setVisibility(View.VISIBLE);
            progressBar.setVisibility(View.GONE);
            return;
        }

        SharedPreferences sp =PreferenceManager.getDefaultSharedPreferences(this);
        sp.edit()
                .putBoolean("islogged", true)
                .putString("username", username)
                .commit();

        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
    private void loadLastUsername() {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        String username = sp.getString("username", null);
        if(username != null) {
            usernameInput.setText(username);
            passwordInput.requestFocus();
        }
    }
}
