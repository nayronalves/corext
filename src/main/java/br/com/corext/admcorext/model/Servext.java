package br.com.corext.admcorext.model;

public class Servext {

    private String total;

    private String records;

    public Servext(String total, String records) {
        this.total = total;
        this.records = records;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getRecords() {
        return records;
    }

    public void setRecords(String records) {
        this.records = records;
    }    
    
}
