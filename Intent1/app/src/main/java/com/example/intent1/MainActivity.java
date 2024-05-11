package com.example.intent1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    // Khai báo biến
    EditText txtsoA, txtsoB;
    Button bntKQ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        // Ánh xạ
        txtsoA = findViewById(R.id.txtsoA);
        txtsoB = findViewById(R.id.txtsoB);
        bntKQ = findViewById(R.id.bntKQ);
        // Xử lý thao tác với người dùng
        bntKQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Khai báo Intent
                Intent myintent = new Intent(MainActivity.this, MainActivity2.class);
                // Lấy dữ liệu
                int a = Integer.parseInt(txtsoA.getText().toString());
                int b = Integer.parseInt(txtsoB.getText().toString());
                // Đóng gói dữ liệu Bundle
                Bundle mybundle = new Bundle();
                mybundle.putInt("soa",a);
                mybundle.putInt("sob",b);
                // Đưa Bundle vào Intent
                myintent.putExtra("mypackage",mybundle);
                // Khởi động Intent
                startActivity(myintent);
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}