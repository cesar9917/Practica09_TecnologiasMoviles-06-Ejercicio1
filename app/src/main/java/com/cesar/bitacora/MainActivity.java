package com.cesar.bitacora;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private EditText txtCorreo;
    private EditText txtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();

        txtCorreo = findViewById(R.id.txtCorreo);
        txtPassword = findViewById(R.id.txtPassword);

        Button btnRegistrar = findViewById(R.id.btnRegistrar);
        Button btnLogin = findViewById(R.id.btnLogin);

        btnRegistrar.setOnClickListener(v -> registrar());

        btnLogin.setOnClickListener(v -> login());
    }
    private void registrar() {

        String correo = txtCorreo.getText().toString().trim();
        String password = txtPassword.getText().toString().trim();

        mAuth.createUserWithEmailAndPassword(correo, password)
                .addOnCompleteListener(task -> {

                    if (task.isSuccessful()) {
                        Toast.makeText(
                                this,
                                "Usuario registrado",
                                Toast.LENGTH_SHORT
                        ).show();
                    } else {
                        Toast.makeText(
                                this,
                                task.getException().getMessage(),
                                Toast.LENGTH_LONG
                        ).show();
                    }
                });
    }
    private void login() {

        String correo = txtCorreo.getText().toString().trim();
        String password = txtPassword.getText().toString().trim();

        mAuth.signInWithEmailAndPassword(correo, password)
                .addOnCompleteListener(task -> {

                    if (task.isSuccessful()) {
                        Toast.makeText(
                                this,
                                "Login exitoso",
                                Toast.LENGTH_SHORT
                        ).show();
                    } else {
                        Toast.makeText(
                                this,
                                "Correo o contraseña incorrectos",
                                Toast.LENGTH_SHORT
                        ).show();
                    }
                });
    }
}