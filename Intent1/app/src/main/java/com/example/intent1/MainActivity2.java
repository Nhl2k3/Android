package com.example.intent1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {
    TextView txtNghiem;
    Button btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        txtNghiem = findViewById(R.id.txtNghiem);
        btnBack = findViewById(R.id.btnBack);
        // Nhận Intent
        Intent myIntent = getIntent();
        // Lấy Bundle khỏi Intent
        Bundle myBundle = myIntent.getBundleExtra("mypackage");
        // Lấy dự liệu ra
        int a = myBundle.getInt("soa");
        int b = myBundle.getInt("sob");
        // Tiến hành giải phương trình và hiển thị kết quả
        String nghiem = " ";
        if(a==0 && b==0){
            nghiem ="Phương trình vô số nghiệm";
        }else if(a == 0 && b !=0){
            nghiem = "Phương trình vô nghiệm";
        }else{
            nghiem = "Nghiệm phương trình  = " + (-1.0)*b/a;
        }
        // Hiển thị kết quả
        txtNghiem.setText(nghiem);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}