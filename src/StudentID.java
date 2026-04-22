public class StudentID {
    private String studentNumber;
    private boolean isActive;

    public StudentID(String studentNumber, boolean isActive) {
        this.studentNumber = studentNumber;
        this.isActive = isActive;
    }
    public boolean canAccessLibrary(){
        return isActive && studentNumber != null && !studentNumber.isEmpty();
    }

}
