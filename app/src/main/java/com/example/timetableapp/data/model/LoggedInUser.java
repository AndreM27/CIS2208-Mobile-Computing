package com.example.timetableapp.data.model;

/**
 * Data class that captures user information for logged in users retrieved from LoginRepository
 */
public class LoggedInUser { //class to handle successfully logged in user

    private String userId; //id unique to every user
    private String displayName; //name to display inside app

    public LoggedInUser(String userId, String displayName) { //constructor for a user to be logged in
        this.userId = userId;
        this.displayName = displayName;
    }

    public String getUserId() { //getter for the userId

        return userId;
    }

    public String getDisplayName() { //getter for the name to be displayed inside the app
        return displayName;
    }
}