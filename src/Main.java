import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Pupilmanagement pupilmanagement = new Pupilmanagement();
        ClassPupilManagement classPupilManagement = new ClassPupilManagement();
        TetScoresManagemement tetScoresManagemement = new TetScoresManagemement();

        Scanner sc = new Scanner(System.in);



        int option = -1;

        while (option != 0){
            showMenu();
            option = sc.nextInt();
            switch (option){
                case 1:
                    pupilmanagement.menu("Pupil Management");
                    break;
                case 2:
                    classPupilManagement.menu("ClassPupil Management");
                    break;
                case 3:
                    tetScoresManagemement.menu("TestScore Management");
                    break;
             }
        }
    }
    private static void showMenu(){
        System.out.println("1. Pupil Management");
        System.out.println("2. ClassPupil Management");
        System.out.println("3. TestScore Management");
        System.out.print("nhập số để chọn Menu:  ");
    }

}
