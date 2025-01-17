package com.driver;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Workspace extends Gmail {
    private ArrayList<Meeting> calendar;

    public Workspace(String emailId) {
        super(emailId, Integer.MAX_VALUE);
        calendar = new ArrayList<>();
    }

    public void addMeeting(Meeting meeting) {
        calendar.add(meeting);
    }

    public int findMaxMeetings() {
        ArrayList<Meeting> m = new ArrayList<>();
        LocalTime time_limit;
        
        Collections.sort(calendar,(m1, m2) ->{
            return m1.getEndTime(). compareTo(m2.getEndTime());
        });
        Meeting meet = calendar.get(0);
        m.add(meet);
        time_limit = calendar.get(0).getEndTime();
        // int count = 0;
        // LocalTime lastEndTime = LocalTime.MIN;
        
        for (int i = 0; i < calendar.size(); i++) {
            if (calendar.get(i).getStartTime().compareTo(time_limit) > 0) {
                m.add(calendar.get(i));
                time_limit = calendar.get(i).getEndTime();
            }
        }
        return m.size();
    }
    class myComparator implements Comparator<Meeting>{
        @Override 
        public int compare(Meeting m1, Meeting m2){
            if(m1.getEndTime().compareTo(m2.getEndTime())<0){
                return -1;
            }
            else if(m1.getEndTime().compareTo(m2.getEndTime()) > 0){
            return 1;
            }
        return 0;

        } 
    }

}