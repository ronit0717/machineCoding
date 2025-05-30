package com.rccode.enumeration;

import com.rccode.dto.*;

public enum Command {

    REGISTER_USER {
        @Override
        public Class getRequestPayloadClass() {
            return AddUserRequest.class;
        }
    },
    REGISTER_RESTAURANT {
        @Override
        public Class getRequestPayloadClass() {
            return AddRestaurantRequest.class;
        }
    },
    LOGIN_USER {
        @Override
        public Class getRequestPayloadClass() {
            return UserLoginRequest.class;
        }
    },
    PLACE_ORDER {
        @Override
        public Class getRequestPayloadClass() {
            return PlaceOrderRequest.class;
        }
    },
    SHOW_RESTAURANT {
        @Override
        public Class getRequestPayloadClass() {
            return ShowRestaurantRequest.class;
        }
    },
    CREATE_REVIEW {
        @Override
        public Class getRequestPayloadClass() {
            return CreateReviewRequest.class;
        }
    },
    UPDATE_LOCATION {
        @Override
        public Class getRequestPayloadClass() {
            return UpdateLocationRequest.class;
        }
    },
    UPDATE_QUANTITY {
        @Override
        public Class getRequestPayloadClass() {
            return UpdateQuantityRequest.class;
        }
    };

    public Class getRequestPayloadClass() {
        return null;
    }
}
