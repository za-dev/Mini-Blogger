package com.theironyard;

import javax.persistence.*;

/**
 * Created by Jake on 5/8/17.
 */
@Entity
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue
    Integer id;

    @Column (nullable = false)
    String messageText;

    public Message() {
    }

    public Message(String messageText) {
        this.messageText = messageText;
    }

}
