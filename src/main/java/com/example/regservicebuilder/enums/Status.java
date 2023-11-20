package com.example.regservicebuilder.enums;

public enum Status {
    YES("YES"),
    NO("NO");

    private final String statusValue;

    Status(String statusValue) {
        this.statusValue = statusValue;
    }

    public String getStatusValue() {
        return statusValue;
    }
}
