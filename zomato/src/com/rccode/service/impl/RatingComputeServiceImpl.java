package com.rccode.service.impl;

import com.rccode.model.Rating;
import com.rccode.service.RatingComputeService;

import java.util.List;

public class RatingComputeServiceImpl implements RatingComputeService {

    @Override
    public double computeRating(List<Rating> ratings) {
        int sumRating = 0;
        int count = 0;
        for (Rating rating : ratings) {
            sumRating += rating.getRating();
            count++;
        }
        return count == 0 ? 0 : (double) sumRating / count;
    }
}
