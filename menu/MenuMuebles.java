package menu;

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
        boolean ok = false;
        do {
            System.out.println("Seleccione:");
            System.out.println("Mesa    (1)");
            System.out.println("Silla   (2)");
            int optionSelected = readOption(4);
            switch (optionSelected){
                case 1:
                    break;
                case 2:
                    break;
                default:
                    ok = true;
                    break;
            }
        } while (!ok);
    }

    void updateMueble(){
        System.out.println("update");
    }

    void deleteMueble(){
        System.out.println("del");
    }
    
}
