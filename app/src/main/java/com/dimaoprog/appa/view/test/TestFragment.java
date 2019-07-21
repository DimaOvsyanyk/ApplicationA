package com.dimaoprog.appa.view.test;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.dimaoprog.appa.R;
import com.dimaoprog.appa.databinding.TestFragmentBinding;
import com.dimaoprog.appa.utils.ISendBroadcastListener;

public class TestFragment extends Fragment {

    private ISendBroadcastListener sendBroadcastListener;

    private void setSendBroadcastListener(ISendBroadcastListener sendBroadcastListener) {
        this.sendBroadcastListener = sendBroadcastListener;
    }

    public static TestFragment newInstance(ISendBroadcastListener sendBroadcastListener) {
        TestFragment fragment = new TestFragment();
        fragment.setSendBroadcastListener(sendBroadcastListener);
        return fragment;
    }

    private TestViewModel tViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        tViewModel = ViewModelProviders.of(this).get(TestViewModel.class);
        TestFragmentBinding binding = DataBindingUtil.inflate(inflater, R.layout.test_fragment, container, false);

        binding.setTestModel(tViewModel);
        tViewModel.getShowErrorMessage().observe(getViewLifecycleOwner(), show -> {
            if (show) {
                Toast.makeText(getContext(), "Please enter correct url", Toast.LENGTH_SHORT).show();
                tViewModel.setShowErrorMessage(false);
            }
        });
        tViewModel.getUrlIntentString().observe(getViewLifecycleOwner(), url -> sendBroadcastListener.sendBroadcast(url));
        return binding.getRoot();
    }

}