public class Toy {
    private int quantity, likelihood;
    private String title;

    public Toy(String title, int quantity, int likelihood) {
        this.title = title;
        this.quantity = quantity;
        this.likelihood = likelihood;
    }

    @Override
    public String toString() {
        return "{\n\t\"Title\": \"" + title + "\",\n\t \"Quantity\": " + quantity + ",\n\t \"Likelihood\": " + likelihood + "\n\t}\r\n";
    }

    public String getTitle() {
        return title;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getLikelihood() {
        return likelihood;
    }

    public void setQuantity(int newValue) {
        if (newValue > 0) {
            quantity = newValue;
        } else {
            quantity = 1;
        }
    }

    public void setLikelihood(int newValue) {
        if (newValue < 0) {
            likelihood = 1;
        } else likelihood = Math.min(newValue, 100);
    }

    public void setTitle(String newValue) {
        if (!newValue.isEmpty()) {
            title = newValue;
        } else {
            title = "Untitled Item";
        }
    }
}
