package db;

import pedido.Pedido;

import java.util.ArrayList;
import java.util.List;

/**
 * Class PedidosCollection with implementation of Pedidos operations.
 *
 * @author Juan Sebastian Flor Usma
 * @version 1.0.0
 */
public class PedidosCollection implements PedidosOperations {

    private List<Pedido> pedidos;

    /**
     * class constructor
     */
    public PedidosCollection() {
        pedidos = new ArrayList<>();
    }

    @Override
    public Pedido getPedidoById(String id) throws Exception {
        List<Pedido> result = new ArrayList<>();
        for (Pedido p: getPedidos()){
            if(id.equals(Integer.toString(p.getId()))){
                result.add(p);
            }
        }
        if(result.size() > 0){
            return result.get(0);
        } else {
            throw new Exception("Pedido no encontrado");
        }
    }

    @Override
    public void insertOnePedido(Pedido p) {
        getPedidos().add(p);
        System.out.println("Añadido nuevo pedido con id: " + p.getId());
    }

    /**
     * @return pedidos
     */
    public List<Pedido> getPedidos() {
        return pedidos;
    }

    /**
     * @param pedidos to set
     */
    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
}
