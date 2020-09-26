package com.apple.weeklytext_exercise02;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText N ;
    Button thuchien;
    TextView ketqua;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        N = (EditText)findViewById(R.id.etN);
        thuchien = (Button)findViewById(R.id.btnTh);
        ketqua = (TextView)findViewById(R.id.tvResult);

        thuchien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    int C = 0;
                    int n = Integer.parseInt(N.getText().toString());
                    String cuuchuong ="";
                    if(n > 9 || n < 0)
                    {
                        Toast toast = Toast.makeText(MainActivity.this,"Vui lòng chỉ nhập số từ 1 -> 9",Toast.LENGTH_SHORT);
                        toast.show();
                    }else {

                        for (int i = 1; i <= 9; i++) {
                            C = n * i;
                            cuuchuong += "\n" + n + " x " + i + "=" + C;
                        }
                        ketqua.setText(cuuchuong);
                    }
                }catch (Exception e){
                    AlertDialog.Builder b = new AlertDialog.Builder(MainActivity.this);
                    b.setTitle("Lỗi");
                    b.setMessage("Vui lòng nhập số để tính!!");
                    b.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    b.create();
                    b.show();

                }

            }
        });
    }
}
