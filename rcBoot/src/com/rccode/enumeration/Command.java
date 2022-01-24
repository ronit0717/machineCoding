package com.rccode.enumeration;

public enum Command {
    /*
    ADD_BRANCH {
        @Override
        public Class getRequestPayloadClass() {
            return AddBranchRequest.class;
        }
    },
    ADD_VEHICLE {
        @Override
        public Class getRequestPayloadClass() {
            return AddVehicleRequest.class;
        }
    },
    RENT_VEHICLE {
        @Override
        public Class getRequestPayloadClass() {
            return RentVehicleRequest.class;
        }
    },
    GET_AVAILABLE_VEHICLE {
        @Override
        public Class getRequestPayloadClass() {
            return GetAvailableVehicleRequest.class;
        }
    },
    */
    SOME_COMMAND {
        @Override
        public Class getRequestPayloadClass() {
            //return PrintSystemViewRequest.class;
            return null;
        }
    };

    public Class getRequestPayloadClass() {
        return null;
    }
}
