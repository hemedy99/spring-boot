package egoz.go.tz.testing.enums;

public enum GenderEnum {
    Male("M"), Female("F");

    private String gender;

    GenderEnum(String gender) {
        this.setGender(gender);
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    
}
