package mueble;


/**
 * Write a description of class Mueble here.
 * 
 * @author Juan Sebastian Flor Usma
 * @version 1.0.0
 */
public abstract class Mueble{
    private final int id;
    private final Material material;
    private String articleName;
    private int price;
    private boolean order;
    private int pedidoId;
    private static int count = 0;

    protected Mueble(String articleName, int price, Material material) {
        this.articleName = articleName;
        this.price = price;
        this.material = material;
        this.order = false;
        this.id = count;
        count ++;
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

    public boolean belongsToOrder() {
        return order;
    }

    public void setBelongsToOrder(boolean order) {
        this.order = order;
    }

    public int getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(int pedidoId) {
        this.pedidoId = pedidoId;
    }

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    public Material getMaterial() {
        return material;
    }
}
