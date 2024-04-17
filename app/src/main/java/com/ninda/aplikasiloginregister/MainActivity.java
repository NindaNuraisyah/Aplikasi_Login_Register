package com.ninda.aplikasiloginregister;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.ninda.aplikasiloginregister.login.DetailLoginFragment;
import com.ninda.aplikasiloginregister.register.DetailRegisterFragment;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String username = extras.getString("username");
            String email = extras.getString("email");
            String password = extras.getString("password");

            if (email != null) {
                loadDetailRegisterFragment(username, email, password);
            } else {
                loadDetailLoginFragment(username, password);
            }
        }
    }

    public void loadDetailLoginFragment(String username, String password) {
        DetailLoginFragment fragment = new DetailLoginFragment();

        Bundle bundle = new Bundle();
        bundle.putString("username", username);
        bundle.putString("password", password);
        fragment.setArguments(bundle);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(null)
                .commit();
    }

    public void loadDetailRegisterFragment(String username, String email, String password) {
        DetailRegisterFragment fragment = new DetailRegisterFragment();

        Bundle bundle = new Bundle();
        bundle.putString("username", username);
        bundle.putString("email", email);
        bundle.putString("password", password);
        fragment.setArguments(bundle);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(null)
                .commit();
    }

}

