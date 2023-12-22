package com.example.fetch_data;

public class ActorModel {
    String id;
    String name;
    String overView;
    String img;

    public ActorModel(){

    }

    public ActorModel(String id, String name, String overView, String img){
        this.id = id;
        this.name=name;
        this.overView=overView;
        this.img=img;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOverView() {
        return overView;
    }

    public void setOverView(String overView) {
        this.overView = overView;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
