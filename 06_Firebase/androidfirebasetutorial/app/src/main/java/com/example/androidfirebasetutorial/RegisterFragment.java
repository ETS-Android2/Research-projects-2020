package com.example.androidfirebasetutorial;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseUser;

import static android.content.ContentValues.TAG;


/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment extends Fragment {
    Button register_btn = null;
    EditText email = null;
    EditText password = null;

    public RegisterFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        view.findViewById(R.id.btn_register);
        register_btn = view.findViewById(R.id.btn_register);
        email = view.findViewById(R.id.et_email);
        password = view.findViewById(R.id.et_password);

        register_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (email.getText().toString().trim().isEmpty() || password.getText().toString().trim().isEmpty()) {
                    Toast.makeText(getActivity(), "Username or Password empty! ",
                            Toast.LENGTH_SHORT).show();
                } else if (password.getText().toString().trim().length() < 6) {
                    Toast.makeText(getActivity(), "Password too short! ",
                            Toast.LENGTH_SHORT).show();
                } else {
                    registerUser(email.getText().toString().trim(), password.getText().toString().trim());
                }
            }
        });
    }

    private void registerUser(String email, String password) {
        Intent intent = new Intent(getContext(), RealtimeActivity.class);
        startActivity(intent);
    }

}
