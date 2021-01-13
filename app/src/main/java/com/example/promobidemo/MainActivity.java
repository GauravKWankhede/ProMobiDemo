package com.example.promobidemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.promobidemo.Adapters.CatsAdapter;
import com.example.promobidemo.Adapters.ViewPagerAdapter;
import com.example.promobidemo.RoomDBFiles.AppDatabase;
import com.example.promobidemo.RoomDBFiles.Converter;
import com.example.promobidemo.RoomDBFiles.DatabaseClient;
import com.example.promobidemo.RoomDBFiles.TaskDao;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;

    @Inject
    Retrofit retrofit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewPager);

        recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);


        loadCats();

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
            ((CustomApplication)getApplication()).getCatsComponent().inject(this);
            Api mService = retrofit.create(Api.class);
            Call<List<Cat>> mCats = mService.getCats();

            mCats.enqueue(new Callback<List<Cat>>() {
                @Override
                public void onResponse(Call<List<Cat>> call, Response<List<Cat>> response) {
                    progressDialog.dismiss();
                    viewPagerAdapter = new ViewPagerAdapter(MainActivity.this, response.body());
                    viewPager.setAdapter(viewPagerAdapter);
                    recyclerView.setAdapter(new CatsAdapter(MainActivity.this, response.body()));

                    addData(response.body());
                }


                @Override
                public void onFailure(Call<List<Cat>> call, Throwable t) {
                    Log.e("ERROR", "onFailure: "+ t.getMessage() );

                }

            });


        }
        else if (checkRoomDababaseIsPresent(MainActivity.this,"AllCatsInfo")){
            //set data from room database to viewpager and recyclerview
            progressDialog.dismiss();
            class GetAllDataFromRoom extends AsyncTask<Void,Void,List<Cat>>{

                @Override
                protected List<Cat> doInBackground(Void... voids) {
                    List<Cat> catList =DatabaseClient.getInstance(getApplicationContext())
                            .getAppDatabase()
                            .taskDao()
                            .getAll();
                    return catList;

                }

                @Override
                protected void onPostExecute(List<Cat> catList) {
                    super.onPostExecute(catList);
                    viewPagerAdapter = new ViewPagerAdapter(MainActivity.this,catList);
                    viewPager.setAdapter(viewPagerAdapter);
                    recyclerView.setAdapter(new CatsAdapter(MainActivity.this,catList));
                }
            }

            GetAllDataFromRoom getAllDataFromRoom = new GetAllDataFromRoom();
            getAllDataFromRoom.execute();
        }
        else
        {
            progressDialog.setTitle("Error");
            progressDialog.setMessage("Check your Internet Connection....");
            progressDialog.show();
        }
    }

    private void addData(List<Cat> body) {
        class AddDataToRoomDatabase extends AsyncTask<Void, Void, Void> {

            @Override
            protected Void doInBackground(Void... voids) {
                Cat cat = new Cat();
                cat.setName(cat.getName());
                cat.setOrigin(cat.getOrigin());
                cat.setDescription(cat.getDescription());
                cat.setTemperament(cat.getTemperament());
                cat.setAlt_names(cat.getAlt_names());
                cat.setLife_span(cat.getLife_span());
                cat.setAdaptability(cat.getAdaptability());
                cat.setAffection_level(cat.getAffection_level());
                cat.setChild_friendly(cat.getChild_friendly());
                cat.setDog_friendly(cat.getDog_friendly());
                cat.setEnergy_level(cat.getEnergy_level());
                cat.setGrooming(cat.getGrooming());
                cat.setHealth_issues(cat.getHealth_issues());
                cat.setIntelligence(cat.getIntelligence());
                cat.setShedding_level(cat.getShedding_level());
                cat.setSocial_needs(cat.getSocial_needs());
                cat.setStranger_friendly(cat.getStranger_friendly());
                cat.setVocalisation(cat.getVocalisation());
                cat.setExperimental(cat.getExperimental());
                cat.setImage(cat.getImage());

                DatabaseClient.getInstance(getApplicationContext()).getAppDatabase()
                        .taskDao()
                        .insert(cat);

                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);

                Toast.makeText(getApplicationContext(), "Saved", Toast.LENGTH_SHORT).show();
            }

        }
        AddDataToRoomDatabase addDataToRoomDatabase = new AddDataToRoomDatabase();
        addDataToRoomDatabase.execute();
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
                viewPager.setAdapter(viewPagerAdapter);

                break;

            case R.id.linearViewVertical:
                viewPager.setVisibility(View.GONE);
                recyclerView.setVisibility(View.VISIBLE);
                LinearLayoutManager layoutManagerVertical = new LinearLayoutManager(this);
                layoutManagerVertical.setOrientation(LinearLayoutManager.VERTICAL);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(layoutManagerVertical);
                break;

            case R.id.gridView:
                viewPager.setVisibility(View.GONE);
                recyclerView.setVisibility(View.VISIBLE);
                GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(gridLayoutManager);
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    private boolean isNetworkConnected(){
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        return connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnected();
    }

    public boolean checkRoomDababaseIsPresent(Context context, String dbName){
        File dbFile = context.getDatabasePath(dbName);
        Log.e("FIle Name", dbFile +"");
        return dbFile.exists();
    }

}

