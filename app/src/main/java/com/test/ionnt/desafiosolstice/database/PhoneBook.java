
package com.test.ionnt.desafiosolstice.database;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class PhoneBook implements Serializable {
    private String name;
    private String id;
    private String companyName;
    private Boolean isFavorite;
    private String smallImageURL;
    private String largeImageURL;
    private String emailAddress;
    private String birthdate;
    private Phone phone;
    private Address address;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public PhoneBook(String name, String id, String companyName, Boolean isFavorite,
                     String smallImageURL, String largeImageURL, String emailAddress, String birthdate,
                     Phone phone, Address address, Map<String, Object> additionalProperties) {
        this.name = name;
        this.id = id;
        this.companyName = companyName;
        this.isFavorite = isFavorite;
        this.smallImageURL = smallImageURL;
        this.largeImageURL = largeImageURL;
        this.emailAddress = emailAddress;
        this.birthdate = birthdate;
        this.phone = phone;
        this.address = address;
        this.additionalProperties = additionalProperties;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Boolean getIsFavorite() {
        return isFavorite;
    }

    public void setIsFavorite(Boolean isFavorite) {
        this.isFavorite = isFavorite;
    }

    public String getSmallImageURL() {
        return smallImageURL;
    }

    public void setSmallImageURL(String smallImageURL) {
        this.smallImageURL = smallImageURL;
    }

    public String getLargeImageURL() {
        return largeImageURL;
    }

    public void setLargeImageURL(String largeImageURL) {
        this.largeImageURL = largeImageURL;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
