package com.example.fingerprintunlock;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.fingerprintunlock.databinding.ActivitySelectOptionBinding;

public class SelectOptionActivity extends AppCompatActivity {


    private ActivitySelectOptionBinding binding;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_option);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_select_option);
        context=this;

        binding.btnFs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(context,MainActivity.class));
            }
        });


        binding.btnPl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(context,PatternLockActivity.class));
            }
        });


    }
}
