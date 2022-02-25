public class SmartSpeaker {
    private String productName = "unknown";

    public SmartSpeaker(String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }

    public void wakePhrase() {
        System.out.format("Activates on saying %s's wake phrase.\n", productName);
    }
}
