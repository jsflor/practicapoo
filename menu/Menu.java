package menu;

import db.Database;

import java.util.Scanner;

/**
 * Write a description of class Menu here.
 *
 * @author Juan Sebastian Flor Usma
 * @version 1.0.0
 */
abstract class Menu {

    static private final Database db = new Database();

    protected Menu() {

    }

    public int readOption(int optionsQuantiy){
        Scanner input = new Scanner(System.in);
        boolean ok = false;
        int option = 1;
        do {
            try {
                option = Integer.parseInt(input.nextLine());
                if(option >= 1 && option <= optionsQuantiy){
                    ok = true;
                } else {
                    System.out.println("Debe introducir numero entre 1 y " + optionsQuantiy);
                }
            } catch (NumberFormatException err){
                System.out.println("Debe introducir numero entre 1 y " + optionsQuantiy);
            }
        } while (!ok);
        return option;
    }

    public float readPrice(){
        Scanner input = new Scanner(System.in);
        boolean ok = false;
        float option = 0.0f;
        do {
            try {
                System.out.println("Introduzca precio");
                option = Float.parseFloat(input.nextLine());
                if(option >= 1){
                    ok = true;
                } else {
                    System.out.println("Debe introducir un numero mayor que 1");
                }
            } catch (NumberFormatException err){
                System.out.println("Debe introducir un numero mayor que 1");
            }
        } while (!ok);
        return option;
    }

    public String readText(String label){
        Scanner input = new Scanner(System.in);
        boolean ok = false;
        String text = "";
        do {
            try{
                System.out.println(label);
                text = input.nextLine();
                if(text.length() > 0){
                    ok = true;
                } else {
                    System.out.println("Debe introducir opciones validas");
                }
            } catch (StringIndexOutOfBoundsException err){
                System.out.println("Debe introducir opciones validas");
            }
        } while (!ok);
        return text;
    }

    public void printSpaces(int qty){
        for(int i = 0; i < qty; i++){
            System.out.println("\n");
        }
    }

    public Database getDb() {
        return db;
    }
}
