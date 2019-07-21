package com.dimaoprog.appa.view.history;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.dimaoprog.appa.R;
import com.dimaoprog.appa.databinding.ItemLinkBinding;
import com.dimaoprog.appa.entities.ImageLink;
import com.dimaoprog.appa.utils.ISendBroadcastListener;

public class LinksAdapter extends ListAdapter<ImageLink, LinksVH> {

    private ISendBroadcastListener sendBroadcastListener;

    protected LinksAdapter(ISendBroadcastListener sendBroadcastListener) {
        super(DIFF_CALLBACK);
        this.sendBroadcastListener = sendBroadcastListener;
    }

    private static final DiffUtil.ItemCallback<ImageLink> DIFF_CALLBACK = new DiffUtil.ItemCallback<ImageLink>() {
        @Override
        public boolean areItemsTheSame(@NonNull ImageLink oldItem, @NonNull ImageLink newItem) {
            return oldItem.getId() == newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull ImageLink oldItem, @NonNull ImageLink newItem) {
            return oldItem.equals(newItem);
        }
    };

    @NonNull
    @Override
    public LinksVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemLinkBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_link, parent, false);
        return new LinksVH(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull LinksVH holder, int position) {
        holder.onBind(getItem(position), sendBroadcastListener);
    }
}
