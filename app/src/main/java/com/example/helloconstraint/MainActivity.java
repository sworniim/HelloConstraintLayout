package com.example.helloconstraint;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btn_toast;
    private Button btn_count;
    private Button btn_reset;
    private TextView counter;
    private int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_toast=findViewById(R.id.button);
        btn_count=findViewById(R.id.button3);
        btn_reset=findViewById(R.id.button2);
        counter=findViewById(R.id.textView);
        btn_toast.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                Toast.makeText(MainActivity.this,"Hello Toast!",Toast.LENGTH_LONG).show();

            }
        });
        btn_count.setOnClickListener(new View.OnClickListener(){
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v){


                count=count+1;

                counter.setText(""+count);
                btn_reset.setBackgroundColor(btn_reset.getContext().getResources().getColor(R.color.morange, null));
                if(count%2==0){
                    btn_count.setBackgroundColor(getResources().getColor(R.color.black, null));
                    // btn_count.setBackgroundColor(btn_count.getContext().getResources().getColor(R.color.black, null));
                }
                else {
                    btn_count.setBackgroundColor(btn_count.getContext().getResources().getColor(R.color.mred, null));
                }

            }
        });
        btn_reset.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                count=0;
                counter.setText(""+count);
                btn_reset.setBackgroundColor(btn_count.getContext().getResources().getColor(R.color.teal_200, null));
                btn_count.setBackgroundColor(btn_count.getContext().getResources().getColor(R.color.purple_500, null));
            }
        });
    }
}