package com.example.java.a_zapp;

import java.util.ArrayList;

/**
 * Created by hyohyeon on 2018-10-25.
 */

public class Item {

    private String groupNm;
    private ItemVo items;

    public ItemVo getItems() {
        return items;
    }

    public void setItems(ItemVo items) {
        this.items = items;
    }

    Item(String name){
        groupNm = name;
        items = new ItemVo();
    }

    public String getGroupNm() {
        return groupNm;
    }

    public void setGroupNm(String groupNm) {
        this.groupNm = groupNm;
    }




}
