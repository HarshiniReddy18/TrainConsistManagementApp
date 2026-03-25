package com.trainconsist.model;

public class Train {
    private String trainNumber;
    private String trainName;
    private int numberOfCoaches;

    public Train(String trainNumber, String trainName, int numberOfCoaches) {
        this.trainNumber = trainNumber;
        this.trainName = trainName;
        this.numberOfCoaches = numberOfCoaches;
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public String getTrainName() {
        return trainName;
    }

    public int getNumberOfCoaches() {
        return numberOfCoaches;
    }

    @Override
    public String toString() {
        return "Train{ " + 
                "trainNumber='" + trainNumber + '\'' + 
                ", trainName='" + trainName + '\'' + 
                ", numberOfCoaches=" + numberOfCoaches + 
                ' }';
    }
}