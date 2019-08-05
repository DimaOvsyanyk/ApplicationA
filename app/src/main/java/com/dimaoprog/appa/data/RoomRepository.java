package com.dimaoprog.appa.data;

import android.app.Application;

import com.dimaoprog.appa.entities.ImageLink;
import com.dimaoprog.appa.utils.Sort;

import java.util.List;

import io.reactivex.Flowable;

public class RoomRepository {

    private ImageUrlDao imageUrlDao;

    public RoomRepository(Application application) {
        AppDatabase db = AppDatabase.getInstance(application);
        imageUrlDao = db.imageUrlDao();
    }

    public Flowable<List<ImageLink>> getImageLinkList(Sort sort) {
        switch (sort) {
            case NOT_SORT:
                return imageUrlDao.getAllImageLinkList();
            case NEW_FIRST:
                return imageUrlDao.getAllImageLinkListOrderNewFirst();
            case OLD_FIRST:
                return imageUrlDao.getAllImageLinkListOrderOldFirst();
            case STATUS_ASC:
                return imageUrlDao.getAllImageLinkListOrderByStatusAsc();
            case STATUS_DESC:
                return imageUrlDao.getAllImageLinkListOrderByStatusDesc();
            default:
                return imageUrlDao.getAllImageLinkList();
        }
    }
}