package com.riztech.myfirstproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView txtName, txtAddress, txtCountry, txtGender, txtEducation;
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        txtName = findViewById(R.id.txt_name);

        txtAddress = findViewById(R.id.txt_address);

        txtCountry = findViewById(R.id.txt_country);

        txtGender = findViewById(R.id.txt_gender);

        txtEducation = findViewById(R.id.txt_education);

        btnBack = findViewById(R.id.btn_back);


        Intent intent = getIntent();

        String name = intent.getStringExtra(IntentExtra.NAME);
        String address = intent.getStringExtra(IntentExtra.ADDRESS);
        String gender = intent.getStringExtra(IntentExtra.GENDER);
        String country = intent.getStringExtra(IntentExtra.COUNTRY);
        String education = intent.getStringExtra(IntentExtra.EDUCATION);

        txtName.setText(name);
        txtAddress.setText(address);
        txtGender.setText(gender);
        txtCountry.setText(country);
        txtEducation.setText(education);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}
