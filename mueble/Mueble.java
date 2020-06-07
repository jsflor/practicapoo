package mueble;


/**
 * Abstract class Mueble here.
 * 
 * @author Juan Sebastian Flor Usma
 * @version 1.0.0
 */
public abstract class Mueble{

    private final Material material;
    private String modelName;
    private float price;
    private boolean order;
    private int orderId;

    /**
     * @param modelName of Mueble
     * @param price of Mueble
     * @param material of Mueble
     */
    protected Mueble(String modelName, float price, Material material) {
        this.modelName = modelName;
        this.price = price;
        this.material = material;
        this.order = false;
    }

    /**
     * print Mueble data details
     */
    public abstract void printData();

    /**
     * @return Mueble id
     */
    public abstract int getId();

    /**
     * print Mueble features
     */
    public void printFeatures(){
        System.out.println("Modelo : " + getModelName());
        System.out.println("Precio : " + getPrice());
        printMaterial();
        if(belongsToOrder()){
            System.out.println("Orden id : " + getOrderId());
        }
    }

    /**
     * print Mueble material
     */
    public void printMaterial(){
        switch (getMaterial()){
            case CRISTAL:
                System.out.println("Material: Cristal");
                break;
            case MADERA:
                System.out.println("Material: Madera");
                break;
            case PLASTICO:
                System.out.println("Material: Plastico");
                break;
            case METAL:
                System.out.println("Material: Metal");
                break;
        }
    }

    /**
     * @return price
     */
    public float getPrice() {
        return price;
    }

    /**
     * @param price to set
     */
    public void setPrice(float price) {
        this.price = price;
    }

    /**
     * @return if belongs to order
     */
    public boolean belongsToOrder() {
        return order;
    }

    /**
     * @param order to set
     */
    public void setBelongsToOrder(boolean order) {
        this.order = order;
    }

    /**
     * @return order id
     */
    public int getOrderId() {
        return orderId;
    }

    /**
     * @param orderId to set
     */
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    /**
     * @return model name
     */
    public String getModelName() {
        return modelName;
    }

    /**
     * @param modelName to set
     */
    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    /**
     * @return material
     */
    public Material getMaterial() {
        return material;
    }
}
