package com.sarino.rojo.m1p9.itu.mahaiaw.model;

public class LearningDataModel {
    public int image;
    public String showTitle;
    public String speakTitle;
    boolean isTrue=false;
//
    public boolean isTrue() {
        return isTrue;
    }

    public void setTrue(boolean aTrue) {
        isTrue = aTrue;
    }

    public LearningDataModel(int i, String str, String str2) {
        this.speakTitle = str;
        this.showTitle = str2;
        this.image = i;
    }

    public int getImage() {
        return this.image;
    }

    public void setImage(int i) {
        this.image = i;
    }

    public String getSpeakTitle() {
        return this.speakTitle;
    }

    public void setSpeakTitle(String str) {
        this.speakTitle = str;
    }

    public String getShowTitle() {
        return this.showTitle;
    }

    public void setShowTitle(String str) {
        this.showTitle = str;
    }
}