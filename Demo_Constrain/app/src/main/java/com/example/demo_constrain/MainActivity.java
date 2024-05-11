package com.example.demo_constrain;

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
    EditText edtA, edtB, edtKQ;
    Button btnTong;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        // Ánh xạ Id cho biến của giao diện
        edtA = findViewById(R.id.edtA);
        edtB = findViewById(R.id.edtB);
        edtKQ = findViewById(R.id.edtKQ);
        btnTong = findViewById(R.id.btnTong);
        // Xủa lý tương tác với người dùng
        btnTong.setOnClickListener(new View.OnClickListener() {
            @Override
            // lấy dữ liệu về là get, hiển thị dữ liệu là set
            public void onClick(View v) {
                int a = Integer.parseInt(edtA.getText().toString()); // lấy dữ liệu edtA, gán sang biến A
                int b = Integer.parseInt(edtB.getText().toString());
                int c = a + b;

                edtKQ.setText(c+""); // Hiển thị kết quả
            }
        });
        
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}