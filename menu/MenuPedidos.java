package menu;

import mueble.Mueble;
import pedido.Pedido;
import persona.*;

import java.util.ArrayList;

/**
 * Write a description of class MenuPedidos here.
 *
 * @author Juan Sebastian Flor Usma
 * @version 1.0.0
 */
public class MenuPedidos extends Menu {

    public MenuPedidos() {
        init();
    }

    private void init() {
        boolean exit = false;
        do {
            System.out.println("Gestión pedidos. Seleccione opción:");
            System.out.println("Nuevo pedido     (1)");
            System.out.println("Buscar pedido    (2)");
            System.out.println("Salir            (3)");
            int optionSelected = readOption(3);
            switch (optionSelected) {
                case 1:
                    printSeparator();
                    addPedido();
                    break;
                case 2:
                    printSeparator();
                    searchPedido();
                    break;
                case 3:
                    printSeparator();
                    exit = true;
                    break;
            }
        } while (!exit);
    }

    private void searchPedido() {
        boolean ok;
        do {
            try{
                String id = readText("Indique id pedido: ");
                Pedido p = getDb().getPedidos().getPedidoById(id);
                printSeparator();
                p.printPedido();
                printSeparator();
                ok = true;
            } catch (Exception e){
                System.out.println(e.getMessage());
                ok = false;
            }
        } while (!ok);
    }

    private void addPedido(){
        int qty;
        int customerId;
        int employeeId;
        float price = 0.0f;
        ArrayList<Mueble> muebles = new ArrayList<>();
        do {
            qty = Integer.parseInt(readText("Indique cantidad de muebles en el pedido"));
        } while (!(qty > 0));

        for (int i = 1; i <= qty; i++){
            System.out.println("Mueble #" + i);
            boolean ok;
            do {
                try{
                    Mueble m;
                    m = getMueble();
                    muebles.add(m);
                    price += m.getPrice();
                    ok = true;
                } catch (Exception e){
                    System.out.println(e.getMessage());
                    ok = false;
                }
            } while (!ok);
        }

        customerId = checkCustomerId();
        employeeId = checkEmployeeId();

        Pedido p = new Pedido(muebles, customerId, employeeId, price);
        getDb().getPedidos().insertOnePedido(p);
        muebles.forEach(m -> {
            m.setOrderId(p.getId());
            m.setBelongsToOrder(true);
        });
        printSeparator();
        p.printPedido();
        printSeparator();
    }

    private int checkEmployeeId(){
        String employeeId;
        Persona result = null;
        boolean ok;
        do {
            employeeId = readText("Indique id del responsable");
            try {
                result  = getDb().getPersonas().getPersonaById("EMPLEADO", employeeId);
                ok = true;
            } catch (Exception e) {
               System.out.println(e.getMessage());
                ok = false;
            }
        } while (!ok);
        return result.getId();
    }

    private int checkCustomerId() {
        String customerId;
        Persona result = null;
        boolean ok;
        do {
            customerId = readText("Indique id del cliente");
            try {
                result  = getDb().getPersonas().getPersonaById("CLIENTE", customerId);
                ok = true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                ok = false;
            }
        } while (!ok);
        return result.getId();
    }

}