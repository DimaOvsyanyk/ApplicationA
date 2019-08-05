package com.dimaoprog.appa.view.history;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.dimaoprog.appa.data.RoomRepository;
import com.dimaoprog.appa.entities.ImageLink;
import com.dimaoprog.appa.utils.Sort;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;

public class HistoryViewModel extends AndroidViewModel {

    private CompositeDisposable disposable = new CompositeDisposable();
    private RoomRepository repository;
    private MutableLiveData<List<ImageLink>> imageLinkList = new MutableLiveData<>();

    public HistoryViewModel(@NonNull Application application) {
        super(application);
        repository = new RoomRepository(application);
        getImageLinkListFromDB(Sort.NOT_SORT);
    }

    public void getImageLinkListFromDB(Sort sort) {
        disposable.clear();
        disposable.add(repository.getImageLinkList(sort)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::setImageLinkList));
    }

    public MutableLiveData<List<ImageLink>> getImageLinkList() {
        return imageLinkList;
    }

    private void setImageLinkList(List<ImageLink> imageLinkList) {
        this.imageLinkList.setValue(imageLinkList);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.dispose();
    }
}
