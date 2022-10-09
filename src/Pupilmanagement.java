import java.io.*;
import java.util.*;

public class Pupilmanagement extends Menu implements Management {
    List<Pupil> pupilList;
    Scanner sc = new Scanner(System.in);

    public Pupilmanagement(){
        pupilList = new ArrayList<>();
        readFromFile();
    }

    @Override
    public void readFromFile(){
        try{
            FileInputStream fileInputStream = new FileInputStream("Example_caseStudy2.csv");
            Scanner sc = new Scanner(fileInputStream);
            String s ;
            String[] line;
            while (sc.hasNextLine()){
                s = sc.nextLine();
                line= s.split(",");
                Pupil p =new Pupil(line[0],line[1],line[2]);
                pupilList.add(p);
            }
            fileInputStream.close();
//        }catch (FileNotFoundException e){
//            throw new RuntimeException(e);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void saveFile(){
        try{
            FileWriter fileWriter = new FileWriter("Example_caseStudy2.csv");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for(Pupil pupil : pupilList){
                bufferedWriter.write(pupil.toString2());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e){
            System.out.println("không ghi được file");
            e.printStackTrace();
        }
    }
    public Pupil input(){
        System.out.println("Nhập MSHS: ");
        String pupilID = sc.nextLine();
        System.out.println("Nhập Họ và Tên: ");
        String firstAndLastName = sc.nextLine();
        System.out.println(" Nhập năm Sinh");
        String dob = sc.nextLine();

        return new Pupil(pupilID, firstAndLastName, dob);
    }
    public Pupil searchByID(String searchID){
        for(Pupil pupil : pupilList){
            if(pupil.getPupilID().equals(searchID)) return pupil;
        }
        return null;
    }
    @Override
    public void add(){
        //pupilList = new ArrayList<>();
        Pupil newPupilList = input();
        pupilList.add(newPupilList);
        saveFile();
    }

    @Override
    public void search(){
        System.out.println("Nhập ID cần tìm:");
        String searchPupilID = sc.nextLine();

        Pupil searchName = searchByID(searchPupilID);
        if(searchName != null)
            System.out.println(searchName);
        else
            System.out.println(" pupil not found");

    }

    @Override
    public void update(){
        System.out.println("Nhập ID cần tìm:");
        String searchPupilID = sc.nextLine();
        Pupil searchName = searchByID(searchPupilID);
        if(searchName != null){
            System.out.println("Update Name");
            String nameUpdate = sc.nextLine();
            searchName.setPupilID(nameUpdate);
            System.out.println(searchName.toString());
        }else {
            System.out.println("tên học sinh không có trong danh sách lớp");
        }
        saveFile();
    }

    @Override
    public void remove(){
        System.out.println("Nhập ID cần tìm:");
        String searchID = sc.nextLine();
        Pupil searchName = searchByID(searchID);
        if(searchName != null){
            pupilList.remove(searchName);
            System.out.println("Tên HS đã bị xóa");
        }else
            System.out.println("tên HS không tồn tại");
        saveFile();
    }

    @Override
    public void displayAll(){
        for (Pupil pupil: pupilList){
            System.out.println("Danh Sach HS : "+ pupil);
        }
    }
}
