package com.demo.starplan.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.demo.starplan.R;
import com.demo.starplan.database.Login;

import org.litepal.tablemanager.Connector;

public class LoginActivity extends AppCompatActivity {

    private Button loginButton;
    private TextView textView3;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginButton = findViewById(R.id.login);
        textView = findViewById(R.id.edit_num);
        textView3 = findViewById(R.id.textView3);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Connector.getDatabase();
                Login login = new Login();
                login.setTellNum(textView.getText());
                login.save();
            }
        });

        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, ActivityLoginPassword.class);
                startActivity(intent);
            }
        });

    }
}
