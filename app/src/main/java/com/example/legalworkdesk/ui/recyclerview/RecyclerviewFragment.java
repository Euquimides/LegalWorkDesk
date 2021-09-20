package com.example.legalworkdesk.ui.recyclerview;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.example.legalworkdesk.R;

public class RecyclerviewFragment {

    public View onCreateView (@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_recyclerview, container, false);
        return root;

    }
}
