package com.layonf.mysharedpreferencejava;

import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class HomeActivity extends AppCompatActivity {

    TextView text_name, text_email;
    Button button_logout;
    SharedPreferences sharedPreferences;

    private static final String SHARED_PREF_NAME = "mypref";
    private static final String KEY_NAME = "name";
    private static final String KEY_EMAIL = "email";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        text_name = findViewById(R.id.text_fullname);
        text_email = findViewById(R.id.text_email);
        button_logout = findViewById(R.id.button_logout);
        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);

        String name = sharedPreferences.getString(KEY_NAME, null);
        String email = sharedPreferences.getString(KEY_EMAIL, null);

        if(name != null || email != null) {
            //so set the data
            text_name.setText(name);
            text_email.setText(email);
        }

        //call the button to Log out session
        button_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.commit();
                Toast.makeText(HomeActivity.this, "Log out sucessfully", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}