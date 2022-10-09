public class TestScore{
    private Integer id;
    private String pupilID;
    private String subjects;
    private double score;

    public TestScore(String pupilID, String subjects, double score){
        this.pupilID = pupilID;
        this.subjects = subjects;
        this.score = score;
    }
    public TestScore(Integer id, String pupilID, String subjects, double score) {
        this.id = id;
        this.pupilID = pupilID;
        this.subjects = subjects;
        this.score = score;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPupilID() {
        return pupilID;
    }

    public void setPupilID(String pupilID) {
        this.pupilID = pupilID;
    }

    public String getSubjects() {
        return subjects;
    }

    public void setSubjects(String subjects) {
        this.subjects = subjects;
    }

    public double getScore() {
        return this.score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String toString1(){
        return id+","+pupilID+","+subjects+","+score;
    }
    @Override
    public String toString(){
        return "MS Diem: "+ id + " MSHS: "+ pupilID + " Mon hoc: "+subjects+ " Diem: "+score;
    }


}
