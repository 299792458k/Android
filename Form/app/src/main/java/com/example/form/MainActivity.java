package com.example.form;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public String  mssv, fullname, cccd, sdt, email, dateofbirth, address, addressnow;

    // check form validation
    Boolean isFormValid = true;

    Boolean isMajor = false;
    //check current state of the check box
    Boolean checkBoxState ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get all edit text
        EditText mssvText = (EditText) findViewById(R.id.mssv);

        EditText fullnameText = (EditText) findViewById(R.id.fullname);

        EditText cccdText = (EditText) findViewById(R.id.cccd);

        EditText sdtText = (EditText) findViewById(R.id.sdt);

        EditText emailText = (EditText) findViewById(R.id.email);

        EditText dateofbirthText = (EditText) findViewById(R.id.dateofbirth);

        EditText addressText = (EditText) findViewById(R.id.address);

        EditText addressnowText = (EditText) findViewById(R.id.addressnow);

        //initiate a checkbox
        CheckBox agreeCheckBox = (CheckBox) findViewById(R.id.agree);

        Button submit = findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mssv = mssvText.getText().toString();
                fullname = fullnameText.getText().toString();
                cccd = cccdText.getText().toString();
                sdt = sdtText.getText().toString();
                email = emailText.getText().toString();
                dateofbirth = dateofbirthText.getText().toString();
                address = addressText.getText().toString();
                addressnow = addressnowText.getText().toString();
                checkBoxState = agreeCheckBox.isChecked();

//                Decide what happens when the user clicks the submit button
                if(mssv.isEmpty() || fullname.isEmpty() || cccd.isEmpty() ||
                        sdt.isEmpty() || email.isEmpty() || dateofbirth.isEmpty() ||
                        address.isEmpty() || addressnow.isEmpty() || !isMajor) isFormValid = false;
                else isFormValid = true;
                if(!isFormValid) Toast.makeText(MainActivity.this, "Please fill out all the fields!", Toast.LENGTH_SHORT).show();
                else if(!checkBoxState)
                    Toast.makeText(MainActivity.this, "Please agree!", Toast.LENGTH_SHORT).show();
                else Toast.makeText(MainActivity.this, "Submitted!", Toast.LENGTH_SHORT).show();

            }
        });

        CheckBox cBox = (CheckBox) findViewById(R.id.c);
        Boolean cState = cBox.isChecked();
        CheckBox javaBox = (CheckBox) findViewById(R.id.java);
        Boolean javaState = javaBox.isChecked();
        CheckBox pythonBox = (CheckBox) findViewById(R.id.python);
        Boolean pythonState = pythonBox.isChecked();

        
    }

    public void radioButtonhandler(View view) {
        isMajor = ((RadioButton) view).isChecked();
    }
}