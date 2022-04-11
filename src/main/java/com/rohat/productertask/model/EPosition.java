package com.rohat.productertask.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum EPosition {
    PG{
        @Override
        public String toString() {
            return "Point Guard";
        }
    },
    SG{
        @Override
        public String toString() {
            return "Shooting Guard";
        }
    },
    SF{
        @Override
        public String toString() {
            return "Small Forward";
        }
    },
    PF{
        @Override
        public String toString() {
            return "Power Forward";
        }
    },
    @JsonProperty("Center")
    C{
        @Override
        public String toString() {
            return "Center";
        }
    }

}
