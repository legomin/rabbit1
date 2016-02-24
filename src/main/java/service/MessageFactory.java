package service;

import model.Message;
import model.Users;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Виталий on 05.01.2016.
 */

@Service
public class MessageFactory {
    private static Map<Users, List<Message>> messageMap = new HashMap<Users, List<Message>>();

    public List<Message> getMessageMap(Users user) {
        return messageMap.get(user);
    }

    public MessageFactory() {
    }

    public void addMessage(Message message){
        if (messageMap.containsKey(message.getUser()))
            messageMap.get(message.getUser()).add(message);
        else{
            List<Message> list = new ArrayList<Message>();
            list.add(message);
            messageMap.put(message.getUser(),list);
        }

    }
}
