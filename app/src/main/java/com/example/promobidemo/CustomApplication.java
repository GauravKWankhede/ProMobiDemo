package com.example.promobidemo;

import android.app.Application;
import com.example.promobidemo.dagger.CatsComponent;
import com.example.promobidemo.dagger.DaggerCatsComponent;
import com.example.promobidemo.dagger.NetworksModule;



public class CustomApplication extends Application {

    private CatsComponent catsComponent;
    @Override
    public void onCreate() {
        super.onCreate();

        catsComponent = DaggerCatsComponent.builder()
                .networksModule(new NetworksModule(Api.BASE_URL))
                .build();

    }

    public CatsComponent getCatsComponent(){
        return catsComponent;
    }

}
