package com.example.projectforuniversity.models;

import java.util.List;

public class CarPage {
    private int elementTotal;
    private int currentPage;
    private List<Car> listCars;

    public CarPage() {
    }

    public CarPage(int elementTotal, int currentPage, List<Car> listCars) {
        this.elementTotal = elementTotal;
        this.currentPage = currentPage;
        this.listCars = listCars;
    }

    public int getElementTotal() {
        return elementTotal;
    }

    public void setElementTotal(int elementTotal) {
        this.elementTotal = elementTotal;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public List<Car> getListCars() {
        return listCars;
    }

    public void setListCars(List<Car> listCars) {
        this.listCars = listCars;
    }
}
