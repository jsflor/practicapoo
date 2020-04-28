package db;

import pedido.Pedido;

import java.util.ArrayList;
import java.util.List;

/**
 * Write a description of class PedidosCollection here.
 *
 * @author Juan Sebastian Flor Usma
 * @version 1.0.0
 */
public class PedidosCollection implements PedidosOperations {

    private List<Pedido> pedidos;

    public PedidosCollection() {
        pedidos = new ArrayList<>();
    }

    @Override
    public List<Pedido> getAllPedidos(String filter) {
        return getPedidos();
    }

    @Override
    public Pedido getPedidoById(String id) {
        List<Pedido> result = new ArrayList<>();
        for (Pedido p: getPedidos()){
            if(id.equals(Integer.toString(p.getId()))){
                result.add(p);
            }
        }
        return result.size() > 0 ? result.get(0) : null;
    }

    @Override
    public void insertOnePedido(Pedido p) {
        getPedidos().add(p);
        System.out.println("Añadido nuevo pedido con id: " + p.getId());
    }

    @Override
    public void updateOnePedido(Pedido p) {
        getPedidos().removeIf(pe -> pe.getId() == p.getId());
        getPedidos().add(p);
        System.out.println("Actualizado pedido con id: " + p.getId());
    }

    @Override
    public void deleteOnePedido(String id) {
        getPedidos().removeIf(p -> id.equals(Integer.toString(p.getId())));
        System.out.println("Borrado pedido con id: " + id);
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
}
