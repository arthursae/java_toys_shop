public class Main {

    public static void main(String[] args) {
        Shop toyShop = new Shop();
        Toy toyItem1 = new Toy("Some Toy 1", 10, 67);
        Toy toyItem2 = new Toy("Some Toy 2", 20, 78);
        Toy toyItem3 = new Toy("Some Toy 3", 30, 89);
        Toy toyItem4 = new Toy("Some Toy 4", 40, 34);
        toyShop.addNewStock(toyItem1);
        toyShop.addNewStock(toyItem2);
        toyShop.addNewStock(toyItem3);
        toyShop.addNewStock(toyItem4);
        toyItem1.setLikelihood(56);
        System.out.print(toyShop);
        if (toyShop.raffleDraw()) {
            toyShop.processAwardItem();
        } else {
            System.err.println("Призовой игрушки нет!");
        }
    }
}
