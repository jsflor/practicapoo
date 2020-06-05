package menu;

import mueble.Mueble;
import pedido.Pedido;
import persona.*;

import java.util.ArrayList;
import java.util.List;

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

    void init() {
        boolean exit = false;
        do {
            System.out.println("Gestión pedidos. Seleccione opción:");
            System.out.println("Nuevo pedido     (1)");
            System.out.println("Salir            (2)");
            int optionSelected = readOption(2);
            switch (optionSelected) {
                case 1:
                    printSeparator();
                    addPedido();
                    break;
                case 2:
                    printSeparator();
                    exit = true;
                    break;
            }
        } while (!exit);
    }

    void addPedido(){
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
        muebles.forEach(m -> m.setOrderId(p.getId()));
    }

    private int checkEmployeeId() {
        String employeeId;
        List<Persona> result;
        do {
            employeeId = readText("Indique id del responsable");
            result  = getDb().getPersonas().getPersonaById("EMPLEADO", employeeId);
        } while (!(result.size() > 0));
        return result.get(0).getId();
    }

    private int checkCustomerId() {
        String customerId;
        List<Persona> result;
        do {
            customerId = readText("Indique id del responsable");
            result  = getDb().getPersonas().getPersonaById("CLIENTE", customerId);
        } while (!(result.size() > 0));
        return result.get(0).getId();
    }

}