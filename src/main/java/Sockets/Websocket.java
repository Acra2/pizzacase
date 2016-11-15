package Sockets;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

/**
 * Created by Sander on 15-11-2016.
 */
@ServerEndpoint("/socket")
public class Websocket {

    @OnOpen
    public  void open(Session session){
        System.out.println("Socket open");
    }
    @OnClose
    public  void close(Session session){

    }
    @OnError
    public  void onerror(Throwable error){

    }
    @OnMessage
    public  void handlemessage(String message, Session session){
        session.getAsyncRemote().sendText(message);
    }
}
