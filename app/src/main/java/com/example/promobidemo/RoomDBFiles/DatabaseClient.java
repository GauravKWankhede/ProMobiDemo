package com.example.promobidemo.RoomDBFiles;

import android.content.Context;

import androidx.room.Room;

public class DatabaseClient {
    private Context mCtx;
    private static DatabaseClient mInstance;

    private AppDatabase appDatabase;

    DatabaseClient(Context mCtx){
        this.mCtx = mCtx;
        appDatabase = Room.databaseBuilder(mCtx,AppDatabase.class,"cat").build();
    }
    public static synchronized DatabaseClient getInstance(Context mCtx)
    {
        if (mInstance==null){
            mInstance = new DatabaseClient(mCtx);
        }
        return mInstance;

    }

    public AppDatabase getAppDatabase(){
        return appDatabase;
    }
}
