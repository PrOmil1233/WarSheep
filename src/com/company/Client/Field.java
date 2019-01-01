package com.company.Client;

public class Field {

    private int status;


    public Field(int status) {

        this.status =status;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "["+status+"] ";
    }

}
