package com.example.viewpager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class log_in extends AppCompatActivity {
    private ImageView eye_passwd_log;
    private boolean hide = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_in);
        eye_passwd_log = findViewById(R.id.eye_passwd_log);

        //設置密碼顯示or隱藏
        eye_passwd_log.setImageResource(R.drawable.eye_hide);
        eye_passwd_log.setOnClickListener(new View.OnClickListener() {
            private EditText passwd_log;

            @Override
            public void onClick(View view) {
                passwd_log = findViewById(R.id.passwd_log);
                switch (view.getId()) {
                    case R.id.eye_passwd_log:
                        if (hide == true) {
                            eye_passwd_log.setImageResource(R.drawable.eye_show);
                            HideReturnsTransformationMethod method = HideReturnsTransformationMethod.getInstance();
                            passwd_log.setTransformationMethod(method);
                            hide = false;
                        } else {
                            eye_passwd_log.setImageResource(R.drawable.eye_hide);
                            TransformationMethod method = PasswordTransformationMethod.getInstance();
                            passwd_log.setTransformationMethod(method);
                            hide = true;
                        }
                        int index = passwd_log.getText().toString().length();
                        passwd_log.setSelection(index);
                        break;
                }
            }
        });
    }
    public void SignUp(View view) {
        Intent intent=new Intent(this, sign_up.class);
        startActivity(intent);
    }

    public void log_in_check(View view) {
    }
}