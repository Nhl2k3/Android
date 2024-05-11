package com.example.thietkegiaodiencoban;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText edtHoTen, edtCmnd, edtBoSung;
    Button btnGui;
    RadioGroup rdGroup;
    CheckBox chkGame, chkMusic, chkBall;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        // Ánh xạ
        edtHoTen = findViewById(R.id.edtHoTen);
        edtCmnd = findViewById(R.id.edtCmnd);
        edtBoSung = findViewById(R.id.edtBoSung);
        rdGroup = findViewById(R.id.rdGroup);
        chkGame = findViewById(R.id.chkGame);
        chkMusic = findViewById(R.id.chkMusic);
        chkBall = findViewById(R.id.chkBall);
        btnGui = findViewById(R.id.btnGui);
        // Lấy dữ liệu
        btnGui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Lấy thông tin họ tên
               String hoten = edtHoTen.getText().toString();
               if(hoten.length()<3){
                   Toast.makeText(MainActivity.this, "Họ tên phải lớn hơn 3 ký tự", Toast.LENGTH_LONG).show();
                   edtHoTen.requestFocus(); // Đặt con trỏ trở lại
                   edtHoTen.selectAll(); // Bôi đen
                   return;
               }
               // Lấy thông tin cmnd
                String cmnd = edtCmnd.getText().toString();
               if(cmnd.length()!=9){
                   Toast.makeText(MainActivity.this, "Số chứng minh phải đúng 9 số", Toast.LENGTH_LONG).show();
                   edtCmnd.requestFocus();
                   edtCmnd.selectAll();
                   return;
               }
               // Lấy thông tin bằng cấp
                int rdchoose = rdGroup.getCheckedRadioButtonId();
                RadioButton rdno1 = findViewById(rdchoose);
                String bangcap = rdno1.getText().toString();
                // Lấy thông tin sở thích
                String sothich = "";
                if(chkGame.isChecked()){
                    sothich += chkGame.getText().toString()+"-";
                }
                if(chkMusic.isChecked()){
                    sothich += chkMusic.getText().toString()+"-";
                }
                if(chkBall.isChecked()){
                    sothich += chkBall.getText().toString();
                }
                // Lấy thông tin bổ sung
                String bosung = edtBoSung.getText().toString();
                String tonghop = hoten+"\n"+cmnd+"\n"+bangcap+"\n"+sothich+"\n";
                    tonghop += "--------THONG TIN BO SUNG----------\n";
                    tonghop += bosung+"\n";
                    tonghop += "---------------------------------------";
                // Tao Dialog va hien thi thong tin
                AlertDialog.Builder mydialog = new AlertDialog.Builder(MainActivity.this);
                mydialog.setTitle("THONG TIN CA NHAN");
                mydialog.setMessage(tonghop);
                mydialog.setPositiveButton("Close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                mydialog.create().show();
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}