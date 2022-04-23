package com.example.viewpager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.InputType;
import android.text.Spanned;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class sign_up extends AppCompatActivity {
    private EditText name, account, passwd, passwd_current;
    private SharedPreferences sp;
    private SharedPreferences.Editor speditor;
    private Button register_current;
    private boolean hide = true;
    private ImageView eye_passwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);
        name = findViewById(R.id.name_register);
        account = findViewById(R.id.gmail_register);
        passwd = findViewById(R.id.passwd_register);
        passwd_current = findViewById(R.id.passwd_current_register);
        register_current = findViewById(R.id.register_current);
        eye_passwd = findViewById(R.id.eye_passwd);

        //設置密碼顯示or隱藏
        eye_passwd.setImageResource(R.drawable.eye_hide);

        eye_passwd.setOnClickListener(new View.OnClickListener() {
            private EditText passwd, passwd_current;

            @Override
            public void onClick(View view) {
                passwd = findViewById(R.id.passwd_register);
                passwd_current = findViewById(R.id.passwd_current_register);
                switch (view.getId()) {
                    case R.id.eye_passwd:
                        if (hide == true) {
                            eye_passwd.setImageResource(R.drawable.eye_show);
                            HideReturnsTransformationMethod method = HideReturnsTransformationMethod.getInstance();
                            passwd.setTransformationMethod(method);
                            passwd_current.setTransformationMethod(method);
                            hide = false;
                        } else {
                            eye_passwd.setImageResource(R.drawable.eye_hide);
                            TransformationMethod method = PasswordTransformationMethod.getInstance();
                            passwd.setTransformationMethod(method);
                            passwd_current.setTransformationMethod(method);
                            hide = true;
                        }
                        int index = passwd.getText().toString().length();
                        int index1 = passwd_current.getText().toString().length();
                        passwd.setSelection(index);
                        passwd_current.setSelection(index1);
                        break;
                }
            }
        });
        //限制密碼輸入型態
        passwd.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        passwd_current.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        name.setFilters(new InputFilter[]{typefilter});

        //檢測密碼一致性
        register_current.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String passwd1 = passwd.getText().toString();
                String passwd2 = passwd_current.getText().toString();
                if (passwd1.equals("") || passwd2.equals("")) {
                    Toast.makeText(getApplicationContext(), "密碼不能為空", Toast.LENGTH_SHORT).show();
                } else if (passwd1.equals(passwd2)) {
                    Toast.makeText(getApplicationContext(), "註冊成功", Toast.LENGTH_SHORT).show();
                } else if (!passwd1.equals(passwd2)) {
                    Toast.makeText(getApplicationContext(), "密碼不一致，請重新輸入", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    //限制密碼輸入型態
    final InputFilter typefilter = new InputFilter() {
        @Override
        public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
            Pattern p = Pattern.compile("[a-zA-Z\u4100-\u9fa5]+");
            Matcher m = p.matcher(source.toString());
            if (!m.matches()) return "";
            return null;
        }
    };

    public void SignUp(View view) {

    }
}