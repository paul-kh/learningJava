public interface Automobile {

    // NOTE: All methods in an interface are public and abstract by default
    // we can omit the public modifier for interfaces. If we try to specify
    // modifiers other than public it will show error
    String safetyAssessmentProgram = "Global NCAP";

    String getMake();

    String getModel();

    Double getPrice();
}
