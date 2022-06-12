package com.example.currency_caculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Spinner sp1, sp2;
    TextView input, result;
    String inputValue="0", resultValue="";

    String sp1Value, sp2Value;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp1 = findViewById(R.id.convertFrom);
        sp2 = findViewById(R.id.convertTo);
        input = findViewById(R.id.inputText);
        result = findViewById(R.id.resultText);
        input.setText("0");
        result.setText("0");
        String[] from = {"USA_USD", "JAPAN_YEN"};
        ArrayAdapter ad1 = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, from);
        sp1.setAdapter(ad1);

        String[] to = {"VIETNAM_VND", "RUSSIA_ROUBLE"};
        ArrayAdapter ad2 = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, to);
        sp2.setAdapter(ad2);

        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
//                inputValue = "";
                convert();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });
        sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                convert();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });

    }
    public void clearInput(View view)
    {
        input.setText("0");
        result.setText("0");
        inputValue = "";
    }

    public void setInput(String givenValue)
    {
        if(inputValue=="0") {inputValue = givenValue; input.setText(inputValue);}
        else {
            inputValue = inputValue + givenValue;
            input.setText(inputValue);
        }
    }

    public void convert() {
        sp1Value = sp1.getSelectedItem().toString();
        sp2Value = sp2.getSelectedItem().toString();
        switch (sp1Value) {
            case "USA_USD":
                if(sp2Value == "VIETNAM_VND") {
                    Double tmp1 = Double.parseDouble(inputValue)*23000;
                    result.setText(tmp1.toString());
                }
                else if(sp2Value == "RUSSIA_ROUBLE") {
                    Double tmp1 = Double.parseDouble(inputValue)*55.75;
                    result.setText(tmp1.toString());
                }
                break;
            case "JAPAN_YEN":
                if(sp2Value == "VIETNAM_VND") {
                    Double tmp1 = Double.parseDouble(inputValue)*172;
                    result.setText(tmp1.toString());
                }
                else if(sp2Value == "RUSSIA_ROUBLE") {
                    Double tmp1 = Double.parseDouble(inputValue)*0.41;
                    result.setText(tmp1.toString());
                }
                break;
        }
    }

    public void sevenOnclick(View view) {
        setInput("7");
        convert();
    }

    public void eightOnclick(View view) {
        setInput("8");
        convert();

    }

    public void nineOnclick(View view) {
        setInput("9");
        convert();

    }

    public void fourOnclick(View view) {
        setInput("4");
        convert();

    }

    public void fiveOnclick(View view) {
        setInput("5");
        convert();

    }

    public void sixOnclick(View view) {
        setInput("6");
        convert();

    }

    public void oneOnclick(View view) {
        setInput("1");
        convert();

    }

    public void twoOnclick(View view) {
        setInput("2");
        convert();

    }

    public void threeOnclick(View view) {
        setInput("3");
        convert();

    }

    public void zeroOnclick(View view) {
        setInput("0");
        convert();

    }
}