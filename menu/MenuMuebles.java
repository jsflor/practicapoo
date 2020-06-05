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
            System.out.println("Buscar mueble     (3)");
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
                    searchMueble();
                    exit = true;
                    break;
                case 4:
                    printSeparator();
                    exit = true;
                    break;
            }
        } while (!exit);
    }

    private void searchMueble() {
        boolean ok = false;
        Mueble m;
        String id = readText("Indique id del mueble");
        do {
            System.out.println("Seleccione:");
            System.out.println("Mesa     (1)");
            System.out.println("Silla    (2)");
            int optionSelected = readOption(4);
            switch (optionSelected){
                case 1:
                case 2:
            }
        } while (!ok);
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
        List<Mueble> muebles = getMueble();
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
        } else {
            System.out.println("No hemos encontrado muebles con los parametros de busqueda seleccionados");
        }

    }

    Mueble displayMesaOpts() {
        boolean ok;
        Mueble mesa;
        do {
            int optionSelected = printMesaOpts();

            String articleName = readText("Introduzca nombre de articulo");
            float price = readPrice();

            /*Material m = selectMaterial();*/

            switch (optionSelected){
                case 1:
                    mesa = new MesaDormitorio(articleName, price, selectMaterial());
                    ok = true;
                    break;
                case 2:
                    mesa = new MesaComedor(articleName, price, selectMaterial());
                    ok = true;
                    break;
                case 3:
                    mesa = new MesaCafeCristal(articleName, price);
                    ok = true;
                    break;
                case 4:
                    mesa = new MesaCafeMadera(articleName, price);
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
}
