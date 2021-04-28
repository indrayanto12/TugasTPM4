package com.example.myrecyclerview;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


public class home extends Fragment {
    private RecyclerView recyclerView;
    private ArrayList<User> users = new ArrayList<>();

    public View v;

    public home() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = v.findViewById(R.id.rv_recycleView);
        recyclerView.setHasFixedSize(true);

        users.addAll(UserData.getListData());
        showRecycleView();


        TextView name = v.findViewById(R.id.name);
        /* Men-set Label Nama dengan data User sedang login dari Preferences */
        name.setText(Preferences.getLoggedInUser(getActivity()));

        v.findViewById(R.id.Logout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Menghapus Status login dan kembali ke Login Activity
                Preferences.clearLoggedInUser(getActivity());
                startActivity(new Intent(getActivity(), Login.class));
                finish();
            }

            private void finish() {
            }
        });
        return v;
    }

    private void showRecycleView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        UserAdapter adapter = new UserAdapter(UserData.getListData(), getActivity());
        recyclerView.setAdapter(adapter);
    }
}