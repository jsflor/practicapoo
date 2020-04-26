package db;

import pedido.Pedido;
import java.util.List;

/**
 * Write a description of interface PedidosOperations here.
 *
 * @author Juan Sebastian Flor Usma
 * @version 1.0.0
 */

public interface PedidosOperations {

    List<Pedido> getAllPedidos(String filter);
    Pedido getPedidoById(String id);
    void insertOnePedido(Pedido p);
    void updateOnePedido(Pedido p);
    void deleteOnePedido(String id);

}
