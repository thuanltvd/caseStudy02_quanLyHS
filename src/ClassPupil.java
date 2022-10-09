
import java.util.List;
import java.util.Scanner;

public class ClassPupil {

    Pupilmanagement pupilmanagement = new Pupilmanagement();
    private String className;
    private String teacherName;
    private String SL;
    Scanner sc = new Scanner(System.in);

    public ClassPupil(String className, String teacherName,String SL) {
        this.SL = SL;
        this.className = className;
        this.teacherName = teacherName;

    }

    public String getSL() {
        return SL;
    }

    public void setSL(String SL) {
        this.SL = SL;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
    @Override
    public String toString(){
        return className+","+teacherName+","+SL;
    }


}
