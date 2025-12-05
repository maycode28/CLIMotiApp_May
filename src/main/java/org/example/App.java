package org.example;

import org.example.motivation.controller.MotivationController;
import org.example.system.controller.SystemController;

import java.util.Scanner;

public class App {
    private Scanner sc;

    public App(Scanner sc) {
        this.sc = sc;
    }
    public void run() {
        System.out.println("== motivation 실행 ==");
        SystemController systemController = new SystemController();
        MotivationController motivationController = new MotivationController(sc);

        boolean isRunning = true;
        while(isRunning){
            System.out.print("명령어 ) ");
            String command = sc.nextLine().trim();
            String[] commands = command.split(" ");
            int id=0;
            if (commands.length > 1){
                try{
                    id=Integer.parseInt(commands[1]);
                }catch(Exception e){
                    System.out.println("올바른 명령어를 입력해주세요.");
                    continue;
                }
            }
            switch (commands[0]) {
                case "exit":
                    isRunning = false;
                    SystemController.exit();
                    break;

                case "":
                    System.out.println("명령어가 입력되지 않았음");
                    break;

                case "add":
                    MotivationController.add();
                    break;

                case "list":
                    MotivationController.list();
                    break;

                case "del" :
                    MotivationController.delete(id);
                    break;

                case "edit" :
                    MotivationController.edit(id);
                    break;

                case "detail" :
                    MotivationController.detail(id);
                    break;


                default:
                    System.out.println("올바른 명령어를 입력해주세요.");
            }
        }


    }


}

