package com.dimaoprog.appa.data;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.dimaoprog.appa.entities.ImageLink;

import java.util.List;

public class RoomRepository {

    private ImageUrlDao imageUrlDao;
    private LiveData<List<ImageLink>> imageLinkList;
    private LiveData<List<ImageLink>> imageLinkListNewFirst;
    private LiveData<List<ImageLink>> imageLinkListOldFirst;
    private LiveData<List<ImageLink>> imageLinkListStatusAsc;
    private LiveData<List<ImageLink>> imageLinkListStatusDesc;

    public RoomRepository(Application application) {
        AppDatabase db = AppDatabase.getInstance(application);
        imageUrlDao = db.imageUrlDao();
        imageLinkList = imageUrlDao.getAllImageLinkList();
        imageLinkListNewFirst = imageUrlDao.getAllImageLinkListOrderNewFirst();
        imageLinkListOldFirst = imageUrlDao.getAllImageLinkListOrderOldFirst();
        imageLinkListStatusAsc = imageUrlDao.getAllImageLinkListOrderByStatusAsc();
        imageLinkListStatusDesc = imageUrlDao.getAllImageLinkListOrderByStatusDesc();

    }

    public LiveData<List<ImageLink>> getImageLinkList() {
        return imageLinkList;
    }

    public LiveData<List<ImageLink>> getImageLinkListNewFirst() {
        return imageLinkListNewFirst;
    }

    public LiveData<List<ImageLink>> getImageLinkListOldFirst() {
        return imageLinkListOldFirst;
    }

    public LiveData<List<ImageLink>> getImageLinkListStatusAsc() {
        return imageLinkListStatusAsc;
    }

    public LiveData<List<ImageLink>> getImageLinkListStatusDesc() {
        return imageLinkListStatusDesc;
    }
}