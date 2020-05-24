package menu;

/**
 * Write a description of class Menu here.
 * 
 * @author Juan Sebastian Flor Usma
 * @version 1.0.0
 */
public class MenuPrincipal extends Menu {

    public MenuPrincipal() {
        init();
    }

    public void init() {
        boolean exit = false;
        do {
            System.out.println("Bienvenido! Seleccione opción:");
            System.out.println("Gestión muebles  (1)");
            System.out.println("Gestión personas (2)");
            System.out.println("Gestión pedidos  (3)");
            System.out.println("Búsqueda         (4)");
            System.out.println("Salir            (5)");
            int optionSelected = readOption(5);
            switch (optionSelected){
                case 1:
                    printSpaces(1);
                    manageMuebles();
                    break;
                case 2:
                    printSpaces(1);
                    managePersonas();
                    break;
                case 3:
                    printSpaces(1);
                    managePedidos();
                    break;
                case 4:
                    printSpaces(1);
                    search();
                    break;
                case 5:
                    printSpaces(1);
                    exit = true;
                    break;
            }
        } while (!exit);
    }

    public void manageMuebles(){
        new MenuMuebles();
    }

    public void managePersonas(){
        System.out.println("Gestión personas");
    }

    public void managePedidos(){
        System.out.println("Gestión pedidos");
    }

    public void search(){
        System.out.println("Gestión busqueda");
    }

}