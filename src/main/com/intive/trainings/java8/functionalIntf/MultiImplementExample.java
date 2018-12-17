package com.intive.trainings.java8.functionalIntf;

public class MultiImplementExample {

    interface A {
        void methodA();

        default int count(String str) {
            return str.length();
        }
    }

//    @FunctionalInterface
    interface B extends A {
        void methodB();

        default int count(String str, String str2) {
            return str.length() + str.length();
        }
    }

    static class C implements A, B {
        @Override
        public void methodA() {
        }

        @Override
        public void methodB() {
        }
    }

    public static void main(String[] args) {
        C c = new C();
        System.out.println(c.count("ala ma kota"));
        System.out.println(c.count("ala ma kota"));
    }
}
