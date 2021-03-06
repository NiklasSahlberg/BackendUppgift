package com.example.backenduppgift.controllers;

import com.example.backenduppgift.models.Response;
import com.example.backenduppgift.models.Shop;
import com.example.backenduppgift.dao.ShopDAO;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class ShopController {

    ShopDAO shopDAO = new ShopDAO();
    List<Shop> shopData = shopDAO.getAllItems();
    Shop shop;

    @RequestMapping(value = "/ShopJSON", produces = "application/JSON")
    public Shop enItemJSON() {
        return new Shop(1, "Fridge");
    }


    @RequestMapping("/items/")
    public List<Shop> index() {
        System.out.println(shopData);
        return shopData;
    }

    @RequestMapping("/items/:id")
    public Shop getItemById(@PathParam("id") int id) {


        shopData.forEach(data -> {
            if (data.getId() == id) {
                shop = new Shop(data.getId(), data.getNamn());
            }
        });


        return shop;
    }

    @RequestMapping("/items/:namn")
    public Shop getItemByNamn(@PathParam("namn") String namn) {


        shopData.forEach(data -> {
            if (data.getNamn().equals(namn)) {
                shop = new Shop(data.getId(), data.getNamn());
            }
        });


        return shop;
    }
    @RequestMapping("/items/{id}/delete")
    public Response deleteItemById(@PathVariable("id") int id) {
        Response res = new Response("Item deleted", Boolean.FALSE);


        int indexToRemove = -1;
        for (int i = 0; i < shopData.size(); i++) {

            if (shopData.get(i).getId() == id) {
                indexToRemove = i;

            }

        }
        if (indexToRemove != -1) {
            shopData.remove(indexToRemove);
            res.setStatus(Boolean.TRUE);
        }
        return res;
    }

    @PostMapping("/items/add")
    public Response addItem(@RequestBody Shop i) {
        System.out.println(i.getId() + " " + i.getNamn());
        Response res = new Response("Item added", Boolean.FALSE);
        shopData.add(i);

        res.setStatus(Boolean.TRUE);
        System.out.println(shopData);
        return res;
    }
}

//Test