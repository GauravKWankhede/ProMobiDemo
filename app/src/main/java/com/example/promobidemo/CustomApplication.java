package com.example.promobidemo;

import android.app.Application;
import android.os.AsyncTask;
import android.widget.Toast;

import com.example.promobidemo.RoomDBFiles.DatabaseClient;
import com.example.promobidemo.dagger.CatsComponent;
import com.example.promobidemo.dagger.DaggerCatsComponent;
import com.example.promobidemo.dagger.NetworksModule;

import java.util.List;

import static io.realm.Realm.getApplicationContext;

public class CustomApplication extends Application {

    private CatsComponent catsComponent;
    @Override
    public void onCreate() {
        super.onCreate();

        catsComponent = DaggerCatsComponent.builder()
                .networksModule(new NetworksModule(Helper.URL))
                .build();

    }

    public CatsComponent getCatsComponent(){
        return catsComponent;
    }

}
