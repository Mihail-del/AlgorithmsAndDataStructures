package ua.univercity;

import java.util.Objects;

public class Student {
    private final String id;
    private final String email;
    private final String name;

    public Student(String id, String email, String name) {
        this.id = id;
        this.email = email;
        this.name = name;
    }

    public String getId() { return id; }
    public String getEmail() { return email; }
    public String getName() { return name; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Student{" + "id='" + id + '\'' + ", email='" + email + '\'' + '}';
    }
}
