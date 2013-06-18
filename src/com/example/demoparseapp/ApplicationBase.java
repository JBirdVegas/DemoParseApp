package com.example.demoparseapp;

import android.app.Application;
import com.parse.Parse;
import com.parse.ParseInstallation;

/**
 * Created with IntelliJ IDEA.
 * User: jbird
 * Date: 6/18/13 12:00 AM
 */
public class ApplicationBase extends Application {
    public ApplicationBase() {
        super();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(this, "3Zz9tbgbJ3DkLZS1X4NF1I8TaSvxZ7PR09kTA2ZN",
                "jhTgn4Excngb5W5lD4KWKlGcBK1lFc6CvvvLqtEm");
        // Saving the device's owner
        ParseInstallation installation = ParseInstallation.getCurrentInstallation();
        installation.put("user", ParseInstallation.getCurrentInstallation().getInstallationId());
        //installation.put("installationId", installation.getInstallationId());
        installation.saveInBackground();
    }
}
