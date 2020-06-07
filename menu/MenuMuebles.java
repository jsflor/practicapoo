package menu;

import mueble.*;

/**
 * Class MenuMuebles contains Mueble's management actions.
 *
 * @author Juan Sebastian Flor Usma
 * @version 1.0.0
 */
public class MenuMuebles extends Menu {

    /**
     * class constructor
     */
    public MenuMuebles(){
        init();
    }

    /**
     * initialize option selector
     */
    private void init(){
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
                    break;
                case 4:
                    printSeparator();
                    exit = true;
                    break;
            }
        } while (!exit);
    }

    /**
     * search Mueble action
     */
    private void searchMueble() {
        Mueble m = null;
        try {
            m  = getMueble();
            printSeparator();
            m.printData();
            printSeparator();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * add Mueble action
     */
    private void addMueble(){
        boolean ok;
        Mueble m = null;
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
                    ok = false;
                    break;
            }
        } while (!ok);

        m.printData();
        getDb().getMuebles().insertOneMueble(m);
        printSeparator();
    }

    /**
     * update Mueble action
     */
    private void updateMueble(){
        Mueble m = null;
        try {
            m  = getMueble();

            printSeparator();
            System.out.println("Estado actual mueble seleccionado");
            m.printData();
            printSeparator();

            String articleName = readText("Introduzca nombre de articulo");
            float price = readPrice();

            m.setModelName(articleName);
            m.setPrice(price);

            printSeparator();
            System.out.println("Mueble actualizado");
            m.printData();
            printSeparator();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * @return  new Mueble created (Mesa)
     */
    private  Mueble displayMesaOpts() {
        boolean ok;
        Mueble mesa = null;
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
                    ok = false;
                    break;
            }
        } while (!ok);
        return mesa;
    }

    /**
     * @return new Mueble created (Silla)
     */
    private Mueble displaySillaOpts() {
        boolean ok;
        Mueble silla = null;
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
                    ok = false;
                    break;
            }
        } while (!ok);
        return silla;
    }
}
