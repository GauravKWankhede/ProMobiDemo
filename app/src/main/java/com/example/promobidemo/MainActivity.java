package com.example.promobidemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.promobidemo.Adapters.CatsAdapter;
import com.example.promobidemo.Adapters.ViewPagerAdapter;
import com.example.promobidemo.RoomDBFiles.DatabaseClient;

import java.io.File;
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
    List<Cat> res;
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

                    res =  response.body();
                    viewPagerAdapter = new ViewPagerAdapter(MainActivity.this, response.body());
                    viewPager.setAdapter(viewPagerAdapter);
                    recyclerView.setAdapter(new CatsAdapter(MainActivity.this,  response.body()));

                    class AddDataToRoomDatabase extends AsyncTask<Void, Void, Void> {

                        @Override
                        protected Void doInBackground(Void... voids) {
                            assert res != null;
                          //  Log.d("getCheckDAta", "response - " + res.toString());
                            for (int i = 0; i < res.size(); i++) {
                                //   cat.setName(res.get(i).getName());
                                  // Log.e("TAG", "onResponse: " + res.get(i).getImage()+" : "+ res.get(i).getImage().getUrl());
                               Cat allCatInfo = new Cat();
                                allCatInfo.setName(res.get(i).getName());
                                allCatInfo.setOrigin(res.get(i).getOrigin());
                                allCatInfo.setDescription(res.get(i).getDescription());
                                allCatInfo.setTemperament(res.get(i).getTemperament());
                                allCatInfo.setAlt_names(res.get(i).getAlt_names());
                                allCatInfo.setLife_span(res.get(i).getLife_span());
                                allCatInfo.setAdaptability(res.get(i).getAdaptability());
                                allCatInfo.setAffection_level(res.get(i).getAffection_level());
                                allCatInfo.setChild_friendly(res.get(i).getChild_friendly());
                                allCatInfo.setDog_friendly(res.get(i).getDog_friendly());
                                allCatInfo.setEnergy_level(res.get(i).getEnergy_level());
                                allCatInfo.setGrooming(res.get(i).getGrooming());
                                allCatInfo.setHealth_issues(res.get(i).getHealth_issues());
                                allCatInfo.setIntelligence(res.get(i).getIntelligence());
                                allCatInfo.setShedding_level(res.get(i).getShedding_level());
                                allCatInfo.setSocial_needs(res.get(i).getSocial_needs());
                                allCatInfo.setStranger_friendly(res.get(i).getStranger_friendly());
                                allCatInfo.setVocalisation(res.get(i).getVocalisation());
                                allCatInfo.setExperimental(res.get(i).getExperimental());

                                if(res.get(i).getImage()== null || res.get(i).getImage().getUrl()==null){
                                    allCatInfo.setImage(null);
                                }
                                else
                                {
                                    allCatInfo.setImage(res.get(i).getImage());
                                }



                                DatabaseClient.getInstance(getApplicationContext()).getAppDatabase()
                                        .taskDao()
                                        .insert(allCatInfo);
                            }
                            return null;
                        }

                        @Override
                        protected void onPostExecute(Void aVoid) {
                            super.onPostExecute(aVoid);

                           // Log.e("TAG", "saved ");
                        }

                    }

                    new AddDataToRoomDatabase().execute();
                    }
                @Override
                public void onFailure(Call<List<Cat>> call, Throwable t) {
                 //   Log.e("ERROR", "onFailure: "+ t.getMessage() );
                }
            });
        }
        else if (checkRoomDababaseIsPresent(MainActivity.this,"cat")){
            //set data from room database to viewpager and recyclerview
            progressDialog.dismiss();
            @SuppressLint("StaticFieldLeak")
            class GetAllDataFromRoom extends AsyncTask<Void,Void,List<Cat>>{

                @Override
                protected List<Cat> doInBackground(Void... voids) {
                    List<Cat> catList = DatabaseClient.getInstance(getApplicationContext())
                            .getAppDatabase()
                            .taskDao()
                            .getAll();
                    return catList;

                }

                @Override
                protected void onPostExecute(List<Cat> catList) {
                    super.onPostExecute(catList);
                   // Log.e("Catlist", "onPostExecute: "+catList );
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
       // Log.e("FIle Name", dbFile.length() +"");
        return dbFile.exists();
    }


}

