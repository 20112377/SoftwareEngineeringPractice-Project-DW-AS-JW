import org.junit.Test;
import static org.junit.Assert.*;

public class TimetableTest {

    @Test
    public void testOfflineAccess() {
        Timetable tt = new Timetable("20112377");
        tt.syncData("Monday: Maths 9:15, Room: FTG24");
        tt.setConnectionStatus(false); //offline
        String offlineView = tt.getSchedule();
        assertEquals("Monday: Maths 9:15, Room: FTG24", offlineView);
    }

    @Test
    public void testSyncFailsWhenOffline() {
        Timetable tt = new Timetable("20112377");
        tt.syncData("Old Data");

        tt.setConnectionStatus(false);
        tt.syncData("New Data");

        assertEquals("Old Data", tt.getSchedule());
    }
    @Test
    public void testDataBelongsToCorrectStudent() {
        Timetable tt = new Timetable("20112377");
        assertEquals("20112377", tt.getStudentId());
    }
    @Test
    public void testEmptyScheduleMessage() {
        Timetable tt = new Timetable("20112377");
        tt.syncData(""); // Server returns an empty string

        String result = tt.getSchedule();
        assertTrue(result.contains("No classes scheduled"));
    }
    @Test
    public void testNullStudentID(){
        Timetable tt = new Timetable(null);
        assertNull(tt.getStudentId());
    }
}