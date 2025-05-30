package com.rccode.dto;

import java.util.List;

public class ShowFeedRequest {
    private List<String> filter;
    private Boolean answered;

    public ShowFeedRequest(List<String> filter, Boolean answered) {
        this.filter = filter;
        this.answered = answered;
    }

    public List<String> getFilter() {
        return filter;
    }

    public Boolean getAnswered() {
        return answered;
    }
}

