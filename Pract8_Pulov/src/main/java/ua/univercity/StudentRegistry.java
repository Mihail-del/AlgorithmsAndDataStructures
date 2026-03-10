package ua.univercity;

import java.util.*;

public class StudentRegistry {

    private final List<Student> studentsList = new ArrayList<>();

    private final Set<String> emailSet = new HashSet<>();

    private final Map<String, Student> idToStudentMap = new HashMap<>();


    public boolean addStudent(Student student) {
        if (student == null) return false;

        if (emailSet.contains(student.getEmail()) || idToStudentMap.containsKey(student.getId())) {
            System.out.println("There is already an student with the same email or ID");
            return false;
        }

        studentsList.add(student);
        emailSet.add(student.getEmail());
        idToStudentMap.put(student.getId(), student);

        System.out.println("Added: " + student);
        return true;
    }

    public Student findById(String id) {
        return idToStudentMap.get(id);
    }

    public boolean containsEmail(String email) {
        return emailSet.contains(email);
    }

    public boolean removeById(String id) {
        Student studentToRemove = idToStudentMap.get(id);

        if (studentToRemove == null) {
            return false;
        }

        idToStudentMap.remove(id);
        emailSet.remove(studentToRemove.getEmail());
        studentsList.remove(studentToRemove);

        System.out.println("Deleted: " + studentToRemove);
        return true;
    }

    public void printAll() {
        System.out.println("All students: " + studentsList);
    }
}
