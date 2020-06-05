package com.example.projectforuniversity.models;

import com.example.projectforuniversity.models.Car;

import java.util.List;

public class CarPage {
    private int pageTotal;
    private int currentPage;
    private List<Car> listCars;

    public CarPage() {
    }

    public CarPage(int pageTotal, int currentPage, List<Car> listCars) {
        this.pageTotal = pageTotal;
        this.currentPage = currentPage;
        this.listCars = listCars;
    }

    public int getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(int pageTotal) {
        this.pageTotal = pageTotal;
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
