package org.example.DesignPatterns.Observer;

import java.util.ArrayList;
import java.util.List;
import org.example.DesignPatterns.Observer.Subscriber;

public class YouTubeChannel {
    private  String  channelName;
    List<Subscriber> subscribers = new ArrayList<>();
    private  String latestVideo;
    YouTubeChannel(String channelName){
        this.channelName=channelName;
    }

    public  void SubscribeChannel(Subscriber subscriber){
        subscribers.add(subscriber);
    }
    public void unSubscribeChannel(Subscriber subscriber){
        subscribers.remove(subscriber);
    }
    void notifySubs(){
        for(Subscriber subscriber : subscribers){
            subscriber.update(channelName, latestVideo);
        }
    }
    void uploadVideo(String videoTitle){
        latestVideo=videoTitle;
        notifySubs();
    }

}
