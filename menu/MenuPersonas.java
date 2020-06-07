package menu;

import persona.*;

/**
 * Write a description of class MenuMPersonas here.
 *
 * @author Juan Sebastian Flor Usma
 * @version 1.0.0
 */
public class MenuPersonas extends Menu {

    public MenuPersonas(){
        init();
    }

    private void init(){
        boolean exit = false;
        do {
            System.out.println("Gestión personas. Seleccione opción:");
            System.out.println("Alta empleado     (1)");
            System.out.println("Alta cliente      (2)");
            System.out.println("Buscar persona    (3)");
            System.out.println("Salir             (4)");
            int optionSelected = readOption(4);
            switch (optionSelected){
                case 1:
                    printSeparator();
                    addEmpleado();
                    break;
                case 2:
                    printSeparator();
                    addCliente();
                    break;
                case 3:
                    printSeparator();
                    searchPersona();
                    break;
                case 4:
                    printSeparator();
                    exit = true;
                    break;
            }
        } while (!exit);
    }

    private void searchPersona() {
        boolean ok;
        Persona p = null;
        do {
            try{
                System.out.println("Seleccione: ");
                System.out.println("Cliente     (1)");
                System.out.println("Empleado    (2)");
                int opt = readOption(2);
                String id = readText("Indique id");
                switch (opt){
                    case 1:
                        p = getDb().getPersonas().getPersonaById("CLIENTE", id);
                        ok = true;
                        break;
                    case 2:
                        p = getDb().getPersonas().getPersonaById("EMPLEADO", id);
                        ok = true;
                        break;
                    default:
                        ok = false;
                        break;
                }
                printSeparator();
                p.printData();
                printSeparator();
            } catch (Exception e){
                System.out.println(e.getMessage());
                ok = false;
            }
        } while (!ok);
    }

    private void addEmpleado(){
        boolean ok;
        Persona p = null;
        int opt;
        do {
            System.out.println("Seleccione:");
            System.out.println("Jefe               (1)");
            System.out.println("Comercial          (2)");
            System.out.println("Artesano hora      (1)");
            System.out.println("Artesano plantilla (2)");
            opt = readOption(4);
            switch (opt){
                case 1:
                    p = displayEmpleadoOpts(1);
                    printSeparator();
                    ok = true;
                    break;
                case 2:
                    p = displayEmpleadoOpts(2);
                    printSeparator();
                    ok = true;
                    break;
                case 3:
                    p = displayEmpleadoOpts(3);
                    printSeparator();
                    ok = true;
                    break;
                case 4:
                    p = displayEmpleadoOpts(4);
                    printSeparator();
                    ok = true;
                    break;
                default:
                    ok = false;
                    break;
            }
        } while (!ok);

        p.printData();
        p.printFiscalData();
        p.printAddress();
        getDb().getPersonas().insertOnePersona(p);
        printSeparator();
    }

    private void addCliente(){
        boolean ok;
        Persona p = null;
        int opt;
        do {
            System.out.println("Seleccione:");
            System.out.println("Particular       (1)");
            System.out.println("Empresa          (2)");
            opt = readOption(2);
            switch (opt){
                case 1:
                    p = displayClienteOpts(1);
                    printSeparator();
                    ok = true;
                    break;
                case 2:
                    p = displayClienteOpts(2);
                    printSeparator();
                    ok = true;
                    break;
                default:
                    ok = false;
                    break;
            }
        } while (!ok);

        printSeparator();
        p.printData();
        getDb().getPersonas().insertOnePersona(p);
        printSeparator();
    }

    private Persona displayEmpleadoOpts(int type){
        boolean ok;
        Persona p = null;
        do {
            String name = readText("Introduzca nombre del empleado");
            String id = readText("Introduzca id documentacion fiscal");

            switch (type){
                case 1:
                    p = new Jefe(name, id);
                    ok = true;
                    break;
                case 2:
                    p = new Comercial(name, id);
                    ok = true;
                    break;
                case 3:
                    p = new ArtesanoHora(name, id);
                    ok = true;
                    break;
                case 4:
                    p = new ArtesanoPlantilla(name, id);
                    ok = true;
                    break;
                default:
                    ok = false;
                    break;
            }
        } while (!ok);
        addressOpts(p);
        return p;
    }

    private Persona displayClienteOpts(int type){
        boolean ok;
        Persona p = null;
        do {
            String name = readText("Introduzca nombre del cliente");
            String id = readText("Introduzca id documentacion fiscal");

            switch (type){
                case 1:
                    p = new Particular(name, id);
                    ok = true;
                    break;
                case 2:
                    p = new Empresa(name, id);
                    ok = true;
                    break;
                default:
                    ok = false;
                    break;
            }
        } while (!ok);
        addressOpts(p);
        return p;
    }

    private void addressOpts(Persona p){
        boolean ok;
        do {
            System.out.println("¿Desea introducir direccion?");
            System.out.println("Si (1)");
            System.out.println("No (2)");
            int opt = readOption(2);
            switch (opt){
                case 1:
                    Address a = readAddress();
                    p.setAddress(a);
                    ok = true;
                    break;
                case 2:
                    ok = true;
                    break;
                default:
                    ok = false;
                    break;
            }
        } while (!ok);
    }

    private Address readAddress(){
        String street = readText("Calle");
        String city = readText("Ciudad");
        String zipCode = readText("CP");
        String country = readText("Pais");
        int phone = Integer.parseInt(readText("Telefono"));
        return new Address(street, city, zipCode, country, phone);
    }
}
