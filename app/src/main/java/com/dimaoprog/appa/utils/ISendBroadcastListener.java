package com.dimaoprog.appa.utils;

import com.dimaoprog.appa.entities.ImageLink;

public interface ISendBroadcastListener {
    void sendBroadcast(String url);
    void sendBroadcast(ImageLink imageLink);
}
