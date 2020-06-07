package menu;

import mueble.*;
import persona.*;

/**
 * Class MenuPrincipal is a wrapper for all management actions.
 * 
 * @author Juan Sebastian Flor Usma
 * @version 1.0.0
 */
public class MenuPrincipal extends Menu {

    /**
     * class constructor
     */
    public MenuPrincipal() {
        addInitialContent();
        init();
    }

    /**
     * initialize option selector
     */
    private void init() {
        boolean exit = false;
        do {
            System.out.println("Bienvenido! Seleccione opción:");
            System.out.println("Gestión muebles  (1)");
            System.out.println("Gestión personas (2)");
            System.out.println("Gestión pedidos  (3)");
            System.out.println("Salir            (4)");
            int optionSelected = readOption(4);
            switch (optionSelected){
                case 1:
                    printSeparator();
                    manageMuebles();
                    break;
                case 2:
                    printSeparator();
                    managePersonas();
                    break;
                case 3:
                    printSeparator();
                    managePedidos();
                    break;
                case 4:
                    printSeparator();
                    exit = true;
                    break;
            }
        } while (!exit);
    }

    /**
     * Muebles's management
     */
    private void manageMuebles(){
        new MenuMuebles();
    }

    /**
     * Personas' management
     */
    private void managePersonas(){
        new MenuPersonas();
    }

    /**
     * Pedido's management
     */
    private void managePedidos(){
        new MenuPedidos();
    }

    /**
     * initial test content
     */
    private void addInitialContent(){
        System.out.println("**********MESAS************");
        getDb().getMuebles().insertOneMueble(new MesaDormitorio("Mesita de noche", 12.0f, Material.MADERA));
        getDb().getMuebles().insertOneMueble(new MesaDormitorio("Mesita de noche cristal", 20.0f, Material.CRISTAL));
        getDb().getMuebles().insertOneMueble(new MesaComedor("Mesa comedor estandar", 54.0f, Material.CRISTAL));
        getDb().getMuebles().insertOneMueble(new MesaCafeMadera("Mesa cafe de madera estandar", 42.5f));
        getDb().getMuebles().insertOneMueble(new MesaCafeMadera("Mesa cafe de madera de pino", 72.5f));
        getDb().getMuebles().insertOneMueble(new MesaCafeCristal("Mesa cafe de cristal", 12.5f));
        System.out.println("**********SILLAS***********");
        getDb().getMuebles().insertOneMueble(new SillaCocina("Silla cocina madera estandar", 15.0f, Material.MADERA));
        getDb().getMuebles().insertOneMueble(new SillaCocina("Silla cocina metal estandar", 15.0f, Material.METAL));
        getDb().getMuebles().insertOneMueble(new SillaPlegable("Silla plegable", 5.0f, Material.MADERA));
        getDb().getMuebles().insertOneMueble(new SillaOficinaRuedas("Silla oficina acolchada", 35.0f, Material.METAL));
        getDb().getMuebles().insertOneMueble(new SillaOficinaSinRuedas("Silla oficina estatica", 25.0f, Material.METAL));
        System.out.println("**********EMPLEADOS********");
        getDb().getPersonas().insertOnePersona(new Jefe("Pepe", "5436383N"));
        getDb().getPersonas().insertOnePersona(new Comercial("Ramon", "56372817P"));
        getDb().getPersonas().insertOnePersona(new ArtesanoPlantilla("Jose", "02572817X"));
        getDb().getPersonas().insertOnePersona(new ArtesanoHora("Alberto", "X45363729"));
        System.out.println("**********CLIENTES*********");
        getDb().getPersonas().insertOnePersona(new Particular("Sebastian", "54361019J"));
        getDb().getPersonas().insertOnePersona(new Empresa("Carrefour S.A.", "B86759301"));
        System.out.println("***************************");
    }

}