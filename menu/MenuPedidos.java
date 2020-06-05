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
                    try{
                        addPedido();
                    } catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    printSeparator();
                    exit = true;
                    break;
            }
        } while (!exit);
    }

    void addPedido() throws Exception{
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

    private int checkEmployeeId() throws Exception{
        String employeeId;
        Persona result = null;
        boolean ok;
        do {
            employeeId = readText("Indique id del responsable (para salir 'exit')");
            if(employeeId.equals("exit")){
                throw new Exception("Operacion abortada");
            }
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

    private int checkCustomerId() throws Exception {
        String customerId;
        Persona result = null;
        boolean ok;
        do {
            customerId = readText("Indique id del responsable");
            if(customerId.equals("exit")){
                throw new Exception("Operacion abortada");
            }
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