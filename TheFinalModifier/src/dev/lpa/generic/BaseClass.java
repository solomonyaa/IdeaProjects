package dev.lpa.generic;

public class BaseClass {

    public final void recommendedMethod(){

        System.out.println(this.getClass().getSimpleName());
        System.out.println("[BaseClass.recommendedMethod]: Best way to do it");
        optionalMethod();
        mandatoryMethod();
    }

    protected void optionalMethod() {

        System.out.println("[BaseClass.optionalMethod]: Optional method");
    }

    private void mandatoryMethod() {

        System.out.println("[BaseClass.optionalMethod]: Mandatory method (Non-negotiable!)");
    }

    public static void recommendedStatic(){

        System.out.println("BaseClass.recommendedStatic]: Best way to do it");
        optionalStatic();
        mandatoryStatic();
    }

    protected static void optionalStatic() {

        System.out.println("BaseClass.optionalStatic]: Optional");
    }
    private static void mandatoryStatic() {

        System.out.println("BaseClass.mandatoryStatic]: MANDATORY");
    }
}
