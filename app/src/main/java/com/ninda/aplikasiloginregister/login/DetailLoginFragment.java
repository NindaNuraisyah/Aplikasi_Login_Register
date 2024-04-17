package com.ninda.aplikasiloginregister.login;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.ninda.aplikasiloginregister.R;

public class DetailLoginFragment extends Fragment {

    TextView resultUsername, resultPassword;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail_login, container, false);

        resultUsername = view.findViewById(R.id.resultUsername);
        resultPassword = view.findViewById(R.id.resultPassword);

        Bundle bundle = getArguments();
        if (bundle != null) {
            String username = bundle.getString("username");
            String password = bundle.getString("password");

            resultUsername.setText(username);
            resultPassword.setText(password);
        }

        return view;
    }
}

