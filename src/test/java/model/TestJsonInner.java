package model;

import com.google.gson.annotations.SerializedName;

public class TestJsonInner {
    @SerializedName("Title")
    private String title;

    @SerializedName("Description")
    private String description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
