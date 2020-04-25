package pedido;


import java.util.ArrayList;

/**
 * Write a description of class Pedido here.
 *
 * @author Juan Sebastian Flor Usma
 * @version 1.0.0
 */
public class Pedido {

    private final int id;
    private int price;
    private final ArrayList<Integer> muebles;
    private int customerId;
    private int responsibleId;
    private OrderState estadoPedido;
    private ArrayList<String> incidencias;
    private static int count = 0;

    public Pedido(ArrayList<Integer> muebles, int customerId, int responsibleId, int price) {
        this.muebles = muebles;
        this.customerId = customerId;
        this.responsibleId = responsibleId;
        this.price = price;
        this.estadoPedido = OrderState.PENDIENTE;
        this.id = count;
        count++;
    }

    public int getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public ArrayList<Integer> getMuebles() {
        return muebles;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getResponsibleId() {
        return responsibleId;
    }

    public void setResponsibleId(int responsibleId) {
        this.responsibleId = responsibleId;
    }

    public ArrayList<String> getIncidencias() {
        return incidencias;
    }

    public void setIncidencias(ArrayList<String> incidencias) {
        this.incidencias = incidencias;
    }

    public OrderState getEstadoPedido() {
        return estadoPedido;
    }

    public void setEstadoPedido(OrderState estadoPedido) {
        this.estadoPedido = estadoPedido;
    }
}