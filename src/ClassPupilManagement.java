import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClassPupilManagement extends Menu implements Management{
    List<ClassPupil> classPupilList;
    Scanner sc = new Scanner(System.in);

    public ClassPupilManagement(){
        classPupilList= new ArrayList<>();
        readFromFile();
    }


    public void readFromFile() {
        try {
            FileReader fileReader = new FileReader("DSLopHoc.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String s;
            while ((s = bufferedReader.readLine()) != null) {
                String [] ss = s.split(",");
                ClassPupil c = new ClassPupil(ss[0],ss[1],Integer.parseInt(ss[2]));
                classPupilList.add(c);
            }
            bufferedReader.close();
            fileReader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void saveFile(){
        try{
            FileWriter fileWriter = new FileWriter("DSLopHoc.csv");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for(ClassPupil classPupil : classPupilList){
                bufferedWriter.write(classPupil.toString());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();
        }catch (FileNotFoundException e){
            throw new RuntimeException(e);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public ClassPupil input(){
        ClassPupil classPupil = new ClassPupil();
            System.out.println("Nhập tên lớp học");
            String className = sc.nextLine();
            System.out.println("Nhập tên Giáo viên");
            String teacherName = sc.nextLine();
            System.out.println("Nhập số lượng");
            int amount = Integer.parseInt(sc.nextLine());
           ClassPupil newClassPupil = new ClassPupil(className,teacherName, amount);

        return newClassPupil;
    }

    public ClassPupil searchByClassName(String searchName){
        for(ClassPupil classPupil : classPupilList){
            if(classPupil.getClassName().equals(searchName)){
               return classPupil;
            }
        }return null;
    }
    @Override
    public void add(){
        boolean check;
    do{
        ClassPupil classPupil1 = input();
        check = classPupil1.validate(classPupil1.getClassName());
        if (check) {
            classPupilList.add(classPupil1);
            break;
        }else System.out.println("nhap lai ten lop: ");
    }while(check == false);
        saveFile();
    }
    @Override
    public void search(){
        System.out.println("Nhap ID can tim: ");
        String searchID = sc.nextLine();
        ClassPupil searchClassPupilID = searchByClassName(searchID);
        if(searchClassPupilID != null){
            System.out.println(searchClassPupilID.toString());
        }
        else System.out.println("search khong ton tai");
    }

    @Override
    public void remove(){
        System.out.println("Nhập ID cần tìm:");
        String searchID = sc.nextLine();
        ClassPupil removeID = searchByClassName(searchID);
        if(removeID != null){
            classPupilList.remove(removeID);
            System.out.println("SearchID đã xóa khỏi danh sách");
        }else
            System.out.println("searchID không tồn tại");
        saveFile();
    }

    @Override
    public void update(){
        System.out.println("nhập ID cần update: ");
        String searchID = sc.nextLine();
        ClassPupil updateID = searchByClassName(searchID);
        if(updateID != null ){
            System.out.println("ID cân update là ");
            String updateName = sc.nextLine();
            updateID.setClassName(updateName);
        }else
            System.out.println("ID không tồn tại");
        saveFile();
    }
    @Override
    public void displayAll(){
        for(ClassPupil classPupil : classPupilList){
            System.out.println(classPupil);
        }
    }
}
