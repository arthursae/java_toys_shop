import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Shop {

    private Map<Integer, Toy> shopStock;
    private List<Integer> raffleItems;
    private int uid;
    private String output;

    public Shop() {
        this.shopStock = new HashMap<>();
        this.raffleItems = new ArrayList<>();
        this.uid = 1;
        this.output = "";
    }

    @Override
    public String toString() {
        output = "{\n";
        shopStock.forEach((key, value) -> {
            output += "\"" + key + "\": " + value;
        });
        output += "}";
        return output;
    }

    public Toy getSingleStockItem(int id) {
        return shopStock.get(id);
    }

    public Map<Integer, Toy> getAllStockItems() {
        return shopStock;
    }

    public void addNewStock(Toy newItem) {
        shopStock.put(getUniqueID(), newItem);
    }

    public int getUniqueID() {
        while (shopStock.containsKey(uid)) {
            uid++;
        }
        return uid;
    }

    public boolean raffleDraw() {
        if (!shopStock.isEmpty()) {
            double rand = new Random().nextDouble() * 100;
            int r = (int) rand;
            System.out.println("Выбран вес: " + r);
            for (Map.Entry<Integer, Toy> entry : shopStock.entrySet()) {
                int id = entry.getKey();
                Toy toy = entry.getValue();
                if (toy.getLikelihood() <= r && toy.getQuantity() > 0) {
                    raffleItems.add(id);
                    return true;
                }
            }
        }
        return false;
    }

    public void processAwardItem() {
        if (!raffleItems.isEmpty()) {
            int awardID = raffleItems.get(0);
            raffleItems.remove(0);
            Toy awardToy = shopStock.get(awardID);
            int qty = awardToy.getQuantity();
            if (qty > 0) {
                awardToy.setQuantity(qty - 1);
                String data = "{\n\t\"" + String.valueOf(awardID) + "\":" + awardToy.toString() + "}";
                writeDataToFile(data);
            } else {
                System.err.println("Игрушки этой категории закончились!");
            }
        } else {
            System.err.println("Список призовых ингрушек пуст!");
        }
    }

    private void writeDataToFile(String data) {
        try {
            FileWriter fw = new FileWriter("awardedToys.txt");
            fw.write(data);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Ошибка записи в файл!");
        }
    }
}
