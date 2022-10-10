import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TetScoresManagemement extends Menu implements Management {
    List<TestScore> testScoreList;
Scanner sc = new Scanner(System.in);
    public TetScoresManagemement() {
        testScoreList = new ArrayList<>();
        readFromFile();

    }
    public TestScore input() {
        System.out.println("Nhập MS: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập MSHS: ");
        String pupilID = sc.nextLine();
        System.out.println("Nhập Môn thi: ");
        String subjects = sc.nextLine();
        System.out.println("Nhập điểm thi: ");
        double score = Double.parseDouble(sc.nextLine());
        TestScore newTestScoreList = new TestScore(id,pupilID,subjects,score);
        return newTestScoreList;
    }
    @Override
    public void add() {
        TestScore newTestScoreList = input();
        testScoreList.add(newTestScoreList);
        saveFile();
    }
    public TestScore searchByName(String searchName){
        for (TestScore testScore : testScoreList){
            if(testScore.getPupilID().equals(searchName)){
                return testScore;
            }
        }return null;
    }
    public List<TestScore> searchByID(String ID) {
        List<TestScore> findingTestScores = new ArrayList<>();
        for (TestScore score : testScoreList) {
            if (score.getPupilID().equals(ID)) findingTestScores.add(score);
            System.out.println(score);
        }
        return findingTestScores;
    }
    @Override
    public void search() {
        System.out.println("nhập scoreID cần tìm: ");
        String searchID = sc.nextLine();
        System.out.println("searchID: " + searchID);
        TestScore searchScoreID = searchByName(searchID);
        if (searchScoreID != null) {

            System.out.println(searchScoreID);
        } else
            System.out.println("ScoreID không tồn tại");
    }
    @Override
    public void remove() {
        System.out.println("nhập ID cần tìm");
        String searchID = sc.nextLine();
        TestScore removeID = searchByName(searchID);
        if (removeID != null) {
            testScoreList.remove(removeID);
            System.out.println("searchID đã xóa khỏi danh sách");
        } else{
            System.out.println("searchID không tồn tại");
        }
        saveFile();
    }
    @Override
    public void update() {
        System.out.println("nhập Name cần update");
        String searchName = sc.nextLine();
        TestScore updateName = searchByName(searchName);
        if (updateName != null) {
            System.out.println("Name cần update là");
            String nameUpdate = sc.nextLine();
            updateName.setPupilID(nameUpdate);
            System.out.println(updateName.toString());

        } else
            System.out.println("updateID không tồn tại");
        saveFile();
    }

    public double totalScore() {
        double sum = 0;
        int count = 0;

            for (TestScore testScore : testScoreList) {
                System.out.println("nhập pupilId cần tính tổng");
                String pupilScore = sc.nextLine();
                List<TestScore> pupilId = searchByID(pupilScore);
                if (testScore.getPupilID().equals(pupilScore)) {
                    for(int i = 0; i < testScoreList.size();i++){
                        sum += testScore.getScore();
                        count++;
                    }
                } else System.out.println("pupil nhập sai");
            }
          return sum;
    }

    public double avgScore() {
        readFromFile();
        double sum = 0;
        int count = 0;
        for (TestScore testScore : testScoreList) {
            System.out.println("nhập pupilId cần tính tổng");
            String pupilID = sc.nextLine();
            if (testScore.getPupilID().equals(pupilID)) {
                sum += testScore.getScore();
                count++;
            } else System.out.println("pupil nhập sai");


        }
        return sum / count;
    }
    @Override
    public void readFromFile() {
        //testScoreList.clear();

        try {
            FileReader fileReader = new FileReader("DiemThi2.csv");
            BufferedReader reader = new BufferedReader(fileReader);
            String s;
            while ((s = reader.readLine()) != null) {
                String[] ss = s.split(",");
                TestScore t = new TestScore(Integer.parseInt(ss[0]),ss[1],ss[2],Double.parseDouble(ss[3]));
                testScoreList.add(t);
            }
            reader.close();
            fileReader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void saveFile() {
        try {
            FileWriter fileWriter = new FileWriter("DiemThi2.csv");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (TestScore t : testScoreList) {
                bufferedWriter.write(t.toString1());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (FileNotFoundException e){
            throw new RuntimeException(e);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void displayAll() {
        for (TestScore testScore : testScoreList) {
            System.out.println(testScore);
        }
    }
    @Override
    public void showMenu(String displayMenu) {
        System.out.println("Danh Sách Của MENU: " + displayMenu);
        System.out.println("1. Add");
        System.out.println("2. Search");
        System.out.println("3. Update");
        System.out.println("4. Remove");
        System.out.println("5. Display");
        System.out.println("8. Total Score");
        System.out.println("9. Avg Score");
        System.out.println("0. Exit");
        System.out.println("Enter option: ");
    }
    @Override
    public void menu(String displayMenu) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            showMenu(displayMenu);
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    add();
                    break;
                case 2:
                    search();
                    break;
                case 3:
                    update();
                    break;
                case 4:
                    remove();
                    break;
                case 5:
                    displayAll();
                    break;
                case 6:
                    readFromFile();
                    break;
                case 7:
                    saveFile();
                    break;
                case 8:
                    totalScore();
                    break;
                case 9:
                    avgScore();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("ban nhap sai, ban hay nhap lai");
                    break;

            }
        }
    }
}