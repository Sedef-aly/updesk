package com.example.updesk.EmployerActivities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.updesk.ModelClasses.JavaMailAPI;
import com.example.updesk.Utilities.CONSTANTS;
import com.example.updesk.Utilities.PreferenceManager;
import com.example.updesk.databinding.ActivityEmployerResetPasswordBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.Random;

public class EmployerResetPassword extends AppCompatActivity {
    private ActivityEmployerResetPasswordBinding binding;
    private FirebaseFirestore firebaseFirestore;
boolean emailsent=false;

PreferenceManager pref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEmployerResetPasswordBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        firebaseFirestore = FirebaseFirestore.getInstance();
        pref = new PreferenceManager(this);
        binding.mtBtnEmployerLogIn.setOnClickListener(view -> {
loading(true);
            if(binding.etemail.getText().toString().trim().isEmpty())
            {
                loading(false);
                ShowToast("Please enter email first");
            }
            else {


                if(binding.empchkbox.isChecked()){
                    CONSTANTS.resetkey="Employer";
                    CONSTANTS.resetemail="employerEmail";
                    CONSTANTS.resetusrID="employerID";
                    CONSTANTS.resetPassowrd="employerPassword";

                }else{
                    CONSTANTS.resetkey="Employee";
                    CONSTANTS.resetemail="employeeEmail";
                    CONSTANTS.resetusrID="employeeID";
                    CONSTANTS.resetPassowrd="employeePassword";
                }
                firebaseFirestore.collection(CONSTANTS.resetkey)
                        .whereEqualTo(CONSTANTS.resetemail, binding.etemail.getText().toString().trim())
                        .get()
                        .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                if (task.isSuccessful() && task.getResult().getDocuments().size() > 0) {
                                    DocumentSnapshot documentSnapshot= task.getResult().getDocuments().get(0);

                                    pref.putString(CONSTANTS.resetusrID,documentSnapshot.getId());
                                    Random random=new Random();
                                    CONSTANTS.cc= 1000+ random.nextInt(10000-1000);
                                    ShowToast(String.valueOf(CONSTANTS.cc));
                                    pref.putString("cc",String.valueOf(CONSTANTS.cc));
                                 sendemail();

                                } else{
                                    loading(false);
                                    ShowToast("Please Enter Valid and Registered Email");
                                }
                            }


                        });
            }
        });

    }

    private void shiftActivity() {
        Intent i=new Intent(getApplicationContext(),ChangePasswordActivity.class);
        loading(false);
        startActivity(i);

        finish();
    }

    private void loading(boolean isLoading)
    {
        if(isLoading)
        {
            binding.mtBtnEmployerLogIn.setVisibility(View.INVISIBLE);
            binding.ProgressBarLogin.setVisibility(View.VISIBLE);
        }
        else
        {
            binding.mtBtnEmployerLogIn.setVisibility(View.VISIBLE);
            binding.ProgressBarLogin.setVisibility(View.INVISIBLE);
        }
    }
    private void ShowToast(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }


    private boolean sendemail() {

        JavaMailAPI javaMailAPI= new JavaMailAPI(this,binding.etemail.getText().toString(),
                "Email Verification code!",
                "Your Confirmation Code is: "+ CONSTANTS.cc +" please enter this to reset your Password");
        javaMailAPI.execute();
        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        builder.setMessage("You'll receive Confirmation Code through email,Please check your email")
                .setPositiveButton("OK",(dialogInterface, i) -> {



              shiftActivity();


                }).show();
        Log.d("Emaillll",binding.etemail.getText().toString());
        return emailsent;
    }
    }
