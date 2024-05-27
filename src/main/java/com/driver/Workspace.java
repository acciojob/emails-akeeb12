package com.driver;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;

public class Workspace extends Gmail {
    private ArrayList<Meeting> calendar;

    public Workspace(String emailId) {
        super(emailId, Integer.MAX_VALUE);
        this.calendar = new ArrayList<>();
    }

    public void addMeeting(Meeting meeting) {
        calendar.add(meeting);
    }

    public int findMaxMeetings() {
        Collections.sort(calendar);
        int count = 0;
        LocalTime lastEndTime = LocalTime.MIN;

        for (Meeting meeting : calendar) {
            if (meeting.getEnd().isAfter(lastEndTime)) {
                lastEndTime = meeting.getEnd();
                count++;
            }
        }
        return count;
    }
}
