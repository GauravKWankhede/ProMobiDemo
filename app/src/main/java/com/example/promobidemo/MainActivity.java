package com.example.promobidemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProvider.Factory;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.io.File;
import java.util.List;

import javax.inject.Inject;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    Realm realm;
    RealmConfiguration config;
    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;
    List<Cat> catList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewPager);

        recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        Realm.init(MainActivity.this);

        loadCats();

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.view_pager:
                recyclerView.setVisibility(View.GONE);
                viewPager.setVisibility(View.VISIBLE);
              //  viewPagerAdapter = new ViewPagerAdapter(MainActivity.this,catList);
                viewPager.setAdapter(viewPagerAdapter);

                break;

            case R.id.linearViewVertical:
                viewPager.setVisibility(View.GONE);
                recyclerView.setVisibility(View.VISIBLE);
                LinearLayoutManager layoutManagerVertical = new LinearLayoutManager(this);
                layoutManagerVertical.setOrientation(LinearLayoutManager.VERTICAL);
                recyclerView.setHasFixedSize(true);
//                recyclerView.setAdapter(new CatsAdapter(MainActivity.this, catList));
                recyclerView.setLayoutManager(layoutManagerVertical);
                break;

            case R.id.gridView:
                viewPager.setVisibility(View.GONE);
                recyclerView.setVisibility(View.VISIBLE);
                GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
                recyclerView.setHasFixedSize(true);
              //  recyclerView.setAdapter(new CatsAdapter(MainActivity.this, catList));
                recyclerView.setLayoutManager(gridLayoutManager);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    private void loadCats() {

        final ProgressDialog progressDialog;
        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("Its loading...");
        progressDialog.setTitle("ProgressDialog");
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.show();

         if (isNetworkConnected()){
               Call<List<Cat>> call = RetrofitClient.getInstance().getMyApi().getCats();
            call.enqueue(new Callback<List<Cat>>() {
                @Override
                public void onResponse(Call<List<Cat>> call, Response<List<Cat>> response) {
                    if (response.isSuccessful()) {
                        progressDialog.dismiss();
                        catList = response.body();

                        viewPagerAdapter = new ViewPagerAdapter(MainActivity.this,catList);
                        viewPager.setAdapter(viewPagerAdapter);

                        recyclerView.setAdapter(new CatsAdapter(MainActivity.this, catList));

                            config = new RealmConfiguration.Builder()
                                    .build();
                            Realm.setDefaultConfiguration(config);
                            realm = Realm.getInstance(config);
                            realm.beginTransaction();
                        if (realm.where(Cat.class).findAll().size() == 67){
                            realm.insert(catList);
                            realm.commitTransaction();
                        }

                    }
                }
                @Override
                public void onFailure(Call<List<Cat>> call, Throwable t) {
                    Toast.makeText(MainActivity.this, ""+t.getMessage(), Toast.LENGTH_SHORT).show();
                    Log.e("Error msg",""+t.getMessage());
                }
            });
        }
         else if(isRealmDatabaseFileIsPresent())
         {
            //code to load data to recyclerview from realm
             progressDialog.dismiss();
            Log.e("Database: ","Present");
            Realm realm = Realm.getDefaultInstance();
            realm.beginTransaction();
            List<Cat>  cats = realm.where(Cat.class).findAll();
             Log.e("Cats: ",""+cats);
             Log.e("Cats Size: ",""+cats.size());
             if (cats.isEmpty()){
                 progressDialog.setMessage("You are not Connected to Internet. Please turn it ON...");
                 progressDialog.setTitle("ERROR");
                 progressDialog.setCanceledOnTouchOutside(false);
                 progressDialog.show();
             }
             else
             realm.commitTransaction();
             viewPager.setAdapter(new ViewPagerAdapter(MainActivity.this,cats));
          //   recyclerView.setVisibility(View.VISIBLE);
             recyclerView.setAdapter(new CatsAdapter(MainActivity.this,cats));
           // viewPagerAdapter = new ViewPagerAdapter(MainActivity.this,cats);
        }
    }

    private boolean isNetworkConnected(){
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        return connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnected();
    }

    private boolean isRealmDatabaseFileIsPresent(){
        String dafaultFile = Realm.getInstance( new RealmConfiguration.Builder().build()).getConfiguration().getRealmFileName();
        Log.e("default file name", dafaultFile);
        if ("default.realm".equals(dafaultFile)){
            return true;
        }else {
            return false;
        }
       /* RealmConfiguration config = Realm.getDefaultConfiguration();
        assert config != null;
        return new File(config.getPath()).exists();*/

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        realm.close();
    }
}

