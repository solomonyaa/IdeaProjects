package consumer.specific;

import dev.lpa.generic.BaseClass;

// ChildClass is a BaseClass
public class ChildClass extends BaseClass {

    @Override
    protected void optionalMethod() {

        System.out.println("Child.optionalMethod]: Extra stuff here");
        super.optionalMethod();
    }

/*    @Override
    public void recommendedMethod() {

        System.out.println("[Child.recommendedMethod]: I'll do things my own way");
        optionalMethod();
    }*/

    public static void recommendedStatic(){

        System.out.println("Child.recommendedStatic]: Best way to do it");
        optionalStatic();
        // this calls the method of the BaseClass because
        // ChildClass is a BaseClass
    }
}
