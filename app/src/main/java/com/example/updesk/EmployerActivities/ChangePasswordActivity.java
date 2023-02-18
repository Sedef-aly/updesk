package com.example.updesk.EmployerActivities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.updesk.LoginActivities.EmployeeLoginActivity;
import com.example.updesk.Utilities.CONSTANTS;
import com.example.updesk.Utilities.PreferenceManager;
import com.example.updesk.databinding.ActivityChangePasswordBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.Objects;

public class ChangePasswordActivity extends AppCompatActivity {
    ActivityChangePasswordBinding binding;
    private FirebaseFirestore firebaseFirestore;
    PreferenceManager pref;
    String sentcode="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityChangePasswordBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());
        firebaseFirestore = FirebaseFirestore.getInstance();
        pref = new PreferenceManager(this);
     sentcode=pref.getString("cc");
 binding.verifybtn.setOnClickListener(View ->{
     checkcc(binding.etcc.getText().toString().trim());
 });




    }

    private void checkcc(String code) {
        Log.d("code i entered",code);
        Log.d("code in pref",sentcode);
        if (code.equals(sentcode)) {

            ShowToast("Email Verified");
            changepassword(true);
            binding.btnchangepassword.setOnClickListener(view -> {
               firebaseFirestore.collection(CONSTANTS.resetkey)
                       .document(pref.getString(CONSTANTS.resetusrID))
                       .update(CONSTANTS.resetPassowrd,binding.txtpswrd.getText().toString());

                                    Intent i=new Intent(getApplicationContext(), EmployeeLoginActivity.class);
                                    startActivity(i);
                                    finish();

                        });


        }
        else{
            ShowToast("Email verification Failed!Kindly Retry");
        }

    }

    private void ShowToast(String s) {
        Toast.makeText(getApplicationContext(),s,Toast.LENGTH_SHORT).show();
    }


    private void changepassword( boolean b){
                if (b == true) {
                    binding.linearlayoutcc.setVisibility(View.INVISIBLE);
                    binding.linearlayoutcp.setVisibility(View.VISIBLE);
                }
            }

        }

