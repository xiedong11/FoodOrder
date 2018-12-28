package com.zhuandian.oderapp.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.zhuandian.oderapp.MainActivity;
import com.zhuandian.oderapp.R;
import com.zhuandian.oderapp.entity.UserEntity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.et_username)
    EditText etUsername;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.tv_user_register)
    TextView tvUserRegister;
    @BindView(R.id.tv_login)
    TextView tvLogin;
    private String userName;
    private String passWord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.tv_user_register, R.id.tv_login})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_user_register:
                startActivity(new Intent(LoginActivity.this, UserRegisterActivity.class));
                break;
            case R.id.tv_login:
                doLogin();
                break;
        }
    }

    private void doLogin() {
        userName = etUsername.getText().toString();
        passWord = etPassword.getText().toString();
        if (TextUtils.isEmpty(userName) || TextUtils.isEmpty(passWord)) {
            Toast.makeText(this, "请完善登陆信息...", Toast.LENGTH_SHORT).show();
        } else {
            UserEntity userEntity = new UserEntity();
            userEntity.setUsername(userName);
            userEntity.setPassword(passWord);
            userEntity.login(new SaveListener<Object>() {
                @Override
                public void done(Object o, BmobException e) {
                    if (e == null) {
                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                        finish();
                    } else {
                        Toast.makeText(LoginActivity.this, "登陆失败...", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}
