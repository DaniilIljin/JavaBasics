package generics.cart;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart<T extends CartItem> {
    private ArrayList<CartEntry> insideCart = new ArrayList<>();
    private Double allDiscounts = 1d;
    private Double lastDiscount = null;


    public void add(T item) {
        if (item != null) {
            if (findItemInList(item.getId()) != null){
                findItemInList(item.getId()).increaseQuantity();
            } else {
                insideCart.add(new CartEntry(item));
            }
        }
    }

    public CartEntry findItemInList(String id){
        for (CartEntry cartEntry : insideCart){
            if (cartEntry.getId().equals(id)){
                return cartEntry;
            }
        }
        return null;
    }


    public void removeById(String id){
        if(findItemInList(id) != null){
            insideCart.remove(findItemInList(id));
        }
    }

    public Double getTotal() {
        Double sum = 0d;
        for (CartEntry cartEntry : insideCart) {
            sum += cartEntry.getTotalPrice();
        }
        return sum * allDiscounts;
    }

    public void increaseQuantity(String id) {
        if(findItemInList(id) != null){
            findItemInList(id).increaseQuantity();
        }
    }

    public void applyDiscountPercentage(Double discount) {
        allDiscounts *= 1 - discount / 100;
        lastDiscount = 1 - discount / 100;
    }

    public void removeLastDiscount() {
        allDiscounts = allDiscounts / lastDiscount;
    }

    public void addAll(List<T> items) {
        if (items != null) {
            for (T item : items) {
                add(item);
            }
        }
    }


    @Override
    public String toString(){
        StringBuilder full = new StringBuilder("");
        for (int i = 0; i < insideCart.size() - 1; i++) {
            full.append(insideCart.get(i).toString()).append(", ");
        }
        full.append(insideCart.get(insideCart.size() - 1));
        return full.toString();
    }
}
