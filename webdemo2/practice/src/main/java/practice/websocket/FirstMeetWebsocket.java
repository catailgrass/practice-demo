package practice.websocket;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

@ServerEndpoint("/hello")
public class FirstMeetWebsocket {

    @OnMessage
    public String onMessage(String msg) {
        System.out.println("received: " + msg);
        return msg;
    }

    @OnOpen
    public void onOpen(Session session) {
        System.out.println("websocket opened : " + session.getId());
    }

    @OnClose
    public void onClose(CloseReason reason) {
        System.out.println("websocket closed due to :" + reason.getReasonPhrase());
    }
}
