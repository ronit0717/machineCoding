package com.rccode.service;

import com.rccode.model.Rating;

import java.util.List;

public interface RatingComputeService {
    double computeRating(List<Rating> ratings);
}
