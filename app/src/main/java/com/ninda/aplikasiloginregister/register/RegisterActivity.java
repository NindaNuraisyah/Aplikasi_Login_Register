package com.ninda.aplikasiloginregister.register;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.ninda.aplikasiloginregister.MainActivity;
import com.ninda.aplikasiloginregister.R;

public class RegisterActivity extends AppCompatActivity {

    EditText et_username, et_email, et_password;
    Button btn_register, btn_nav_login;
    CheckBox checkbox_terms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        et_username = findViewById(R.id.et_username);
        et_email = findViewById(R.id.et_email);
        et_password = findViewById(R.id.et_password);
        btn_register = findViewById(R.id.btn_register);
        btn_nav_login = findViewById(R.id.btn_nav_login);
        checkbox_terms = findViewById(R.id.checkbox_terms);

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = et_username.getText().toString();
                String email = et_email.getText().toString();
                String password = et_password.getText().toString();

                if (username.isEmpty() || email.isEmpty() || password.isEmpty()) {
                    if (username.isEmpty()) {
                        et_username.setError("Username tidak boleh kosong");
                    }
                    if (email.isEmpty()) {
                        et_email.setError("Email tidak boleh kosong");
                    }
                    if (password.isEmpty()) {
                        et_password.setError("Password tidak boleh kosong");
                    }
                } else if (!isValidEmail(email)) {
                    et_email.setError("Email tidak valid");
                } else if (!isValidPassword(password)) {
                    et_password.setError("Password harus memiliki setidaknya 8 karakter");
                } else if (!checkbox_terms.isChecked()) {
                    Toast.makeText(RegisterActivity.this, "Anda harus menyetujui syarat dan ketentuan", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                    intent.putExtra("username", username);
                    intent.putExtra("email", email);
                    intent.putExtra("password", password);
                    startActivity(intent);

                    et_username.setText("");
                    et_email.setText("");
                    et_password.setText("");
                }
            }
        });


        btn_nav_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private boolean isValidEmail(String email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private boolean isValidPassword(String password) {
        return password.length() >= 8;
    }
}
