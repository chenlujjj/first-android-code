package com.example.testing.uiwidgettest;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ProgressBar progressBar = findViewById(R.id.progress_bar);
        final Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (progressBar.getVisibility() == View.VISIBLE) {
                    progressBar.setVisibility(View.INVISIBLE);
                    button1.setText("显示进度条");
                } else {
                    progressBar.setVisibility(View.VISIBLE);
                    button1.setText("隐藏进度条");

                }
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int progress = progressBar.getProgress();
                if (progress <= 90) {
                    progress = progress + 10;

                } else {
                    progress = 0;
                }
                progressBar.setProgress(progress);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("Login");
                dialog.setMessage("Input username and password");
                // 若为true，则点击屏幕其他地方或者按返回键，弹窗就会消失
                dialog.setCancelable(false);
                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this,"好的", Toast.LENGTH_SHORT).show();
                    }
                });

                dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this,"别啊", Toast.LENGTH_SHORT).show();
                    }
                });

                dialog.show();
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
                progressDialog.setTitle("慢慢走");
                progressDialog.setMessage("走吧走吧");
                progressDialog.setCancelable(true);
                progressDialog.show();
            }
        });
    }
}
