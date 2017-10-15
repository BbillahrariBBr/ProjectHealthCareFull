package com.collegeproject.dev3dot.projecthealthcare;



public class RowItem {


    private String treatmentName;
    private int pictureID;
    private String defination;
    private String causes;
    private String symptoms;
    private String toDo;

    public RowItem(String treatmentName, int pictureID, String defination, String causes, String symptoms, String toDo) {
        this.treatmentName = treatmentName;
        this.pictureID = pictureID;
        this.defination = defination;
        this.causes = causes;
        this.symptoms = symptoms;
        this.toDo = toDo;
    }

    public RowItem(String tratmentName, int pictureID) {
        this.treatmentName = tratmentName;
        this.pictureID = pictureID;
    }

    public String getTreatmentName() {
        return treatmentName;
    }

    public void setTreatmentName(String treatmentName) {
        this.treatmentName = treatmentName;
    }

    public int getPictureID() {
        return pictureID;
    }

    public void setPictureID(int pictureID) {
        this.pictureID = pictureID;
    }

    public String getDefination() {
        return defination;
    }

    public void setDefination(String defination) {
        this.defination = defination;
    }

    public String getCauses() {
        return causes;
    }

    public void setCauses(String causes) {
        this.causes = causes;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public String getToDo() {
        return toDo;
    }

    public void setToDo(String toDo) {
        this.toDo = toDo;
    }
}
