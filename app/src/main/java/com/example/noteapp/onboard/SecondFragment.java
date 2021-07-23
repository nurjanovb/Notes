package com.example.noteapp.onboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.noteapp.R;
import com.example.noteapp.databinding.FragmentSecpndBinding;
import com.example.noteapp.utisl.PreferncesHelper;

public class SecondFragment extends Fragment {

    FragmentSecpndBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSecpndBinding.inflate(inflater, container, false);
        setClickListener();
        return binding.getRoot();
    }

    private void setClickListener() {
        binding.send.setOnClickListener(v -> {
            PreferncesHelper sharedPref = new PreferncesHelper();
            sharedPref.init(requireContext());
            sharedPref.OnSaveOnboardState();
            close();
        });
    }

    private void close() {
        NavController navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment_content_main);
        navController.navigateUp();
    }
}