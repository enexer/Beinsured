package com.example.as.beinsured.UI;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.as.beinsured.ConnectionData.Connect;
import com.example.as.beinsured.Model.Account;
import com.example.as.beinsured.Model.NewsletterDetails;
import com.example.as.beinsured.Model.NewsletterPage;
import com.example.as.beinsured.Model.User;
import com.example.as.beinsured.R;
import com.example.as.beinsured.Service.ApiClient;

import java.util.ArrayList;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private ListView lv;
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
        setContentView(R.layout.activity_main);

        lv = (ListView) findViewById(R.id.listViewNewsletter);
        Button buttonLogout = (Button)findViewById(R.id.buttonLog);
        Button buttonAccount = (Button)findViewById(R.id.buttonAcc);

        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        final String login_token = sharedPref.getString(Connect.login_token, "");

        // Zapisanie danych na temat konta
        getAccountDetails(apiKey, login_token);
        // Wypelnienie ListView danymi (tylko 1 strona)
        String page = "1"; // Strona do wyswietlenia
        getNewsletterList(apiKey, page, login_token);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                HashMap<String, String> map = (HashMap<String, String>) lv.getItemAtPosition(position);
                String map_id = map.get("id");
                // zmiana zawartosci Listview na konkretny newsletter
                getNewsletterDetails(apiKey, map_id, login_token);
            }
        });


    }

    // Wylogowanie i przejscie do LoginActivity.class
    public void btnLogout(View view) {
        String emp = "";
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        SharedPreferences.Editor editor = sharedPref.edit();
        // Wyczyszczenie danych
        editor.putString(Connect.login_token, emp);
        editor.putString(Connect.login_token_exp, emp);
        editor.putString(Connect.refresh_token, emp);
        editor.putString(Connect.refresh_token_exp, emp);
        editor.commit();
        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(intent);
    }

    //Przejscie do AccountActivity.class
    public void btnAcc(View view) {
        Intent intent = new Intent(getApplicationContext(), AccountActivity.class);
        startActivity(intent);
    }

    // Przejscie do MainActivity.class
    public void btnNew(View view) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }

    // funkcja wyswietlajaca liste newsletterow (page - strona, 10 elementow na strone, domyslnie 1)
    private void getNewsletterList(String apiKey, String page, String authToken){

        Call<NewsletterPage> call = userClient.getNewsletterList(apiKey, page, authToken);

        call.enqueue(new Callback<NewsletterPage>() {
            @Override
            public void onResponse(Call<NewsletterPage> call, Response<NewsletterPage> response) {
                if (response.isSuccessful()) {

                    NewsletterPage newsletterPage = response.body();
                    // Wypelnienie listview danymi
                    fillListViewNewsletterList(newsletterPage);
                }else {
                    //...
                }
            }

            @Override
            public void onFailure(Call<NewsletterPage> call, Throwable t) {
                //...
            }
        });


    }

    // funkcja wypelniajaca listview (Lista Newslettterow)
    private void fillListViewNewsletterList(NewsletterPage newsletterPage){

        ArrayList<HashMap<String, Object>> dayList;
        dayList = new ArrayList<>();

        int size = newsletterPage.getItems().size();
        int i = 0;
        for (int j=0; j<size; j++) {
            HashMap<String, Object> dL = new HashMap<>();
            dL.put("id", Integer.toString(newsletterPage.getItems().get(i).getId()));
            dL.put("title", newsletterPage.getItems().get(i).getTytul());
            dL.put("date", "data: "+newsletterPage.getItems().get(i).getDataWyslania());
            dayList.add(dL);
            i++;
        }

        ListAdapter adapter = new SimpleAdapter(MainActivity.this, dayList,
                R.layout.list_newsletter, new String[]{"title", "date"},
                new int[]{R.id.textViewListTitle, R.id.textViewListDate});
        lv.setAdapter(adapter);
    }

    // funkcja wyswietlajaca szczegoly newslettera, (newsletter- nr. newslettera)
    private void getNewsletterDetails(String apiKey, String newsletter, String authToken){

        Call<NewsletterDetails> call = userClient.getNewsletter(apiKey, newsletter, authToken);

        call.enqueue(new Callback<NewsletterDetails>() {
            @Override
            public void onResponse(Call<NewsletterDetails> call, Response<NewsletterDetails> response) {
                if (response.isSuccessful()) {

                    NewsletterDetails newsletterDetails = response.body();
                    // wypelnienie listview danymi
                    fillListViewNewsletterDetails(newsletterDetails);

                }else {
                    //...
                }
            }

            @Override
            public void onFailure(Call<NewsletterDetails> call, Throwable t) {
                //...
            }
        });


    }
    // funkcja wypelniajaca listview( Szczegoly Newslettera)
    private void fillListViewNewsletterDetails(NewsletterDetails newsletterDetails){

        ArrayList<HashMap<String, Object>> dayList;
        dayList = new ArrayList<>();

        // liczba elementow
        int size = newsletterDetails.getData().getZawartosc().size();
        int i = 0;
        for (int j=0; j<size; j++) {

            String publicator = newsletterDetails.getData().getZawartosc().get(i).getPublikator();
            if(publicator==null){
                publicator=" ";
            }else{
                publicator="Publikator: "+publicator;
            }

            HashMap<String, Object> dL = new HashMap<>();
            dL.put("title", newsletterDetails.getData().getZawartosc().get(i).getTytul());
            dL.put("publicator", publicator);
            dL.put("content", (newsletterDetails.getData().getZawartosc().get(i).getTresc()));
            dL.put("link", newsletterDetails.getData().getZawartosc().get(i).getLink());
            dayList.add(dL);
            i++;
        }

        ListAdapter adapter = new SimpleAdapter(MainActivity.this, dayList,
                R.layout.list_newsletter_details, new String[]{"title", "publicator", "content", "link"},
                new int[]{R.id.textViewDetailsTitle, R.id.textViewDetailsPublicator, R.id.textViewDetailsContent, R.id.textViewDetailsLink});
        lv.setAdapter(adapter);
    }

    // funkcja wyswietlaja dane o koncie
    private void getAccountDetails(String apiKey, String authToken) {

        Call<Account> call = userClient.getAccount(apiKey, authToken);

        call.enqueue(new Callback<Account>() {
            @Override
            public void onResponse(Call<Account> call, Response<Account> response) {
                if (response.isSuccessful()) {
                    Account account = response.body();
                    SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
                    SharedPreferences.Editor editor = sharedPref.edit();
                    editor.putString(Connect.subscription_exp, account.getDataKonca());
                    editor.commit();
                }else {
                    //...
                }
            }

            @Override
            public void onFailure(Call<Account> call, Throwable t) {
                //...
            }
        });

    }

    // funkcja odswiezajaca login_token
    private void tryRefresh(String apiKey, String authToken) {
        Call<User> call = userClient.refresh(apiKey, authToken);

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()) {
                    User user = response.body();
                    SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
                    SharedPreferences.Editor editor = sharedPref.edit();
                    // nadpisanie danych
                    editor.putString(Connect.login_token, user.getLoginToken());
                    editor.putString(Connect.login_token_exp, user.getLoginToken());
                    editor.putString(Connect.refresh_token, user.getRefreshToken());
                    editor.putString(Connect.refresh_token_exp, user.getRefreshToken());
                    editor.commit();
                    System.out.println("REFRESH - OK\n" + user.toString());
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                //...
            }
        });
    }

}

