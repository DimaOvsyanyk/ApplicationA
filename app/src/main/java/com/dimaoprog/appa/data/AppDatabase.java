package com.dimaoprog.appa.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.dimaoprog.appa.entities.ImageLink;

import static com.dimaoprog.appa.utils.Constants.DATABASE_NAME;

@Database(entities = {ImageLink.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase instance;

    public abstract ImageUrlDao imageUrlDao();

    public synchronized static AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context, AppDatabase.class, DATABASE_NAME).build();
        }
        return instance;
    }

}
