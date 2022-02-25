public class Main {
    public static void main(String[] args) {

        SmartSpeaker smartSpeaker = new SmartSpeaker("Google Nest");
        SmartSpeaker amazonEcho = new AmazonEcho(); // Holding type of Parent Class but instantiated with child class
        SmartSpeaker appleHomePod = new AppleHomePod(); // Holding type of Parent Class but instantiated with child class

        // Invoking methods overriding - Java decides at the runtime to invoke
        // which method (from base class or derived class)
        smartSpeaker.wakePhrase();
        appleHomePod.wakePhrase();
        amazonEcho.wakePhrase();

        System.out.println();

        // Invoking method of parent class
        System.out.println("smartSpeaker name: " + smartSpeaker.getProductName());
        System.out.println("appleHomePod name: " + appleHomePod.getProductName());
        System.out.println("amazonEcho name: " + amazonEcho.getProductName());

        System.out.println();


    }
}
