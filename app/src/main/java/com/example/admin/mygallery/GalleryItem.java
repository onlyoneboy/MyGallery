package com.example.admin.mygallery;


public class GalleryItem {
    private String caption;
    private String id;
    private String url;

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCaption() {

        return caption;
    }

    public String getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }
}
