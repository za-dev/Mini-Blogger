package com.theironyard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
public class MicroBlogSpringController {

    @Autowired
    public MessageRepo messages;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(Model model, HttpSession session) {
        List<Message> messageList = (List<Message>) messages.findAll();
        model.addAttribute("name", session.getAttribute("userName"));
        model.addAttribute("messages", messageList);
        return "home";
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(HttpSession session, String userName) {
        session.setAttribute("userName", userName);
        return "redirect:/";
    }

    @RequestMapping(path = "/add-message", method = RequestMethod.POST)
    public String message(String message) {
        Message newMessage = new Message(message);
//        session.setAttribute("message", text);
        messages.save(newMessage);
        System.out.println(newMessage.id + newMessage.messageText);

        return "redirect:/";
    }
    @RequestMapping(path = "/delete-message", method = RequestMethod.POST)
    public String delete(String id) {
//        Message a = messages.get(id);
        messages.delete(messages.findOne(Integer.valueOf(id)));
        System.out.println(id);
        return "redirect:/";
    }
    @RequestMapping(path = "/update-message", method = RequestMethod.POST)
    public String edit(String id, String update) {
        Message message = messages.findOne(Integer.valueOf(id));
        message.messageText = update;
        messages.save(message);
        System.out.println(id + update);
        return "redirect:/";
    }
}
