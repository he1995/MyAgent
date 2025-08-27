package com.example.myagent.session;

import com.example.myagent.mask.Mask;
import com.example.myagent.message.ChatMessage;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Session {

    @Id
    private String id;

    private String creatTime;

    private String lastUpdate;

    private String topic;

    @OneToMany(mappedBy = "session", cascade = CascadeType.ALL)
    private List<ChatMessage> messages;

    @OneToOne
    @JoinColumn(name = "mask_id", referencedColumnName = "id")
    private Mask mask;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(String creatTime) {
        this.creatTime = creatTime;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public List<ChatMessage> getMessages() {
        return messages;
    }

    public void setMessages(List<ChatMessage> messages) {
        this.messages = messages;
    }

    public Mask getMask() {
        return mask;
    }

    public void setMask(Mask mask) {
        this.mask = mask;
    }
}
