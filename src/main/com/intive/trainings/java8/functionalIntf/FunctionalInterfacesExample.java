package com.intive.trainings.java8.functionalIntf;

public class FunctionalInterfacesExample {

    @FunctionalInterface
    interface Function {
        String filter (String input);

        default String toUpperCase(String input) {
            return input.toUpperCase();
        }
    }

    @FunctionalInterface
    interface BiFunction {
        String filter (String input, String reqxp);
        boolean equals(Object obj);
    }

    static class SampleImpl implements BiFunction {

        @Override
        public String filter(String input, String reqxp) {
            return null;
        }

        public static void main(String[] args) {
            new SampleImpl().equals(null);
        }
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

    /*
    * NOT a functional interface!
    * */
//    @FunctionalInterface
    interface ToManyAbstractMethods {
        String first (String input);
        String second (String input);
    }

    /*
     * NOT a functional interface!
     * */
    //@FunctionalInterface
    interface ToManyAbstractMethods22 extends Function {
        String first (String input);
    }

    /*
     * NOT a functional interface!
     * */
    //@FunctionalInterface
    abstract class NotAnInterface {
        abstract String method(String param);
    }

    /*
     * NOT a functional interface!
     * */
    //@FunctionalInterface
    class NotAnInterface2 {
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
