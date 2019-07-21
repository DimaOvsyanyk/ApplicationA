package com.dimaoprog.appa.entities;

import android.content.ContentValues;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import static com.dimaoprog.appa.utils.Constants.COLUMN_ID;
import static com.dimaoprog.appa.utils.Constants.COLUMN_OPEN_TIME;
import static com.dimaoprog.appa.utils.Constants.COLUMN_STATUS;
import static com.dimaoprog.appa.utils.Constants.COLUMN_URL;
import static com.dimaoprog.appa.utils.Constants.DATABASE_TABLE_NAME;
import static com.dimaoprog.appa.utils.Constants.STATUS_UNKNOWN;

@Entity(tableName = DATABASE_TABLE_NAME)
public class ImageLink {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(index = true, name = COLUMN_ID)
    private long id;

    @ColumnInfo(name = COLUMN_URL)
    private String url;

    @ColumnInfo(index = true, name = COLUMN_STATUS)
    private int status;

    @ColumnInfo(index = true, name = COLUMN_OPEN_TIME)
    private long openTime;

    public ImageLink() {

    }

    public ImageLink(String url, long openTime) {
        this.url = url;
        this.status = STATUS_UNKNOWN;
        this.openTime = openTime;
    }

    public ImageLink(long id, String url, int status, long openTime) {
        this.id = id;
        this.url = url;
        this.status = status;
        this.openTime = openTime;
    }

    public static ImageLink fromContentValueToInsert(ContentValues values) {
        return new ImageLink(values.containsKey(COLUMN_URL) ? values.getAsString(COLUMN_URL) : "",
                values.containsKey(COLUMN_OPEN_TIME) ? values.getAsLong(COLUMN_OPEN_TIME) : 0);
    }

    public static ImageLink fromContentValueToUpdate(ContentValues values) {
        return new ImageLink(
                values.containsKey(COLUMN_ID) ? values.getAsLong(COLUMN_ID) : 0,
                values.containsKey(COLUMN_URL) ? values.getAsString(COLUMN_URL) : "",
                values.containsKey(COLUMN_STATUS) ? values.getAsInteger(COLUMN_STATUS) : 0,
                values.containsKey(COLUMN_OPEN_TIME) ? values.getAsLong(COLUMN_OPEN_TIME) : 0);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public long getOpenTime() {
        return openTime;
    }

    public void setOpenTime(long openTime) {
        this.openTime = openTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImageLink imageLink = (ImageLink) o;
        return getId() == imageLink.getId() &&
                getStatus() == imageLink.getStatus() &&
                getOpenTime() == imageLink.getOpenTime() &&
                getUrl().equals(imageLink.getUrl());
    }

    @Override
    public String toString() {
        return "ImageLink{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", status=" + status +
                ", openTime=" + openTime +
                '}';
    }
}
