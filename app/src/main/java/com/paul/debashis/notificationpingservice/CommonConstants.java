package com.paul.debashis.notificationpingservice;

/**
 * Created by Admin on 28/02/2015.
 */
public final class CommonConstants {

    public CommonConstants() {

        // don't allow the class to be instantiated
    }

    // Milliseconds in the snooze duration, which translates
    // to 20 seconds.
    public static final int SNOOZE_DURATION = 20000;
    public static final int DEFAULT_TIMER_DURATION = 10000;
    public static final String ACTION_SNOOZE = "com.paul.debashis.notificationpingservice.ACTION_SNOOZE";
    public static final String ACTION_DISMISS = "com.paul.debashis.notificationpingservice.ACTION_DISMISS";
    public static final String ACTION_PING = "com.paul.debashis.notificationpingservice.ACTION_PING";
    public static final String EXTRA_MESSAGE= "com.paul.debashis.notificationpingservice.EXTRA_MESSAGE";
    public static final String EXTRA_TIMER = "com.paul.debashis.notificationpingservice.EXTRA_TIMER";
    public static final int NOTIFICATION_ID = 001;
    public static final String DEBUG_TAG = "DEB";
}
