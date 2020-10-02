package com.example.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.main.Common.Common;
import com.example.main.Model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rengwuxian.materialedittext.MaterialEditText;


public class Signin extends AppCompatActivity {
   EditText edtPassword,edtPhone;
   Button  btnSign;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        edtPassword=(MaterialEditText)findViewById(R.id.edtPassword);
        edtPhone=(MaterialEditText)findViewById(R.id.edtPhone);
        btnSign=(Button)findViewById(R.id.btnSign);

        final FirebaseDatabase database= FirebaseDatabase.getInstance();
        final DatabaseReference table_user = database.getReference("User");

        btnSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ProgressDialog mDialog= new ProgressDialog(Signin.this);
                mDialog.setMessage("Please waiting");
                mDialog.show();
                table_user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        //Get userinfo
                        if(dataSnapshot.child(edtPhone.getText().toString()).exists()){
                        mDialog.dismiss();
                        User user= dataSnapshot.child(edtPhone.getText().toString()).getValue(User.class);
                        if (user.getPassword().equals(edtPassword.getText().toString())) {
                            Intent homeIntent= new Intent(Signin.this,Home.class);
                            Common.currentUser=user;
                            startActivity(homeIntent);
                            finish();




                        }
                        else{
                            Toast.makeText(Signin.this,"Sign in Fail",Toast.LENGTH_SHORT).show();
                        }
                        }
                        else{
                            Toast.makeText(Signin.this," User not exist in Database",Toast.LENGTH_SHORT).show();
                        }

                    }


                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
            }
        });

    }
}
