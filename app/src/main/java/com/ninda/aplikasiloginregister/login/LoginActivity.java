package com.ninda.aplikasiloginregister.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.ninda.aplikasiloginregister.MainActivity;
import com.ninda.aplikasiloginregister.R;
import com.ninda.aplikasiloginregister.register.RegisterActivity;

public class LoginActivity extends AppCompatActivity {

    EditText et_username, et_password;
    Button btn_login, btn_nav_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        et_username = findViewById(R.id.et_username);
        et_password = findViewById(R.id.et_password);
        btn_login = findViewById(R.id.btn_login);
        btn_nav_register = findViewById(R.id.btn_nav_register);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = et_username.getText().toString().trim();
                String password = et_password.getText().toString();

                if (username.isEmpty() || password.isEmpty()) {
                    if (username.isEmpty()) {
                        et_username.setError("Username tidak boleh kosong");
                    }
                    if (password.isEmpty()) {
                        et_password.setError("Password tidak boleh kosong");
                    }
                } else if (!isValidPassword(password)) {
                    et_password.setError("Password harus memiliki setidaknya 8 karakter");
                } else {
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    intent.putExtra("username", username);
                    intent.putExtra("password", password);
                    startActivity(intent);

                    et_username.setText("");
                    et_password.setText("");
                }
            }
        });


        btn_nav_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
    private boolean isValidPassword(String password) {
        return password.length() >= 8;
    }
}
