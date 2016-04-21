package com.blooot.criminalintent;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.util.Date;
import java.util.UUID;

/**
 * Created by roger on 4/20/2016.
 */
public class Crime {

    private UUID mId;
    private String mTitle;
    private Date mDate;
    private boolean mSolved;

    public Crime(){
        // Generate unique identifier
        mId = UUID.randomUUID();
        mDate = new Date();
    }

    public UUID getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public boolean isSolved() {
        return mSolved;
    }

    public void setSolved(boolean solved) {
        mSolved = solved;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public String getFormattedDate(){
        DateFormat df = DateFormat.getDateTimeInstance();
        return df.format(mDate);
    }

    public CharSequence getAlternateFormattedDate(){
        android.text.format.DateFormat df = new android.text.format.DateFormat();
        return df.format("EEE, MMM dd, yyyy ", mDate);
    }

}
