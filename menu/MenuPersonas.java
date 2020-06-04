package menu;

import mueble.*;
import persona.*;

import java.util.List;

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

    void init(){
        boolean exit = false;
        do {
            System.out.println("Gestión personas. Seleccione opción:");
            System.out.println("Alta empleado     (1)");
            System.out.println("Alta cliente      (2)");
            System.out.println("Salir             (3)");
            int optionSelected = readOption(3);
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
                    exit = true;
                    break;
            }
        } while (!exit);
    }

    void addEmpleado(){
        boolean ok;
        Persona p;
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
                    throw new IllegalStateException("Unexpected value: " + opt);
            }
        } while (!ok);

        p.printData();
        p.printFiscalData();
        p.printAddress();
        getDb().getPersonas().insertOnePersona(p);
        printSeparator();
    }

    void addCliente(){
        boolean ok;
        Persona p;
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
                    throw new IllegalStateException("Unexpected value: " + opt);
            }
        } while (!ok);

        printPersona(p);
        getDb().getPersonas().insertOnePersona(p);
        printSeparator();
    }

    Persona displayEmpleadoOpts(int type){
        boolean ok;
        Persona p;
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
                    throw new IllegalStateException("Unexpected value: " + type);
            }
        } while (!ok);
        addressOpts(p);
        return p;
    }

    Persona displayClienteOpts(int type){
        boolean ok;
        Persona p;
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
                    throw new IllegalStateException("Unexpected value: " + type);
            }
        } while (!ok);
        addressOpts(p);
        return p;
    }

    void addressOpts(Persona p){
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
                    throw new IllegalStateException("Unexpected value: " + opt);
            }
        } while (!ok);
    }

    Address readAddress(){
        String street = readText("Calle");
        String city = readText("Ciudad");
        String zipCode = readText("CP");
        String country = readText("Pais");
        int phone = Integer.parseInt(readText("Telefono"));
        return new Address(street, city, zipCode, country, phone);
    }

    void printPersona(Persona p){
        System.out.println(" ");
        System.out.println("Id: " + p.getId());
        System.out.println("Tipo: " + p.getClass());
        System.out.println("Nombre: " + p.getName());
        System.out.println("Direccion: " + p.getAddress());
        System.out.println("Id: " + p.getFiscalId());
        System.out.println("Tipo documento: " + p.getFiscalIdType());
        System.out.println(" ");
    }
}
