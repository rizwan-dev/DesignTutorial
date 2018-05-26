package com.riztech.myfirstproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class DesignActivity extends AppCompatActivity {

    EditText edtName, edtAddress;

    RadioGroup rdgGender;


    String[] countries = {"India", "USA", "UK"};

    CheckBox chb10th, chb12th, chbGraduation, chbPG;

    private static final String NEXT = "\n";

    Button btnSend;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_design);

        edtName = findViewById(R.id.edt_name);
        edtAddress = findViewById(R.id.edt_address);
        rdgGender = findViewById(R.id.rdg_gender);

        chb10th = findViewById(R.id.chb10);
        chb12th = findViewById(R.id.chb12);
        chbGraduation = findViewById(R.id.chb_graduation);
        chbPG = findViewById(R.id.chb_pg);
        btnSend = findViewById(R.id.btn_send);

        final Spinner spnCountry = findViewById(R.id.spn_country);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,countries);

        spnCountry.setAdapter(adapter);


        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = edtName.getText().toString().trim();

                if (TextUtils.isEmpty(name)) {
                    showToast("Please enter name");
                    return;
                }
                String address = edtAddress.getText().toString().trim();
                if (TextUtils.isEmpty(address)) {
                    showToast("Please enter address");
                    return;
                }

                String gender = null;

                int id = rdgGender.getCheckedRadioButtonId();

                switch (id) {
                    case R.id.rdb_male:
                        gender = "Male";
                        break;
                    case R.id.rdb_female:
                        gender = "Female";
                        break;
                    default:
                        gender = "";
                        break;
                }

                if (TextUtils.isEmpty(gender)) {
                    showToast("Please enter gender");
                    return;
                }

                StringBuilder educationBuilder = new StringBuilder();

                if(chb10th.isChecked()){
                    educationBuilder.append("10th ");
                }

                if(chb12th.isChecked()){
                    educationBuilder.append("12th ");
                }

                if(chbGraduation.isChecked()){
                    educationBuilder.append("Graduation ");
                }

                if(chbPG.isChecked()){
                    educationBuilder.append("PG ");
                }

                String education = educationBuilder.toString().trim();

                if(TextUtils.isEmpty(education)){
                    showToast("Please select your education");
                    return;
                }

                String country = (String) spnCountry.getSelectedItem();

                StringBuilder messageBuilder = new StringBuilder();

                messageBuilder.append("Name : ").append(name).append(NEXT)
                        .append("Address : ").append(address).append(NEXT)
                        .append("Gender : ").append(gender).append(NEXT)
                        .append("Country : ").append(country)
                        .append("Education : ").append(education);

                showToast(messageBuilder.toString());


            }
        });



    }

    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
