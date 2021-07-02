package test.project01.service;

import test.project01.domain.House;

public class HouseService {
    private House[] houses;

    public HouseService(int size) {
        houses = new House[size];
    }

    public House[] list() {
        return houses;
    }
}
