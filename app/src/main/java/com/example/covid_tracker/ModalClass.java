package com.example.covid_tracker;

public class ModalClass {

    private String active, recover,confirm,city,state;

    public ModalClass(String active, String recover, String confirm,String city,String state) {
        this.active = active;
        this.recover = recover;
        this.confirm = confirm;
        this.city=city;
        this.state=state;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getRecover() {
        return recover;
    }

    public void setRecover(String recover) {
        this.recover = recover;
    }

    public String getConfirm() {
        return confirm;
    }

    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
