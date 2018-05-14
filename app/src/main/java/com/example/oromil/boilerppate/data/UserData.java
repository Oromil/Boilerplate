package com.example.oromil.boilerppate.data;

/**
 * Created by Oromil on 19.03.2018.
 */

public class UserData {


    // TODO: 07.05.2018 use Builder 
    public UserData() {
    }

    private String name;
    private String surname;
    private String patronymic;
    private String gender;
    private String height;
    private String weight;
    private String diagnosys;

    public static Builder newBuilder() {
        return new UserData().new Builder();
    }

    public class Builder {

        private Builder() {
        }

        public Builder name(String s) {
            UserData.this.name = s;
            return this;
        }

        public Builder surname(String s) {
            UserData.this.surname = s;
            return this;
        }

        public Builder patronymic(String s) {
            UserData.this.patronymic = s;
            return this;
        }

        public Builder gender(String s) {
            UserData.this.gender = s;
            return this;
        }

        public Builder height(String s) {
            UserData.this.height = s;
            return this;
        }

        public Builder weight(String s) {
            UserData.this.weight = s;
            return this;
        }

        public Builder diagnosis(String s) {
            UserData.this.diagnosys = s;
            return this;
        }

        public UserData build() {
            return UserData.this;
        }
    }

    public String getGender() {
        return gender;
    }

    public String getDiagnosys() {
        return diagnosys;
    }

    public String getHeight() {
        return height;
    }

    public String getName() {
        return name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getSurname() {
        return surname;
    }

    public String getWeight() {
        return weight;
    }
}

