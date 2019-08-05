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

import io.reactivex.Flowable;

import static com.dimaoprog.appa.utils.Constants.COLUMN_ID;
import static com.dimaoprog.appa.utils.Constants.DATABASE_TABLE_NAME;

@Dao
public interface ImageUrlDao {

    @Query("SELECT * FROM " + DATABASE_TABLE_NAME)
    Flowable<List<ImageLink>> getAllImageLinkList();

    @Query("SELECT * FROM " + DATABASE_TABLE_NAME + " ORDER BY id DESC")
    Flowable<List<ImageLink>> getAllImageLinkListOrderNewFirst();

    @Query("SELECT * FROM " + DATABASE_TABLE_NAME + " ORDER BY id ASC")
    Flowable<List<ImageLink>> getAllImageLinkListOrderOldFirst();

    @Query("SELECT * FROM " + DATABASE_TABLE_NAME + " ORDER BY status DESC")
    Flowable<List<ImageLink>> getAllImageLinkListOrderByStatusDesc();

    @Query("SELECT * FROM " + DATABASE_TABLE_NAME + " ORDER BY status ASC")
    Flowable<List<ImageLink>> getAllImageLinkListOrderByStatusAsc();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insert(ImageLink imageLink);

    @Update
    int update(ImageLink imageLink);

    @Delete
    int delete(ImageLink imageLink);

    @Query("DELETE FROM " + DATABASE_TABLE_NAME + " WHERE " + COLUMN_ID + " = :id")
    int deleteById(long id);

}
