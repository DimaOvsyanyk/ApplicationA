package com.dimaoprog.appa.view.history;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.dimaoprog.appa.databinding.ItemLinkBinding;
import com.dimaoprog.appa.entities.ImageLink;
import com.dimaoprog.appa.utils.ISendBroadcastListener;

public class LinksVH extends RecyclerView.ViewHolder {

    private ItemLinkBinding binding;

    public LinksVH(@NonNull ItemLinkBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void onBind(ImageLink imageLink, ISendBroadcastListener sendBroadcastListener) {
        binding.setImageLink(imageLink);
        itemView.setOnClickListener(__ -> sendBroadcastListener.sendBroadcast(imageLink));
    }
}
