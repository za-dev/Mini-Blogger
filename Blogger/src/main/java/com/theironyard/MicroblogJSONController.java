package com.theironyard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * Created by Jake on 5/8/17.
 */

@RestController
public class MicroblogJSONController {
    @Autowired
    MessageRepo messages;
    //.json URL
    //not storing model anymore because we hae no view anymore.
    @RequestMapping(path = "/add-message.json", method = RequestMethod.POST)
    public ArrayList<Message> jsonAdd(@RequestBody Message messageText) {
        messages.save(messageText);
        return (ArrayList<Message>) messages.findAll();
    }
    @RequestMapping(path = "/remove-message.json", method = RequestMethod.POST)
    public ArrayList<Message> jsonRemove(@RequestBody Message id) {
        for (Message allMessage: messages.findAll()) {
            if (allMessage.id == id.id) {
                Message a = allMessage;
                messages.delete(a);
                break;
            }
        }

        return (ArrayList<Message>) messages.findAll();
    }
    @RequestMapping(path = "/get-messages.json", method = RequestMethod.GET)
    public ArrayList<Message> jsonReturn(Message messageText) {
        return (ArrayList<Message>) messages.findAll();
    }

}
