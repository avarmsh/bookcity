package inventory;
import products.Product;

import java.util.ArrayList;

public class Inventory<T extends Product> {
    private ArrayList<T> items = new ArrayList<>();

    public ArrayList<T> getItems() {
        return items;
    }

    public void setItems(ArrayList<T> items) {
        this.items = items;
    }

    public void applyDiscount(String productName, int discount) {
        for(T item : items){
            if(item.getTitle().equals(productName)){
                double newPrice = item.getPrice() * (1 - discount / 100.0);
                item.setPrice(newPrice);
            }
        }
    }

    public void addItems(T product) {
        items.add(product);
    }

    public void removeItemsById(String id) {
        for(int i = 0; i < items.size(); i++){
            if(items.get(i).getId().equals(id)){
                items.remove(i);
                break;
            }
        }
    }

    public T findItemsById(int id) {
        for(T item : items){
            if(Integer.parseInt(item.getId()) == id){
                return item;
            }
        }
        System.out.println("Item not found");
        return null;
    }

    public void displayAll() {
        for(T item : items){
            System.out.println(item);
        }
    }
}

