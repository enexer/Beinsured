package com.example.as.beinsured.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by as on 18.07.2017.
 */

public class NewsletterPage {

    @SerializedName("data")
    private ArrayList<Newsletter> items;
    @SerializedName("pages")
    private Long pages;

    public NewsletterPage(ArrayList<Newsletter> items, Long pages) {
        this.items = items;
        this.pages = pages;
    }

    public ArrayList<Newsletter> getItems() {
        return items;
    }

    public void setItems(ArrayList<Newsletter> items) {
        this.items = items;
    }

    public Long getPages() {
        return pages;
    }

    public void setPages(Long pages) {
        this.pages = pages;
    }

    public class Newsletter {
        @SerializedName("id")
        private Integer id;
        @SerializedName("tytul")
        private String tytul;
        @SerializedName("data_wyslania")
        private String dataWyslania;
        @SerializedName("czas_wyslania")
        private String czasWyslania;

        @Override
        public String toString() {
            return "Newsletter{" +
                    "id=" + id +
                    ", tytul='" + tytul + '\'' +
                    ", dataWyslania='" + dataWyslania + '\'' +
                    ", czasWyslania='" + czasWyslania + '\'' +
                    '}';
        }

        public Newsletter(Integer id, String tytul, String dataWyslania, String czasWyslania) {
            this.id = id;
            this.tytul = tytul;
            this.dataWyslania = dataWyslania;
            this.czasWyslania = czasWyslania;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getTytul() {
            return tytul;
        }

        public void setTytul(String tytul) {
            this.tytul = tytul;
        }

        public String getDataWyslania() {
            return dataWyslania;
        }

        public void setDataWyslania(String dataWyslania) {
            this.dataWyslania = dataWyslania;
        }

        public String getCzasWyslania() {
            return czasWyslania;
        }

        public void setCzasWyslania(String czasWyslania) {
            this.czasWyslania = czasWyslania;
        }


    }
}
