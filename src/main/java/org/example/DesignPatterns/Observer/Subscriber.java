package org.example.DesignPatterns.Observer;

public class Subscriber {
    private String subscriberName;

    Subscriber(String subscriberName){
        this.subscriberName = subscriberName;
    }

    public void update(String channelName, String videoTitle){
        System.out.println(
                "new video " + videoTitle +
                        " has been uploaded on " + channelName
        );
    }
}