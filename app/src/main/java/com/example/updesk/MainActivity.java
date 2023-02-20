package com.example.updesk;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.updesk.LoginActivities.EmployerLoginActivity;
import com.example.updesk.Utilities.CONSTANTS;
import com.example.updesk.Utilities.PreferenceManager;
import com.example.updesk.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    FirebaseFirestore firebaseFirestore;
    StorageReference storageReference;
    PreferenceManager pref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        firebaseFirestore= FirebaseFirestore.getInstance();
        storageReference= FirebaseStorage.getInstance().getReference();
        pref = new PreferenceManager(this);
        if(pref.getBoolean(CONSTANTS.IS_EMPLOYEE_SIGN_UP)) {
            binding.txtWelcome.setText(pref.getString(CONSTANTS.EMPLOYEE_NAME)+".. Glad to see you Again");
        } else if (pref.getBoolean(CONSTANTS.IS_EMPLOYER_SIGN_UP)) {

            binding.txtWelcome.setText("Welcome Back!!"+pref.getString(CONSTANTS.EMPLOYER_NAME));
        }
        NavHostFragment navHostFragment=(NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentcontainer);
        NavigationUI.setupWithNavController(binding.bottomnav,navHostFragment.getNavController());
        setListeners();
    }



    private void setListeners() {
        binding.mtBtnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pref.clear();
                pref.putBoolean(CONSTANTS.IS_EMPLOYER_SIGN_UP,false);
                Intent intent=new Intent(MainActivity.this, EmployerLoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}