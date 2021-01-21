package co.edu.cotecnova.facturacionelectronica.aplicacion.comando;

public class ComandoSaleProduct {
    private int saleProductId;
    private int productId;
    private int saleId;
    private int quantity;

    public ComandoSaleProduct() {
    }

    public ComandoSaleProduct(int saleProductId, int productId, int saleId, int quantity) {
        this.saleProductId = saleProductId;
        this.productId = productId;
        this.saleId = saleId;
        this.quantity = quantity;
    }

    public int getSaleProductId() {
        return saleProductId;
    }

    public void setSaleProductId(int saleProductId) {
        this.saleProductId = saleProductId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getSaleId() {
        return saleId;
    }

    public void setSaleId(int saleId) {
        this.saleId = saleId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
