package org.apache.cordova.core;

/**
 * Created by JumpByte-L on 06-08-2015.
 */
public class CordovaApp extends android.app.Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ParsePlugin.initializeParseWithApplication(this);
    }
}
