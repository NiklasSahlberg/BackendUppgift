package com.example.backenduppgift.models;



import java.util.ArrayList;
import java.util.List;

public class ShopDAO {

    public List<Shop> getAllItems(){
        List<Shop> itemList = new ArrayList<>();
        Shop item1 = new Shop(1, "Frys.");
        Shop item2 = new Shop(2,"Kyl.");
        Shop item3 = new Shop(3,"Tv.");
        Shop item4 = new Shop(4, "Kaffebryggare.");

        itemList.add(item1);
        itemList.add(item2);
        itemList.add(item3);
        itemList.add(item4);

        return itemList;
    }
}