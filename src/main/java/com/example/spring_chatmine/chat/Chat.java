package com.example.spring_chatmine.chat;

public class Chat {
    public enum MessageType{
        ENTER, MSG
    }
    private MessageType type;

    private Long id;
    private String sender;
    private String roomId;
    private String message;

    public Chat(Long id, String sender, String roomId, String message) {
        this.id = id;
        this.sender = sender;
        this.roomId = roomId;
        this.message = message;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSender() {
        return this.sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getRoomId() {
        return this.roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public MessageType getType() {
        return this.type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }
}
