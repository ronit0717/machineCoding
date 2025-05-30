package com.rccode.enumeration;

import com.rccode.model.Restaurant;

import java.util.List;

public enum Filter {
    PRICE {
        @Override
        public List<Restaurant> filterRestaurant(List<Restaurant> restaurants) {
            restaurants.sort((a, b) -> (b.getFoods().get(0).getPrice() - a.getFoods().get(0).getPrice()));
            return restaurants;
        }
    },
    RATING {
      @Override
      public List<Restaurant> filterRestaurant(List<Restaurant> restaurants) {
          restaurants.sort((a, b) -> (Double.compare(b.getRating(), a.getRating())));
          return restaurants;
      }
    };

    public List<Restaurant> filterRestaurant(List<Restaurant> restaurants) {
        return restaurants;
    }

}
