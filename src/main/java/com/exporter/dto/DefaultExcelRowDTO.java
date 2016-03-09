package com.exporter.dto;

/**
 * @author Roman Voloboev
 */

public class DefaultExcelRowDTO {
    private String name;
    private String phone;
    private String email;
    private String date;
    private String company;
    private String country;
    private String city;
    private String guid;

    public DefaultExcelRowDTO() {
    }

    public DefaultExcelRowDTO(String name, String phone, String email, String date, String company,
                              String country, String city, String guid) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.date = date;
        this.company = company;
        this.country = country;
        this.city = city;
        this.guid = guid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }
}
