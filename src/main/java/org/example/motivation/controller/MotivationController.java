package org.example.motivation.controller;

import org.example.motivation.entity.Motivation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MotivationController {
    static Scanner sc;
    public MotivationController(Scanner sc){
        this.sc = sc;
    }
    static List<Motivation> motivations = new ArrayList<>();
    static int lastId=1;
    public static void add(){
        Motivation motivation = new Motivation();
        System.out.print("motivation : ");
        motivation.setMotivation(sc.nextLine());
        System.out.print("source : ");
        motivation.setSource(sc.nextLine());
        motivation.setId(lastId);
        System.out.printf("%d번 motivation이 등록 되었습니다.\n",motivation.getId());
        lastId ++;
        motivations.add(motivation);
    }
    public static void list(){
        if (motivations.size() == 0) {
            System.out.println("등록된 motivation이 없습니다.-");
            return;
        }
        System.out.println("=".repeat(40));
        System.out.println("번호  /  source  /   motivation");
        for(int i=motivations.size()-1;i>=0;i--){
            System.out.println(motivations.get(i));
        }
        System.out.println("=".repeat(40));
    }
    public static void delete (int id) {
        if (motivations.size() == 0) {
            System.out.println("등록된 motivation이 없습니다.-");
            return;
        }

        for (Motivation motivation : motivations) {
            if (motivation.getId() == id) {
                motivations.remove(motivation);
                System.out.printf("%d번 motivation이 삭제되었습니다.\n", id);
                return;
            }
        }
        System.out.printf("%d번 motivation은 존재하지 않습니다.\n", id);
    }
    public static void edit(int id) {
        if (motivations.size() == 0) {
            System.out.println("등록된 motivation이 없습니다.");
            return;
        }

        for (Motivation motivation : motivations){
            if (motivation.getId() == id) {
                System.out.print("motivation : ");
                String motiv = sc.nextLine();
                System.out.print("source : ");
                String source = sc.nextLine();
                motivation.setMotivation(motiv);
                motivation.setSource(source);
                return;
            }
        }
        System.out.printf("%d번 motivation은 존재하지 않습니다.\n", id);
    }
    public static void detail(int id) {
        if (motivations.size() == 0) {
            System.out.println("등록된 motivation이 없습니다.-");
            return;
        }
        for (Motivation motivation : motivations){
            if (motivation.getId() == id) {
                System.out.println("=".repeat(40));
                System.out.println("번호  /  source  /   motivation");
                System.out.println(motivation);
                System.out.println("=".repeat(40));
                return;
            }
        }
        System.out.printf("%d번 motivation은 존재하지 않습니다.\n", id);
    }
}
