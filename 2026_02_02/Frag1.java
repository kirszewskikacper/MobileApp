package com.example.zadanie;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class Frag1 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_frag1, container, false);

        TextView button = root.findViewById(R.id.button);

        button.setOnClickListener(v -> {

            String mail = ((EditText) root.findViewById(R.id.editTextText)).getText().toString();
            String name = ((EditText) root.findViewById(R.id.editTextText2)).getText().toString();
            String surname = ((EditText) root.findViewById(R.id.editTextText3)).getText().toString();

            boolean emailOK = !TextUtils.isEmpty(mail) && Patterns.EMAIL_ADDRESS.matcher(mail).matches();
            boolean nameOK = !TextUtils.isEmpty(name);
            boolean surnameOK = !TextUtils.isEmpty(surname);

            if (emailOK && nameOK && surnameOK) {

                Bundle data = new Bundle();
                data.putString("mail", mail);
                data.putString("name", name);
                data.putString("surname", surname);

                Frag2 frag2 = new Frag2();
                frag2.setArguments(data);

                FragmentManager fm = getParentFragmentManager();
                fm.beginTransaction()
                        .setReorderingAllowed(true)
                        .replace(R.id.container, frag2)
                        .commit();

            } else {
                Toast.makeText(getActivity(), "Coś z danymi sie nie zgadza", Toast.LENGTH_LONG).show();
            }
        });

        return root;
    }
}