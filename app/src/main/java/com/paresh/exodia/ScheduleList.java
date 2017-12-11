package com.paresh.exodia;

/**
 * Created by paresh on 11/12/17.
 */

public class ScheduleList {
    private String event_title, event_venue, event_time;

    public ScheduleList() {
    }

    public ScheduleList(String event_title, String event_venue, String event_time) {
        this.event_title = event_title;
        this.event_venue = event_venue;
        this.event_time = event_time;
    }

    public String getEvent_title() {
        return event_title;
    }

    public void setEvent_title(String event_title) {
        this.event_title = event_title;
    }

    public String getEvent_time() {
        return event_time;
    }

    public void setEvent_time(String event_time) {
        this.event_time = event_time;
    }

    public String getEvent_venue() {
        return event_venue;
    }

    public void setEvent_venue(String event_venue) {
        this.event_venue = event_venue;
    }
}
