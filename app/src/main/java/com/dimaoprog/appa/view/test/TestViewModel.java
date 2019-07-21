package com.dimaoprog.appa.view.test;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import static com.dimaoprog.appa.utils.Constants.REG_EXP_IMAGE_URL;

public class TestViewModel extends ViewModel {

//    private String url = "https://autoreview.ru/images/Article/1678/Article_167810_860_575.jpg";
    private String url = "";
    private MutableLiveData<Boolean> showErrorMessage = new MutableLiveData<>();
    private MutableLiveData<String> urlIntentString = new MutableLiveData<>();


    public void sendUrl() {
        if (!urlOk()) {
            setShowErrorMessage(true);
            return;
        }
        setUrlIntentString(url);
    }

    private boolean urlOk() {
        return url != null && !url.isEmpty() && url.matches(REG_EXP_IMAGE_URL);
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public MutableLiveData<Boolean> getShowErrorMessage() {
        return showErrorMessage;
    }

    public void setShowErrorMessage(boolean showErrorMessage) {
        this.showErrorMessage.setValue(showErrorMessage);
    }

    public MutableLiveData<String> getUrlIntentString() {
        return urlIntentString;
    }

    public void setUrlIntentString(String urlIntentString) {
        this.urlIntentString.setValue(urlIntentString);
    }
}
