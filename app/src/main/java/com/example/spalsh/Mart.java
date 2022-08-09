package com.example.spalsh;

import android.accessibilityservice.AccessibilityGestureEvent;

import com.google.android.material.textfield.TextInputEditText;

public class Mart {
    private String Name,Age,Address,persons,id_proof,suggestions;

    public Mart(String names, String ages, String addresses, String persons, String id_proof, String suggestions) {
        Name = names;
        Age = ages;
        Address = addresses;
        this.persons = persons;
        this.id_proof = id_proof;
        this.suggestions = suggestions;
    }


    public java.lang.String getName() {
        return Name;
    }

    public void setName(java.lang.String name) {
        Name = name;
    }

    public java.lang.String getAge() {
        return Age;
    }

    public void setAge(java.lang.String age) {
        Age = age;
    }

    public java.lang.String getAddress() {
        return Address;
    }

    public void setAddress(java.lang.String address) {
        Address = address;
    }

    public java.lang.String getPersons() {
        return persons;
    }

    public void setPersons(java.lang.String persons) {
        this.persons = persons;
    }

    public java.lang.String getId_proof() {
        return id_proof;
    }

    public void setId_proof(java.lang.String id_proof) {
        this.id_proof = id_proof;
    }

    public java.lang.String getSuggestions() {
        return suggestions;
    }

    public void setSuggestions(java.lang.String suggestions) {
        this.suggestions = suggestions;
    }
}
