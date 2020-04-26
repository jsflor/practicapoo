package db;

/**
 * Write a description of class Database here.
 *
 * @author Juan Sebastian Flor Usma
 * @version 1.0.0
 */
public class Database {

    private MueblesCollection muebles;
    private PersonasCollection personas;
    private PedidosCollection pedidos;

    public Database() {
        muebles = new MueblesCollection();
        personas = new PersonasCollection();
        pedidos = new PedidosCollection();
    }

    public MueblesCollection getMuebles() {
        return muebles;
    }

    public void setMuebles(MueblesCollection muebles) {
        this.muebles = muebles;
    }

    public PersonasCollection getPersonas() {
        return personas;
    }

    public void setPersonas(PersonasCollection personas) {
        this.personas = personas;
    }

    public PedidosCollection getPedidos() {
        return pedidos;
    }

    public void setPedidos(PedidosCollection pedidos) {
        this.pedidos = pedidos;
    }
}