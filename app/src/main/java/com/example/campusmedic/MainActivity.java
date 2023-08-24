package com.example.campusmedic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.campusmedic.databinding.ActivityMainBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    private Button schedule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        replaceFragment(new DashboardFragment());
        binding.bottomNavigationView.setBackground(null);

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {

            switch (item.getItemId()) {
                case R.id.home:
                    replaceFragment(new DashboardFragment());
                    break;

                case R.id.appointment:
                    replaceFragment(new BookAppointment());
                    break;

                case R.id.events:
                    replaceFragment(new Events());
                    break;

                case R.id.profile:
                    replaceFragment(new ProfileActivity());
                    break;
            }
            return true;

        });

        binding.fitness.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadEventSignUpFragment();
            }
        });
    }
    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManger = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManger.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }

    private void loadEventSignUpFragment() {
        EventSignUp eventSignUpFragment = new EventSignUp();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, eventSignUpFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

}