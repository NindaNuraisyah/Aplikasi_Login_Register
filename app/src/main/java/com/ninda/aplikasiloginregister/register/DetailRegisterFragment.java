package com.ninda.aplikasiloginregister.register;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.ninda.aplikasiloginregister.R;

public class DetailRegisterFragment extends Fragment {

    TextView resultUsername, resultEmail, resultPassword;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail_register, container, false);

        resultUsername = view.findViewById(R.id.resultUsername);
        resultEmail = view.findViewById(R.id.resultEmail);
        resultPassword = view.findViewById(R.id.resultPassword);

        Bundle bundle = getArguments();
        if (bundle != null) {
            String username = bundle.getString("username");
            String email = bundle.getString("email");
            String password = bundle.getString("password");

            resultUsername.setText(username);
            resultEmail.setText(email);
            resultPassword.setText(password);
        }

        return view;
    }
}
