public class BasicGenericsImplementation {
    public static void main(String[] args) {

        Repository<Integer> intRepo = new Repository<>();
        intRepo.value = 14;
        System.out.println("Integer: " + intRepo.value);

        Repository<Double> doubleRepo = new Repository<>();
        doubleRepo.value = 14.5;
        System.out.println("Double: " + doubleRepo.value);

        Repository<String> strRepo = new Repository<>();
        strRepo.value = "Hello Generics";
        System.out.println("Double: " + strRepo.getValue());
    }


}
