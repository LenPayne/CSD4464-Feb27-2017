/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package feb27;

import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

/**
 *
 * @author c0587637
 */
@Named
@ApplicationScoped
public class ItemsController {

    private List<Item> items = new ArrayList<>();
    private Item currentItem = new Item();

    public Item getCurrentItem() {
        return currentItem;
    }

    public void setCurrentItem(Item currentItem) {
        this.currentItem = currentItem;
    }

    
    public List<Item> getItems() {
        return items;
    }

    public void add(Item i) {
        items.add(i);
        currentItem = new Item();
    }

    public Item getById(int id) {
        for (Item i : items) {
            if (i.getId() == id) {
                return i;
            }
        }
        return null;
    }

    public void set(int id, Item i) {
        Item oldOne = getById(id);
        if (oldOne != null) {
            oldOne.setDescription(i.getDescription());
            oldOne.setName(i.getName());
            oldOne.setQuantity(i.getQuantity());
        }
    }

    public void delete(int id) {
        Item oldOne = getById(id);
        items.remove(oldOne);
    }
}
