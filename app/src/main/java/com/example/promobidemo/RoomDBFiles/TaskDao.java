package com.example.promobidemo.RoomDBFiles;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.promobidemo.Cat;

import java.util.List;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface TaskDao {
    @Query("SELECT * FROM cat")
    List<Cat> getAll();

    @Insert(onConflict = REPLACE)
    void insert(Cat cat);
}
