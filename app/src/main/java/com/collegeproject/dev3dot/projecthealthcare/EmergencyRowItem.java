package com.collegeproject.dev3dot.projecthealthcare;


public class EmergencyRowItem {
    private String emergencyName;
    private String emergencyPlace;
    private String emergencyPhNumber;

    public EmergencyRowItem(String emergencyName, String emergencyPlace, String emergencyPhNumber) {
        this.emergencyName = emergencyName;
        this.emergencyPlace = emergencyPlace;
        this.emergencyPhNumber = emergencyPhNumber;
    }

    public String getEmergencyName() {
        return emergencyName;
    }

    public void setEmergencyName(String emergencyName) {
        this.emergencyName = emergencyName;
    }

    public String getEmergencyPlace() {
        return emergencyPlace;
    }

    public void setEmergencyPlace(String emergencyPlace) {
        this.emergencyPlace = emergencyPlace;
    }

    public String getEmergencyPhNumber() {
        return emergencyPhNumber;
    }

    public void setEmergencyPhNumber(String emergencyPhNumber) {
        this.emergencyPhNumber = emergencyPhNumber;
    }
}

