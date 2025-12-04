package org.example;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("== motivation 실행 ==");
        Scanner sc=new Scanner(System.in);
        boolean isRunning=true;
        while(isRunning){
            System.out.print("명령어 ) ");
            String command=sc.nextLine().trim();
            switch(command){
                case "add":
                    MotivationManage.addMotivation();
                    break;

                case "list":
                    MotivationManage.printMotivations();
                    break;

                case "exit":
                    isRunning=false;
                    break;
                case "" :
                    System.out.println("명령어가 입력되지 않았음");
                    break;
                default:
                    System.out.println("올바른 명령어를 입력해주세요.");
            }
        }
        sc.close();
        System.out.println("== motivation 종료 ==");

    }

}
class Motivation{
    String motivation;
    String source;
    int id;
}
class MotivationManage{
    static List<Motivation> motivations = new ArrayList<>();
    String motivation;
    String source;
    static int lastId=1;
    static void addMotivation(){
        Motivation motivation = new Motivation();
        Scanner sc = new Scanner(System.in);
        System.out.print("motivation : ");
        motivation.motivation = sc.nextLine();
        System.out.print("source : ");
        motivation.source = sc.nextLine();
        motivation.id = lastId;
        System.out.printf("%d번 motivation이 등록 되었습니다.\n",motivation.id);
        lastId ++;
        motivations.add(motivation);
    }
    static void printMotivations(){
        System.out.println("===============================");
        System.out.println("번호  /  source  /   motivation");
        for(int i=motivations.size()-1;i>=0;i--){
            Motivation motiv = motivations.get(i);
            System.out.printf(" %d     %s    %s \n",motiv.id, motiv.source, motiv.motivation);
        }
        System.out.println("===============================");
    }
}