package org.codesquad.person.marriageinfo;

public class MarriageInfo {
    private final MaritalStatus maritalStatus;
    private final Integer child;

    public MarriageInfo(MaritalStatus maritalStatus, int child) {
        this.maritalStatus = maritalStatus;
        this.child = child;
    }

    public String getMaritalStatus() {
        return maritalStatus.getTitle();
    }

    public int getChild() {
        return child;
    }
}