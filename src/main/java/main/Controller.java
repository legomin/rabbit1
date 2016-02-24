package main;

/**
 * Created by Виталий on 29.12.2015.
 */

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Events;
import model.Message;
import model.MessageFilter;
import model.Users;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import service.MessageFactory;
import service.MessageFilterService;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    AmqpTemplate template;
    List<MessageFilter> filters;
    ObjectMapper mapper = new ObjectMapper();
    MessageFilterService service = new MessageFilterService();
    MessageFactory factory = new MessageFactory();


    @RequestMapping("/sendMessage")
    List queue1(@RequestParam(value = "user", required = true) int user, @RequestParam(value = "action", required = false) String action) throws JsonProcessingException {

        MessageFilter activeFilter;
        Events currentEvent;
        if (action == null) {
            activeFilter = service.getFilter(Users.valueOf("user" + user), filters);
            currentEvent = Events.userEntry;
        }
        else {
            currentEvent = Events.pushButton;
            activeFilter = service.getFilter(Users.valueOf("user" + user), Events.valueOf(action), filters);
            if (activeFilter != null){
                template.convertAndSend("queue1",mapper.writeValueAsString(new Message(activeFilter.getUser() , "user"+user +" "+currentEvent.toString() ,activeFilter.getAlert())));
            }

            currentEvent = Events.valueOf(action);
            activeFilter = service.getFilter(Users.valueOf("user" + user), Events.valueOf(action), filters);
        }

        if (activeFilter != null){
            template.convertAndSend("queue1",mapper.writeValueAsString(new Message(activeFilter.getUser() , "user"+user +" "+currentEvent.toString() ,activeFilter.getAlert())));
        }
        return factory.getMessageMap(Users.valueOf("user"+user));
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveSettings(@RequestBody List<MessageFilter> filters, Model model ){
        this.filters = filters;
        return "susessfull!!";
    }

    @RequestMapping(value = "/filters")
    public List<MessageFilter> filters(){
        return filters;
    }

}
