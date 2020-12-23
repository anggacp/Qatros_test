package com.project.qatros_logbook;

public class LogBook {
    private String Item_name;
    private String Item_amount;
    private String Item_supplier;
    private String Item_date;
    private Integer Item_id;

    private LogBook() {
    }

    private LogBook(String name, String amount, String supplier, String date, Integer id) {
        this.Item_name = name;
        this.Item_amount = amount;
        this.Item_supplier = supplier;
        this.Item_date = date;
        this.Item_id = id;
    }

    public String getItem_name() {
        return Item_name;
    }

    public void setItem_name(String item_name) {
        Item_name = item_name;
    }

    public String getItem_amount() {
        return Item_amount;
    }

    public void setItem_amount(String item_amount) {
        Item_amount = item_amount;
    }

    public String getItem_supplier() {
        return Item_supplier;
    }

    public void setItem_supplier(String item_supplier) {
        Item_supplier = item_supplier;
    }

    public String getItem_date() {
        return Item_date;
    }

    public void setItem_date(String item_date) {
        Item_date = item_date;
    }

    public Integer getItem_id() {
        return Item_id;
    }

    public void setItem_id(Integer item_id) {
        Item_id = item_id;
    }
}
