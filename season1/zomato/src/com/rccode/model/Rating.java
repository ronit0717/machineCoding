package com.rccode.model;

import com.rccode.dto.CreateReviewRequest;
import com.rccode.exception.ProcessException;

public class Rating {
    private int rating;
    private String comment;
    private User user;

    public Rating(CreateReviewRequest reviewRequest, User user) {
        if (reviewRequest.getRating() < 0 || reviewRequest.getRating() > 5) {
            throw new ProcessException("Add Rating", "Invalid Rating");
        }
        this.rating = reviewRequest.getRating();
        this.comment = reviewRequest.getComment();
        this.user = user;
    }

    public int getRating() {
        return rating;
    }

    public String getComment() {
        return comment;
    }
}
