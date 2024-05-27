package com.driver;

import java.time.LocalTime;

public class Meeting implements Comparable<Meeting> {
    private LocalTime start;
    private LocalTime end;

    public Meeting(LocalTime start, LocalTime end) {
        this.start = start;
        this.end = end;
    }

    public LocalTime getStart() {
        return start;
    }

    public LocalTime getEnd() {
        return end;
    }

    @Override
    public int compareTo(Meeting other) {
        return this.end.compareTo(other.end);
    }
}
