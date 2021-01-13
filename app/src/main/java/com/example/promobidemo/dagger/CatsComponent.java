package com.example.promobidemo.dagger;

import com.example.promobidemo.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component (modules = NetworksModule.class)
public interface CatsComponent {
    public void inject(MainActivity mainActivity);
}
