package io.android_tech.myexample.AdapterView;

import android.graphics.Bitmap;

public class AdapterView_GridView_03_Data {
    private Bitmap image;
    private String title;

    public AdapterView_GridView_03_Data(Bitmap image, String title) {
        super();
        this.image = image;
        this.title = title;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
