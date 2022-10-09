public class Pupil {
    private String pupilID;
    private String firstAndLastName;
    private String dob;

    public Pupil(String pupilID, String firstAndLastName, String dob) {
        this.pupilID = pupilID;
        this.firstAndLastName = firstAndLastName;
        this.dob = dob;
    }

    public String getPupilID() {
        return this.pupilID;
    }

    public void setPupilID(String pupilID) {
        this.pupilID = pupilID;
    }

    public String getFirstAndLastName() {
        return firstAndLastName;
    }

    public void setFirstAndLastName(String firstAndLastName) {
        this.firstAndLastName = firstAndLastName;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }
    public String toString2(){
        return pupilID+","+firstAndLastName+","+dob;
    }
    @Override
    public String toString(){
        return "MSHS: "+ pupilID + " Họ và Tên: "+ firstAndLastName+ " Ngày sinh: "+dob;
    }



}
