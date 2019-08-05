package com.dimaoprog.appa.view.history;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dimaoprog.appa.R;
import com.dimaoprog.appa.databinding.HistoryFragmentBinding;
import com.dimaoprog.appa.utils.IOptionMenuListener;
import com.dimaoprog.appa.utils.ISendBroadcastListener;
import com.dimaoprog.appa.utils.ISetHistoryFragmentListener;
import com.dimaoprog.appa.utils.Sort;

public class HistoryFragment extends Fragment implements IOptionMenuListener {

    private ISendBroadcastListener sendBroadcastListener;
    private ISetHistoryFragmentListener setHistoryFragmentListener;

    private void setSendBroadcastListener(ISendBroadcastListener sendBroadcastListener) {
        this.sendBroadcastListener = sendBroadcastListener;
    }

    private void setSetHistoryFragmentListener(ISetHistoryFragmentListener setHistoryFragmentListener) {
        this.setHistoryFragmentListener = setHistoryFragmentListener;
    }

    public static HistoryFragment newInstance(ISendBroadcastListener sendBroadcastListener,
                                              ISetHistoryFragmentListener setHistoryFragmentListener) {
        HistoryFragment fragment = new HistoryFragment();
        fragment.setSendBroadcastListener(sendBroadcastListener);
        fragment.setSetHistoryFragmentListener(setHistoryFragmentListener);
        return fragment;
    }

    private HistoryViewModel hViewModel;
    private LinksAdapter adapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        hViewModel = ViewModelProviders.of(this).get(HistoryViewModel.class);
        setHistoryFragmentListener.setHistoryFragmentListener(this);
        HistoryFragmentBinding binding = DataBindingUtil.inflate(inflater, R.layout.history_fragment, container, false);
        adapter = new LinksAdapter(sendBroadcastListener);
        binding.rvUrlList.setAdapter(adapter);

        hViewModel.getImageLinkList().observe(getViewLifecycleOwner(), imageLinks -> adapter.submitList(imageLinks));
        return binding.getRoot();
    }

    @Override
    public void sortByDate(boolean newFirst) {
        if (newFirst) {
            hViewModel.getImageLinkListFromDB(Sort.NEW_FIRST);
        } else {
            hViewModel.getImageLinkListFromDB(Sort.OLD_FIRST);
        }
    }

    @Override
    public void sortByStatus(boolean ascending) {
        if (ascending) {
            hViewModel.getImageLinkListFromDB(Sort.STATUS_ASC);
        } else {
            hViewModel.getImageLinkListFromDB(Sort.STATUS_DESC);
        }
    }
}