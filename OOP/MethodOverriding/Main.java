public class Main {
    public static void main(String[] args) {

        //ResidentialProperty residential1 = new ResidentialProperty(
        Property residential1 = new ResidentialProperty(  // Dynamic method dispatch -- runtime polymorphism
                "Residential Property 1",
                1200,
                ResidentialProperty.Type.TOWNHOME,
                4000
        );

        //ResidentialProperty residential2 = new ResidentialProperty(
        Property residential2 = new ResidentialProperty(
                "Residential Property 2",
                900,
                ResidentialProperty.Type.CONDO,
                3000
        );

        System.out.println(residential1);
        System.out.println(residential2);

        System.out.println();

        //CommercialProperty commercial1 = new CommercialProperty(
        Property commercial1 = new CommercialProperty(
                "Commercial Property 1",
                3000,
                CommercialProperty.Type.OFFICE,
                7000
        );

        //CommercialProperty commercial2 = new CommercialProperty(
        Property commercial2 = new CommercialProperty(
                "Commercial Property 2",
                10000,
                CommercialProperty.Type.RETAIL,
                15000
        );

        System.out.println(commercial1);
        System.out.println(commercial2);

        System.out.println();

        Property property1 = new Property("Plot", "Property 1", 1600);
        System.out.println(property1);

        System.out.println();
    }
}
