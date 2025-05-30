package com.rccode.enumeration;

import com.rccode.dto.*;

public enum Command {
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
    PRINT_SYSTEM_VIEW {
        @Override
        public Class getRequestPayloadClass() {
            return PrintSystemViewRequest.class;
        }
    };

    public Class getRequestPayloadClass() {
        return null;
    }
}
