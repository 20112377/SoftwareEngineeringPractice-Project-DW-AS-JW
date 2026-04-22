public class Timetable {
    private String studentId;
    private String scheduleData = "No data synced yet";
    private boolean isConnected = true;

    public Timetable(String studentId) {
        this.studentId = studentId;
    }

    public void syncData(String serverData) {
        if (isConnected && serverData != null) {
            this.scheduleData = serverData;
        }
    }

    public String getSchedule() {
        if (scheduleData == null || scheduleData.isEmpty()) {
            return "No classes scheduled";
        }
        return scheduleData;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setConnectionStatus(boolean b) {
        this.isConnected = b;
    }
}