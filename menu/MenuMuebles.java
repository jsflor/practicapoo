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
                    printSeparator();
                    addMueble();
                    break;
                case 2:
                    printSeparator();
                    updateMueble();
                    break;
                case 3:
                    printSeparator();
                    deleteMueble();
                    break;
                case 4:
                    printSeparator();
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
                    printSeparator();
                    ok = true;
                    break;
                case 2:
                    m = displaySillaOpts();
                    printSeparator();
                    ok = true;
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + opt);
            }
        } while (!ok);

        printMueble(m);
        getDb().getMuebles().insertOneMueble(m);
        printSeparator();
    }

    void updateMueble(){
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

        List<Mueble> muebles = getDb().getMuebles().getMuebleById(filter, id);
        if(muebles.size() > 0){
            Mueble m = muebles.get(0);
            printSeparator();
            System.out.println("Estado actual mueble seleccionado");
            printMueble(m);

            String articleName = readText("Introduzca nombre de articulo");
            float price = readPrice();

            m.setModelName(articleName);
            m.setPrice(price);

            printSeparator();
            System.out.println("Mueble actualizado");
            printMueble(m);
        }

    }

    void deleteMueble(){
        System.out.println("del");
    }

    Mueble displayMesaOpts() {
        boolean ok;
        Mueble mesa;
        do {
            int optionSelected = printMesaOpts();

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
            int optionSelected = printSillaOpts();

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
}
