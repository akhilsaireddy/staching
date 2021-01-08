package com.restfulwebservice.withunittest.restfulwebservicewithunittesting.controller;


public class Singleton extends Human{

    private static Singleton singleton = null;

    /* A private Constructor prevents any other
     * class from instantiating.
     */
     Singleton() { }

    /* Static 'instance' method */
//    public static Singleton getInstance( ) {
//        return singleton;
//    }

    /* Other methods protected by singleton-ness */

        protected static Singleton demoMethod1( ) {
        System.out.println("demoMethod for singleton");
        return singleton;
    }
        protected static Singleton demoMethod2( ) {
        System.out.println("demoMethod for singleton22");
        return singleton;
    }
}