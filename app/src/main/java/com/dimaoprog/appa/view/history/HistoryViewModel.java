package com.dimaoprog.appa.view.history;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.dimaoprog.appa.data.RoomRepository;
import com.dimaoprog.appa.entities.ImageLink;

import java.util.List;

public class HistoryViewModel extends AndroidViewModel {

    private RoomRepository repository;
    private LiveData<List<ImageLink>> imageLinkList;
    private LiveData<List<ImageLink>> imageLinkListNewFirst;
    private LiveData<List<ImageLink>> imageLinkListOldFirst;
    private LiveData<List<ImageLink>> imageLinkListStatusAsc;
    private LiveData<List<ImageLink>> imageLinkListStatusDesc;


    public HistoryViewModel(@NonNull Application application) {
        super(application);
        repository = new RoomRepository(application);
        imageLinkList = repository.getImageLinkList();
        imageLinkListNewFirst = repository.getImageLinkListNewFirst();
        imageLinkListOldFirst = repository.getImageLinkListOldFirst();
        imageLinkListStatusAsc = repository.getImageLinkListStatusAsc();
        imageLinkListStatusDesc = repository.getImageLinkListStatusDesc();
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
