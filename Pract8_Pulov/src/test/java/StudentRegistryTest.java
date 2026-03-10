import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.univercity.Student;
import ua.univercity.StudentRegistry;

import static org.junit.jupiter.api.Assertions.*;

class StudentRegistryTest {

    private StudentRegistry registry;

    @BeforeEach
    void setUp() {
        registry = new StudentRegistry();
        registry.addStudent(new Student("1", "test@ukma.edu.ua", "Irzhek Zbyshekowych"));
    }

    @Test
    void testRemoveById_findByIdReturnsNull() {
        registry.removeById("1");

        assertNull(registry.findById("1"), "findById returns null");
    }

    @Test
    void testRemoveById_containsEmailBecomesFalse() {
        assertTrue(registry.containsEmail("test@ukma.edu.ua"));

        registry.removeById("1");
        assertFalse(registry.containsEmail("test@ukma.edu.ua"), "Email has not to be found");
    }

    @Test
    void testRemoveById_allowsAddingSameEmailAgain() {
        registry.removeById("1");

        Student newStudent = new Student("2", "test@ukma.edu.ua", "New Irzhek");

        boolean isAdded = registry.addStudent(newStudent);
        assertTrue(isAdded, "Has to work with new email");
    }
}