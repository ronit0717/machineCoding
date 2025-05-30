package com.rccode.dto;

import java.util.List;

public class SubscribeRequest {
    private List<String> topics;

    public SubscribeRequest(List<String> topics) {
        this.topics = topics;
    }

    public List<String> getTopics() {
        return topics;
    }
}
