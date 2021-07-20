package com.example.covid_19tracker;

public class Vaccine {

    String center,vaccine,available,Address,State_name,District_name,Block_name,From,To,date1,Available_capacity_dose1,Available_capacity_dose2,Fee,Min_age_limit;

    public Vaccine() {
    }

    public Vaccine(String center, String vaccine, String available, String address, String state_name, String district_name, String block_name, String from, String to, String date1, String available_capacity_dose1, String available_capacity_dose2, String fee, String min_age_limit) {
        this.center = center;
        this.vaccine = vaccine;
        this.available = available;
        Address = address;
        State_name = state_name;
        District_name = district_name;
        Block_name = block_name;
        From = from;
        To = to;
        this.date1 = date1;
        Available_capacity_dose1 = available_capacity_dose1;
        Available_capacity_dose2 = available_capacity_dose2;
        Fee = fee;
        Min_age_limit = min_age_limit;
    }

    public String getCenter() {
        return center;
    }

    public void setCenter(String center) {
        this.center = center;
    }

    public String getVaccine() {
        return vaccine;
    }

    public void setVaccine(String vaccine) {
        this.vaccine = vaccine;
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getState_name() {
        return State_name;
    }

    public void setState_name(String state_name) {
        State_name = state_name;
    }

    public String getDistrict_name() {
        return District_name;
    }

    public void setDistrict_name(String district_name) {
        District_name = district_name;
    }

    public String getBlock_name() {
        return Block_name;
    }

    public void setBlock_name(String block_name) {
        Block_name = block_name;
    }

    public String getFrom() {
        return From;
    }

    public void setFrom(String from) {
        From = from;
    }

    public String getTo() {
        return To;
    }

    public void setTo(String to) {
        To = to;
    }

    public String getDate1() {
        return date1;
    }

    public void setDate1(String date1) {
        this.date1 = date1;
    }

    public String getAvailable_capacity_dose1() {
        return Available_capacity_dose1;
    }

    public void setAvailable_capacity_dose1(String available_capacity_dose1) {
        Available_capacity_dose1 = available_capacity_dose1;
    }

    public String getAvailable_capacity_dose2() {
        return Available_capacity_dose2;
    }

    public void setAvailable_capacity_dose2(String available_capacity_dose2) {
        Available_capacity_dose2 = available_capacity_dose2;
    }

    public String getFee() {
        return Fee;
    }

    public void setFee(String fee) {
        Fee = fee;
    }

    public String getMin_age_limit() {
        return Min_age_limit;
    }

    public void setMin_age_limit(String min_age_limit) {
        Min_age_limit = min_age_limit;
    }
}
