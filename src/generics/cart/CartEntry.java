package generics.cart;

public class CartEntry {
    private final String id;
    private final Double price;
    private Integer quantity;
    public CartEntry(CartItem item){
        id = item.getId();
        price = item.getPrice();
        quantity = 1;
    }
    public String getId(){
        return id;
    }
    public Double getTotalPrice(){
        return price * quantity;
    }
    public void increaseQuantity(){
        quantity++;
    }

    @Override
    public String toString(){
        return "(" + id + ", " + price + ", " + quantity + ")";
    }
}
