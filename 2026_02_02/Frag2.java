package com.example.zadanie;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class Frag2 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_frag2, container, false);

        Bundle data = getArguments();
        String mail = data != null ? data.getString("mail") : "";
        String name = data != null ? data.getString("name") : "";
        String surname = data != null ? data.getString("surname") : "";

        TextView t1 = root.findViewById(R.id.textView2);
        TextView t2 = root.findViewById(R.id.textView7);
        TextView t3 = root.findViewById(R.id.textView8);

        t1.setText(mail);
