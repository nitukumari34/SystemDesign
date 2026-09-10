package org.example.DesignPatterns.Observer;

public class Main {
    public static void main(String[] args) {
        YouTubeChannel myChannel=new YouTubeChannel("CodeWithNitu");
        Subscriber subscriber1 = new Subscriber("Riya");
        Subscriber subscriber2 = new Subscriber("Siya");

        myChannel.unSubscribeChannel(subscriber1 );
        myChannel.SubscribeChannel(subscriber2);
        myChannel.uploadVideo("Java Multithreading");
        myChannel.unSubscribeChannel(subscriber1);
        myChannel.unSubscribeChannel(subscriber2);

    }
}
