package com.razerinsure.Client;

import java.util.List;

public class Client {
    class idDocuments
    {
        private String identificationDocumentTemplateKey;
        private String issuingAuthority;
        private String documentType;
        private String validUntil;
        private String documentId;
    }

    class Address
    {
        private String line1;
        private String line2;
        private String city;
        private String region;
        private String postcode;
        private String country;
    }

    private String firstName;
    private String lastName;
    private String preferredLanguage;
    private String notes;
    private String assignedBranchKey;
    private List<idDocuments> idDocumentsList;
    private List<Address> addressList;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPreferredLanguage() {
        return preferredLanguage;
    }

    public String getNotes() {
        return notes;
    }
}
