package menu;

import db.Database;
import mueble.*;

import java.util.List;
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

    public void printSeparator(){
        System.out.println("******************************");
    }

    List<Mueble> getMueble(){
        String id;
        String filter;
        boolean ok;
        boolean okId;
        int type;

        do {
            System.out.println("Seleccione:");
            System.out.println("Mesa    (1)");
            System.out.println("Silla   (2)");
            int opt = readOption(2);
            switch (opt){
                case 1:
                    type = printMesaOpts();
                    filter = mapMesaOptionToString(type);
                    ok = true;
                    break;
                case 2:
                    type = printSillaOpts();
                    filter = mapSillaOptionToString(type);
                    ok = true;
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + opt);
            }
        } while (!ok);

        okId = false;
        do {
            id = readText("Introduzca id del mueble a editar");
            if(id.length() > 0){
                okId = true;
            }
        } while (!okId);

        return getDb().getMuebles().getMuebleById(filter, id);
    }

    int printMesaOpts(){
        System.out.println("Seleccione:");
        System.out.println("Mesa dormitorio     (1)");
        System.out.println("Mesa comedor        (2)");
        System.out.println("Mesa cafe cristal   (3)");
        System.out.println("Mesa cafe madera    (4)");
        return readOption(4);
    }

    int printSillaOpts(){
        System.out.println("Seleccione:");
        System.out.println("Silla cocina               (3)");
        System.out.println("Silla plegable             (4)");
        System.out.println("Silla oficina con ruedas   (1)");
        System.out.println("Silla oficina sin ruedas   (2)");
        return readOption(4);
    }

    String mapMesaOptionToString(int type){
        String opt;
        switch (type){
            case 1:
                opt = "MESADORMITORIO";
                break;
            case 2:
                opt = "MESACOMEDOR";
                break;
            case 3:
                opt = "MESACAFECRISTAL";
                break;
            case 4:
                opt = "MESACAFEMADERA";
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + type);
        }
        return opt;
    }

    String mapSillaOptionToString(int type){
        String opt;
        switch (type){
            case 1:
                opt = "SILLACOCINA";
                break;
            case 2:
                opt = "SILLAPLEGABLE";
                break;
            case 3:
                opt = "SILLAOFICINARUEDAS";
                break;
            case 4:
                opt = "SILLAOFICINASINRUEDAS";
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + type);
        }
        return opt;
    }

    Material selectMaterial(){
        boolean ok = false;
        Material m = Material.MADERA;
        do {
            System.out.println("Seleccione material:");
            System.out.println("Madera      (1)");
            System.out.println("Cristal     (2)");
            System.out.println("Plastico    (3)");
            System.out.println("Metal       (4)");
            int optionSelected = readOption(4);

            switch (optionSelected){
                case 1:
                    m = Material.MADERA;
                    ok = true;
                    break;
                case 2:
                    m = Material.CRISTAL;
                    ok = true;
                    break;
                case 3:
                    m = Material.PLASTICO;
                    ok = true;
                    break;
                case 4:
                    m = Material.METAL;
                    ok = true;
                    break;
            }
        } while (!ok);
        return m;
    }

    void printMueble(Mueble m){
        System.out.println(" ");
        System.out.println("Id: " + m.getId());
        System.out.println("Tipo: " + m.getClass());
        System.out.println("Modelo: " + m.getModelName());
        System.out.println("Precio: " + m.getPrice());
        System.out.println("Material: " +m.getMaterial());
        System.out.println(" ");
    }

    public Database getDb() {
        return db;
    }
}
