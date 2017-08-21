package com.example.as.beinsured.UI;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.as.beinsured.ConnectionData.Connect;
import com.example.as.beinsured.Model.User;
import com.example.as.beinsured.R;
import com.example.as.beinsured.Service.ApiClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {

    public static String apiKey = Connect.ApiKey;

    //stworzenie instancji Retrofit
    private static Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl(Connect.ApiUrl)
            .addConverterFactory(GsonConverterFactory.create());

    public static Retrofit retrofit = builder.build();
    ApiClient userClient = retrofit.create(ApiClient.class);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText editTextLogin = (EditText)findViewById(R.id.editTextLogin);
        final EditText editTextPassword = (EditText)findViewById(R.id.editTextPassword);
        Button button = (Button)findViewById(R.id.button);

        final SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(LoginActivity.this);
        String isOKFirst = sharedPref.getString(Connect.login_token, "");

        // Przekierowanie w przypadku zalogowanego uzytkownika
        if(!isOKFirst.isEmpty()){
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String login= editTextLogin.getText().toString();
                String password= editTextPassword.getText().toString();
                tryLogin(Connect.ApiKey, login, password);

//                 PRZEKIEROWANIE PRZY POMOCY SHAREDPREF
//                String isOK = sharedPref.getString(Connect.login_token, "");
//                if(!isOK.isEmpty()){
//                    System.out.println("TAK");
//                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
//                    startActivity(intent);
//                }else if(isOK.isEmpty()){
//                    System.out.println("NIE");
//                    Toast.makeText(LoginActivity.this, "ZLE HASLO I/LUB LOGIN", Toast.LENGTH_SHORT).show();
//                }
            }
        });


    }


    public void tryLogin(String apiKey, String login, String password) {

        Call<User> call = userClient.login(apiKey, login, password);

        call.enqueue(new Callback<User>() {

            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()) {

                    int statusCode = response.code();
                    User user = response.body();
                    if(user.getStatus()==0){
                        // Zapis danych do sharedpreferences
                        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(LoginActivity.this);
                        SharedPreferences.Editor editor = sharedPref.edit();
                        editor.putString(Connect.login_token, user.getLoginToken());
                        editor.putString(Connect.login_token_exp, user.getLoginToken());
                        editor.putString(Connect.refresh_token, user.getRefreshToken());
                        editor.putString(Connect.refresh_token_exp, user.getRefreshToken());
                        editor.commit();

                        Log.i("TAG", "ZALOGOWANO");
                        // Przeniesienie do glownego Activity
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);

                    }else if(user.getStatus()==1){
                        Log.i("TAG", "ZLE HASLO/LOGIN");
                        Toast.makeText(LoginActivity.this, "ZLE HASLO I/LUB LOGIN", Toast.LENGTH_SHORT).show();
                    }
                } else {
                       //...
                }
            }
            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "BRAK POLACZENIA", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
