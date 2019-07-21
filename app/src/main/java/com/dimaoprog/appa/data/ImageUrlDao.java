package com.dimaoprog.appa.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.dimaoprog.appa.entities.ImageLink;

import java.util.List;

import static com.dimaoprog.appa.utils.Constants.COLUMN_ID;
import static com.dimaoprog.appa.utils.Constants.DATABASE_TABLE_NAME;

@Dao
public interface ImageUrlDao {

    @Query("SELECT * FROM " + DATABASE_TABLE_NAME)
    LiveData<List<ImageLink>> getAllImageLinkList();

    @Query("SELECT * FROM " + DATABASE_TABLE_NAME + " ORDER BY id DESC")
    LiveData<List<ImageLink>> getAllImageLinkListOrderNewFirst();

    @Query("SELECT * FROM " + DATABASE_TABLE_NAME + " ORDER BY id ASC")
    LiveData<List<ImageLink>> getAllImageLinkListOrderOldFirst();

    @Query("SELECT * FROM " + DATABASE_TABLE_NAME + " ORDER BY status DESC")
    LiveData<List<ImageLink>> getAllImageLinkListOrderByStatusDesc();

    @Query("SELECT * FROM " + DATABASE_TABLE_NAME + " ORDER BY status ASC")
    LiveData<List<ImageLink>> getAllImageLinkListOrderByStatusAsc();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insert(ImageLink imageLink);

    @Update
    int update(ImageLink imageLink);

    @Delete
    int delete(ImageLink imageLink);

    @Query("DELETE FROM " + DATABASE_TABLE_NAME + " WHERE " + COLUMN_ID + " = :id")
    int deleteById(long id);

}
