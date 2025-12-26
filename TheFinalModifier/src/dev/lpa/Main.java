package dev.lpa;

import consumer.specific.ChildClass;
import dev.lpa.generic.BaseClass;

public class Main {

    public static void main(String[] args) {

        BaseClass parent = new BaseClass();
        ChildClass child = new ChildClass();
        BaseClass childReferredToAsBase = new ChildClass();

        parent.recommendedMethod();
        System.out.println("-".repeat(60));
        childReferredToAsBase.recommendedMethod();
        System.out.println("-".repeat(60));
        child.recommendedMethod();

        System.out.println("\n" + "-".repeat(120));

        parent.recommendedStatic();
        System.out.println("-".repeat(60));
        childReferredToAsBase.recommendedStatic();
        System.out.println("-".repeat(60));
        child.recommendedStatic();


        // When you execute a static method on an instance,
        // the reference type determines which method is called.
        // reference type is the left term -> (BaseClass parent)

        // On the other hand,
        // Instance methods are called based on the runtime type of the instance,
        // and not the declared type.
        // runtime type is the right term -> (... = new ChildClass())

        System.out.println("-".repeat(60));
        BaseClass.recommendedStatic();
        ChildClass.recommendedStatic();

        System.out.println("-".repeat(60));
        String xArgument = "xArgument ";
        StringBuilder zArgument = new StringBuilder("zArgument");

        doXYZ(xArgument, 16, zArgument);

        System.out.println("After method, xArgument = " + xArgument);
        System.out.println("After method, zArgument = " + zArgument);


    }

    private static void doXYZ(String x, int y, final StringBuilder z){

        final String c = x + y;
        System.out.println("c = " + c);
        z.append(y);
    }
}
