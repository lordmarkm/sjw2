package org.sjw.data.model.maxs;

import java.util.List;
import java.util.Random;
import java.util.Set;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;


public class MenuItem {

    private String name;
    private Double price;

    public MenuItem(){}
    public MenuItem(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }

    private static Random rngsus = new Random();
    private static List<MenuItem> menuItems;
    static {
        MenuItem m1 = new MenuItem("Fried Chicken", 87d);
        MenuItem m2 = new MenuItem("Steak", 145.5d);
        MenuItem m3 = new MenuItem("Pancit Lucban", 125d);
        MenuItem m5 = new MenuItem("Lumpiang Shanghai", 50d);
        MenuItem m6 = new MenuItem("Cheese Cake", 45.5d);
        MenuItem m7 = new MenuItem("Fried Tilapia", 80d);
        MenuItem m8 = new MenuItem("1 Liter of Coke", 42d);
        MenuItem m9 = new MenuItem("Pitcher of Iced tea", 150d);
        MenuItem m10 = new MenuItem("Pitcher of Lemonade", 150d);
        MenuItem m11 = new MenuItem("Seafood Gumbo", 250d);
        MenuItem m12 = new MenuItem("Arroz Caldo", 50d);
        MenuItem m13 = new MenuItem("Ice cream", 50d);
        MenuItem m14 = new MenuItem("Club Sandwich", 120d);
        MenuItem m15 = new MenuItem("Tapsilog", 85d);
        MenuItem m16 = new MenuItem("Spicy Pork", 85d);
        MenuItem m17 = new MenuItem("Spaghetti Bolognese", 90d);
        MenuItem m18 = new MenuItem("Sinigang", 150d);
        MenuItem m19 = new MenuItem("Pork Barbecue", 200d);
        menuItems = Lists.newArrayList(m1, m2, m3, m5, m6, m7, m8, m9, m10, m11, m12, m13, m14, m15, m16, m17, m18, m19);
    }

    public static Set<MenuItem> random(int count) {
        if (count > menuItems.size()) {
            throw new IllegalArgumentException("We don't have enough dish variety!");
        }
        Set<MenuItem> items = Sets.newHashSet();
        while (items.size() < count) {
            items.add(menuItems.get(rngsus.nextInt(menuItems.size() - 1)));
        }
        return items;
    }

    public static MenuItem getRice() {
        MenuItem m4 = new MenuItem("Plain Rice", 40d);
        return m4;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((price == null) ? 0 : price.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        MenuItem other = (MenuItem) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (price == null) {
            if (other.price != null)
                return false;
        } else if (!price.equals(other.price))
            return false;
        return true;
    }
}
