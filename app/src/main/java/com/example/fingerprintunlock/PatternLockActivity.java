package com.example.fingerprintunlock;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.andrognito.patternlockview.PatternLockView;
import com.andrognito.patternlockview.listener.PatternLockViewListener;
import com.andrognito.patternlockview.utils.PatternLockUtils;
import com.example.fingerprintunlock.databinding.ActivityPatternLockBinding;

import java.util.List;

public class PatternLockActivity extends AppCompatActivity {


    private ActivityPatternLockBinding binding;

    private String savedPattern="";

    private Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this,R.layout.activity_pattern_lock);
        context=this;




        binding.lockView.addPatternLockListener(new PatternLockViewListener() {
            @Override
            public void onStarted() {

            }

            @Override
            public void onProgress(List<PatternLockView.Dot> progressPattern) {
        //        ((TextView) findViewById(R.id.patternCode)).setText(PatternLockUtils.patternToString(mPatternLockView, progressPattern));
            }

            @Override
            public void onComplete(List<PatternLockView.Dot> pattern) {
                if (binding.group.getCheckedRadioButtonId()==R.id.setLock) {
                    // Save a New Pattern if Set Lock RadioButton is Selected
                    savedPattern = PatternLockUtils.patternToString(binding.lockView, pattern);
                    Toast.makeText(context, "New Pattern Set", Toast.LENGTH_SHORT).show();
                } else {
                    // If pattern lock is correct then Show Toast Else Show Wrong Pattern
                    if (PatternLockUtils.patternToString(binding.lockView, pattern).equals(savedPattern)) {
                        Toast.makeText(context, "Pattern Unlocked Successful", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(context,HomeActivity.class));
                        finish();
                    } else {
                        Toast.makeText(context, "Wrong Pattern... Try Again!", Toast.LENGTH_SHORT).show();
                    }
                }
                binding.lockView.clearPattern();
            }

            @Override
            public void onCleared() {
            }
        });
    }
}
