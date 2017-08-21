package com.example.as.beinsured.UI;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.as.beinsured.ConnectionData.Connect;
import com.example.as.beinsured.R;

public class AccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        final SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(AccountActivity.this);
        String s_exp = sharedPref.getString(Connect.subscription_exp, "9999-99-99");

        TextView textViewAccDate = (TextView)findViewById(R.id.textViewAccDate);

        textViewAccDate.setText("Ważny do: "+s_exp);
    }

    public void btnLogout(View view) {
        String emp = "";
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(AccountActivity.this);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(Connect.login_token, emp);
        editor.putString(Connect.login_token_exp, emp);
        editor.putString(Connect.refresh_token, emp);
        editor.putString(Connect.refresh_token_exp, emp);
        editor.commit();
        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(intent);
    }

    public void btnAcc(View view) {
        Intent intent = new Intent(getApplicationContext(), AccountActivity.class);
        startActivity(intent);
    }

    public void btnNew(View view) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }

}
