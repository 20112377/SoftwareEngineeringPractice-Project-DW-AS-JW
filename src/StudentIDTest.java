import org.junit.Test;
import static org.junit.Assert.*;


public class StudentIDTest {

    @Test
    public void activeStudentAccess() {

        StudentID id = new StudentID("20112377", true);
        assertTrue("Active student should be granted access", id.canAccessLibrary());
    }

    @Test
    public void inactiveStudentDeny() {
        StudentID id = new StudentID("20112377", false);
        assertFalse("Inactive student should be denied access", id.canAccessLibrary());
    }

    @Test
    public void nullStudentID() {
        StudentID id = new StudentID(null, true);
        assertFalse("Null student ID should be denied access", id.canAccessLibrary());
    }
}