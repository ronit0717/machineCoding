package com.rccode.enumeration;

import com.rccode.dto.*;

public enum Command {

    USER_SIGNUP {
        @Override
        public Class getRequestPayloadClass() {
            return AddUserRequest.class;
        }
    },
    SUBSCRIBE {
        @Override
        public Class getRequestPayloadClass() {
            return SubscribeRequest.class;
        }
    },
    ADD_QUESTION {
        @Override
        public Class getRequestPayloadClass() {
            return AddQuestionRequest.class;
        }
    },
    SHOW_FEED {
        @Override
        public Class getRequestPayloadClass() {
            return ShowFeedRequest.class;
        }
    },
    LOGOUT {
        @Override
        public Class getRequestPayloadClass() {
            return null;
        }
    },
    LOGIN {
        @Override
        public Class getRequestPayloadClass() {
            return UserRequest.class;
        }
    },
    SHOW_QUESTION {
        @Override
        public Class getRequestPayloadClass() {
            return ShowQuestionRequest.class;
        }
    },
    ACCEPT_ANSWER {
        @Override
        public Class getRequestPayloadClass() {
            return AnswerRequest.class;
        }
    },
    UPVOTE_ANSWER {
        @Override
        public Class getRequestPayloadClass() {
            return AnswerRequest.class;
        }
    },
    ADD_ANSWER {
        @Override
        public Class getRequestPayloadClass() {
            return AnswerRequest.class;
        }
    },
    SHOW_PROFILE {
        @Override
        public Class getRequestPayloadClass() {
            return UserRequest.class;
        }
    };

    public Class getRequestPayloadClass() {
        return null;
    }
}
