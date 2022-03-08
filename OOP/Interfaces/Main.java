public class Main {
    public static void main(String[] args){

        // Runtime polymorphism - it's highly recommended making an instance variable
        // instantiated from a class that implements an interface to be of that interface
        // type, NOT of that class type
        Automobile honda = new Sedan("Honda", "Civic", 21000.0);
        System.out.println("Honda safety program: " + honda.safetyAssessmentProgram);

        Automobile toyota = new Sedan("Toyota", "Camry", 25000.0);
        System.out.println("Toyota safety program: " + toyota.safetyAssessmentProgram);

        // Member variables of an interface are "public static final" by default
        System.out.println("Automobile safety program: " + Automobile.safetyAssessmentProgram);
        System.out.println("Sedan safety program: " + Sedan.safetyAssessmentProgram);

    }
}
