package com.example.chuyendoinhietdo;

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
    EditText edtC, edtF;
    Button btnC, btnF, btnXoa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        edtC = findViewById(R.id.edtC);
        edtF = findViewById(R.id.edtF);
        btnC = findViewById(R.id.btnC);
        btnF = findViewById(R.id.btnF);
        btnXoa = findViewById(R.id.btnXoa);

        btnF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int C = Integer.parseInt(edtC.getText().toString());
                double F = C * 9/5 + 32;

                edtF.setText(F + "");
            }
        });

        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int F = Integer.parseInt(edtF.getText().toString());
                double C = (F - 32) * 5/9;

                edtC.setText(C+"");
            }
        });

        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtF.setText("");
                edtC.setText("");
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}