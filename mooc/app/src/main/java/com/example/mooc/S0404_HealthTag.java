package com.example.mooc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class S0404_HealthTag extends AppCompatActivity {

    private EditText editTextName,editTextNum;
    private RadioButton radioButton1,radioButton2;
    private CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.s0404_health_tag);

        editTextName = findViewById(R.id.editTextTextPersonName);
        editTextNum = findViewById(R.id.editTextTextPersonName2);
        radioButton1 = findViewById(R.id.radioButton);
        radioButton2 = findViewById(R.id.radioButton2);
        checkBox = findViewById(R.id.checkBox);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editTextName.getText().toString().trim();
                String num = editTextNum.getText().toString().trim();

                boolean temp = radioButton1.isChecked()? true : false;

                if (name.isEmpty() || num.isEmpty()){
                    Toast.makeText(S0404_HealthTag.this,"姓名和号码不能为空",Toast.LENGTH_SHORT).show();
                }else if (!radioButton1.isChecked() && !radioButton2.isChecked()){
                    Toast.makeText(S0404_HealthTag.this,"请勾选体温情况",Toast.LENGTH_SHORT).show();
                }else if (!checkBox.isChecked()){
                    Toast.makeText(S0404_HealthTag.this,"请勾选本人知情同意",Toast.LENGTH_SHORT).show();
                }else {
                    Intent intent = new Intent(S0404_HealthTag.this,S0404_HealthTag2.class);
                    intent.putExtra("temp",temp);
                    intent.putExtra("name",name);
                    intent.putExtra("num",num);
                    startActivity(intent);
                }
            }
        });
    }
}