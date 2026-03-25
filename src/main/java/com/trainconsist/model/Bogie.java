package com.trainconsist.model;

/**
 * Abstract base class representing a Bogie (coach) in a train consist.
 * A bogie is a unit attached to the engine that can carry passengers or goods.
 */
public abstract class Bogie {
    private String bogieId;
    private String bogieType;
    private int capacity;

    public Bogie(String bogieId, String bogieType, int capacity) {
        this.bogieId = bogieId;
        this.bogieType = bogieType;
        this.capacity = capacity;
    }

    public String getBogieId() {
        return bogieId;
    }

    public String getBogieType() {
        return bogieType;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return "Bogie{\" +
                "bogieId='" + bogieId + '\'' +
                ", bogieType='" + bogieType + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}