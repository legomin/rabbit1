package service;

import model.Events;
import model.MessageFilter;
import model.Users;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Виталий on 07.01.2016.
 */
@Service
public class MessageFilterService {
    public boolean isInList(String user, List<MessageFilter> list){
        return false;
    }

    public MessageFilter getFilter(Users user, List<MessageFilter> list){
        for (MessageFilter filter : list){
            if (filter.getUser()==user && filter.getEvent() == Events.userEntry)
                return filter;
        }
        return null;
    }

    public MessageFilter getFilter(Users user, Events event, List<MessageFilter> list){
        for (MessageFilter filter : list){
            if (filter.getUser()==user && filter.getEvent() == event)
                return filter;
        }
        return null;
    }

    public MessageFilterService() {
    }
}
