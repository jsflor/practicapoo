package menu;

import mueble.*;

import java.util.List;

/**
 * Write a description of class MenuMuebles here.
 *
 * @author Juan Sebastian Flor Usma
 * @version 1.0.0
 */
public class MenuMuebles extends Menu {

    public MenuMuebles(){
        init();
    }

    void init(){
        boolean exit = false;
        do {
            System.out.println("Gestión muebles. Seleccione opción:");
            System.out.println("Añadir mueble     (1)");
            System.out.println("Actualizar mueble (2)");
            System.out.println("Borrar mueble     (3)");
            System.out.println("Salir             (4)");
            int optionSelected = readOption(4);
            switch (optionSelected){
                case 1:
                    printSpaces(1);
                    addMueble();
                    break;
                case 2:
                    printSpaces(1);
                    updateMueble();
                    break;
                case 3:
                    printSpaces(1);
                    deleteMueble();
                    break;
                case 4:
                    printSpaces(1);
                    exit = true;
                    break;
            }
        } while (!exit);
    }

    void addMueble(){
        boolean ok;
        Mueble m;
        int opt;
        do {
            System.out.println("Seleccione:");
            System.out.println("Mesa    (1)");
            System.out.println("Silla   (2)");
            opt = readOption(2);
            switch (opt){
                case 1:
                    m = displayMesaOpts();
                    ok = true;
                    break;
                case 2:
                    m = displaySillaOpts();
                    ok = true;
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + opt);
            }
        } while (!ok);

        printMueble(m);
        getDb().getMuebles().insertOneMueble(m);
    }

    void updateMueble(){
        System.out.println("update");
    }

    void deleteMueble(){
        System.out.println("del");
    }

    Mueble displayMesaOpts() {
        boolean ok;
        Mueble mesa;
        do {
            System.out.println("Seleccione:");
            System.out.println("Mesa dormitorio     (1)");
            System.out.println("Mesa comedor        (2)");
            System.out.println("Mesa cafe cristal   (3)");
            System.out.println("Mesa cafe madera    (4)");
            int optionSelected = readOption(4);

            String articleName = readText("Introduzca nombre de articulo");
            float price = readPrice();
            Material m = selectMaterial();

            switch (optionSelected){
                case 1:
                    mesa = new MesaDormitorio(articleName, price, m);
                    ok = true;
                    break;
                case 2:
                    mesa = new MesaComedor(articleName, price, m);
                    ok = true;
                    break;
                case 3:
                    mesa = new MesaCafeCristal(articleName, price, m);
                    ok = true;
                    break;
                case 4:
                    mesa = new MesaCafeMadera(articleName, price, m);
                    ok = true;
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + optionSelected);
            }
        } while (!ok);
        return mesa;
    }

    Mueble displaySillaOpts() {
        boolean ok;
        Mueble silla;
        do {
            System.out.println("Seleccione:");
            System.out.println("Silla cocina               (3)");
            System.out.println("Silla plegable             (4)");
            System.out.println("Silla oficina con ruedas   (1)");
            System.out.println("Silla oficina sin ruedas   (2)");
            int optionSelected = readOption(4);

            String articleName = readText("Introduzca nombre de articulo");
            float price = readPrice();
            Material m = selectMaterial();

            switch (optionSelected){
                case 1:
                    silla = new SillaCocina(articleName, price, m);
                    ok = true;
                    break;
                case 2:
                    silla = new SillaPlegable(articleName, price, m);
                    ok = true;
                    break;
                case 3:
                    silla = new SillaOficinaRuedas(articleName, price, m);
                    ok = true;
                    break;
                case 4:
                    silla = new SillaOficinaSinRuedas(articleName, price, m);
                    ok = true;
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + optionSelected);
            }
        } while (!ok);
        return silla;
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
        System.out.println("Id: " + m.getId());
        System.out.println("Tipo: " + m.getClass());
        System.out.println("Modelo: " + m.getModelName());
        System.out.println("Precio: " + m.getPrice());
        System.out.println("Material: " +m.getMaterial());
    }
}
