package com.intive.trainings.java8.functionalIntf.examples;

public class FunctionalInterfacesExample {

    @FunctionalInterface
    interface Function {
        String filter (String input);
    }

    @FunctionalInterface
    interface BiFunction {
        String filter (String input, String reqxp);
        boolean equals(Object obj);
    }

    @FunctionalInterface
    interface BiFunctionExtended extends BiFunction {
        String filter (String input, String reqxp);
    }

    @FunctionalInterface
    interface Consumer {
        void store (String data);
    }

    @FunctionalInterface
    interface ThreeConsumer {
        void store (String data, int i, boolean cond);
    }

    @FunctionalInterface
    interface Supplier {
        String fetch ();
    }

    @FunctionalInterface
    interface  ParameterizedSupplierIsOk<T> {
        T fetch ();
    }

    @FunctionalInterface
    interface ToManyAbstractMethods {
        String first (String input);
        String second (String input);
    }

    @FunctionalInterface
    interface ToManyAbstractMethods22 extends Function {
        String first (String input);
    }

    @FunctionalInterface
    abstract class NotAnInterface {
        abstract String method(String param);
    }

    @FunctionalInterface
    class NotAnInterface {
        String method(String param) {
            return null;
        }
    }

    //

    interface AbleToBeUsedButNotSafe {
        String method(String param);
    }

    /*
        CWICZENIE:

        1. Zdefiniuj interface funkcyjny
        2. Napisz klika przykładów użycia, dostarczając za każdym razem innej funkcji

     */
}
