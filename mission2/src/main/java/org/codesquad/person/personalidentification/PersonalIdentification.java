package org.codesquad.person.personalidentification;

public class PersonalIdentification {
    private final String name;
    private Integer age;
    private Gender gender;

    public PersonalIdentification(String name) {
        this.name = name;
    }

    public PersonalIdentification(String name, int age, Gender gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender.getTitle();
    }
}
