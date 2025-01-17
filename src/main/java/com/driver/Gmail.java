package com.driver;

import java.util.ArrayList;
import java.util.Date;
import java.util.Deque;
import java.util.LinkedList;

public class Gmail extends Email {
    int inboxCapacity;
    private Deque<Mail> inbox;
    private ArrayList<Mail> trash;

    public Gmail(String emailId, int inboxCapacity) {
        super(emailId);
        this.inboxCapacity = inboxCapacity;
        inbox = new LinkedList<>();
        trash = new ArrayList<>();
    }

    public void receiveMail(Date date, String sender, String message) {
        if (inbox.size() < inboxCapacity) {
            inbox.addLast(new  Mail(date, sender, message));    
        }else if(inbox.size() >= inboxCapacity){
            Mail m = inbox.removeFirst();
            trash.add(m);
            inbox.addLast(new Mail(date, sender, message));
        }
    }
    
    public void deleteMail(String message) {
        for (Mail m : inbox) {
            String s = m.getMessage();
            
            if (s.equals(message) == true) {
                trash.add(m);
                inbox.remove(m);
                break;
            }
        }
    }

    public String findLatestMessage() {
        if (inbox.size() == 0) return null;
        else{
        return inbox.getLast().getMessage();
    }
}

    public String findOldestMessage() {
        if (inbox.size()==0) return null;
        else{
        return inbox.getFirst().getMessage();
        }
    }

    public int findMailsBetweenDates(Date start, Date end) {
        int count = 0;
        for (Mail mail : inbox) {
            Date date = mail.getDate();
            if (date.before(start) && date.after(end) || (!date.before(start)) && (!date.after(end))) {
                count++;
            }
        }
        return count;
    }

    public int getInboxSize() {
        return inbox.size();
    }

    public int getTrashSize() {
        return trash.size();
    }

    public void emptyTrash() {
        trash.clear();
    }

    public int getInboxCapacity() {
        return inboxCapacity;
    }
}

class Mail {
     Date date;
     String sender;
     String message;

    public Mail(Date date, String sender, String message) {
        this.date = date;
        this.sender = sender;
        this.message = message;
    }
    
    public void setDate(Date date){
        this.date = date;
    }
    public Date getDate() {
        return date;
    }

    public String getSender() {
        return sender;
    }
    public void setSender(String sender){
        this.sender = sender;
    }

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}
