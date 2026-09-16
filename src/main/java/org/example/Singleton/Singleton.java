package org.example.Singleton;

//eager and synchronized
//public class Singleton {
//    private final   static Singleton instance=new Singleton();
//
//    Singleton(){};
//    public  static Singleton getInstance(){
//
//        return  instance;
//    }
//}

//lazy but not thread safe
//public class Singleton {
//    private  static Singleton instance;
//
//    Singleton(){};
//    public  static Singleton getInstance(){
//        if(instance==null){
//            instance=new Singleton();
//
//        }
//        return  instance;
//    }
//}

public class Singleton {

    private static Singleton instance;

    private Singleton() {
    }

    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}

