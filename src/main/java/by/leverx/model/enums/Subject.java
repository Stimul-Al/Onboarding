package by.leverx.model.enums;

public enum Subject {

    MATH("Math"),
    PHYSIC("Physic"),
    ENGLISH("English");

    private String subject;

    Subject(String subject) {
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }
}
