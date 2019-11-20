package com.example.examen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button loginButton;
    EditText userInput, passInput;

    String user = "admin";
    String pass = "admin";

    String userText,passText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginButton = findViewById(R.id.loginButton);

        userInput = findViewById(R.id.userInput);
        passInput = findViewById(R.id.passInput);

        loginButton.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        String user = "admin";
        String pass = "admin";

        userText = userInput.getText().toString();
        passText = passInput.getText().toString();

        if(userText.toString().equals(user) && passText.toString().equals(pass)){
            Intent i = new Intent(MainActivity.this, Boletos.class);
            startActivity(i);
        }else{
            Toast.makeText(this,"Ingresa tus datos correctamente",Toast.LENGTH_SHORT).show();
            System.out.println(this.user);
        }

    }
}
