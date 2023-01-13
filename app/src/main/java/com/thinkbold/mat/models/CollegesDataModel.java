package com.thinkbold.mat.models;

import android.os.Parcel;
import android.os.Parcelable;

public class CollegesDataModel implements Parcelable {

    private String id = "";
    private String collegeName = "";
    private String collegeWebsite = "";
    private String image = "";

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getCollegeName(){
        return collegeName;
    }

    public void setCollegeName(String collegeName){
        this.collegeName = collegeName;
    }

    public String getCollegeWebsite(){
        return collegeWebsite;
    }
    public void setCollegeWebsite(String collegeWebsite){
        this.collegeWebsite = collegeWebsite;
    }

    public String getImage(){
        return image;
    }
    public void setImage(String image){
        this.image = image;
    }

    //end of models

    public CollegesDataModel (){
        super();
    }

    protected CollegesDataModel(Parcel in) {
        this();
        readFromParcel(in);
    }

    public void readFromParcel(Parcel in){
        this.id = in.readString();
        this.collegeName = in.readString();
        this.collegeWebsite = in.readString();
        this.image = in.readString();
    }

    public void writeToParcel(Parcel dest, int in){
        dest.writeString(id);
        dest.writeString(collegeName);
        dest.writeString(collegeWebsite);
        dest.writeString(image);
    }

    public static final Creator<CollegesDataModel> CREATOR = new Creator<CollegesDataModel>() {
        @Override
        public CollegesDataModel createFromParcel(Parcel in) {
            return new CollegesDataModel(in);
        }

        @Override
        public CollegesDataModel[] newArray(int size) {
            return new CollegesDataModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

}
