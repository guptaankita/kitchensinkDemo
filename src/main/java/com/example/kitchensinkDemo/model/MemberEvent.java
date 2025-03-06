package com.example.kitchensinkDemo.model;

import org.springframework.context.ApplicationEvent;

public class MemberEvent extends ApplicationEvent {
    private final String message;

    public MemberEvent(Member member, String message) {
        super(member);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
