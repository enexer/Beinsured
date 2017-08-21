package com.example.as.beinsured.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by as on 18.07.2017.
 */

public class Account {


    @SerializedName("status")
    private String status;
    @SerializedName("rodzaj_konta")
    private Integer rodzajKonta;
    @SerializedName("typ_abonamentu")
    private String typAbonamentu;
    @SerializedName("okres")
    private String okres;
    @SerializedName("data_konca")
    private String dataKonca;
    @SerializedName("max_ilosc_dostepow")
    private String maxIloscDostepow;
    @SerializedName("wykorzystano_ilosc_dostepow")
    private String wykorzystanoIloscDostepow;


    @Override
    public String toString() {
        return "Account{" +
                "status='" + status + '\'' +
                ", rodzajKonta=" + rodzajKonta +
                ", typAbonamentu='" + typAbonamentu + '\'' +
                ", okres='" + okres + '\'' +
                ", dataKonca='" + dataKonca + '\'' +
                ", maxIloscDostepow='" + maxIloscDostepow + '\'' +
                ", wykorzystanoIloscDostepow='" + wykorzystanoIloscDostepow + '\'' +
                '}';
    }

    public Account(String status, Integer rodzajKonta, String typAbonamentu, String okres, String dataKonca, String maxIloscDostepow, String wykorzystanoIloscDostepow) {
        this.status = status;
        this.rodzajKonta = rodzajKonta;
        this.typAbonamentu = typAbonamentu;
        this.okres = okres;
        this.dataKonca = dataKonca;
        this.maxIloscDostepow = maxIloscDostepow;
        this.wykorzystanoIloscDostepow = wykorzystanoIloscDostepow;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getRodzajKonta() {
        return rodzajKonta;
    }

    public void setRodzajKonta(Integer rodzajKonta) {
        this.rodzajKonta = rodzajKonta;
    }

    public String getTypAbonamentu() {
        return typAbonamentu;
    }

    public void setTypAbonamentu(String typAbonamentu) {
        this.typAbonamentu = typAbonamentu;
    }

    public String getOkres() {
        return okres;
    }

    public void setOkres(String okres) {
        this.okres = okres;
    }

    public String getDataKonca() {
        return dataKonca;
    }

    public void setDataKonca(String dataKonca) {
        this.dataKonca = dataKonca;
    }

    public String getMaxIloscDostepow() {
        return maxIloscDostepow;
    }

    public void setMaxIloscDostepow(String maxIloscDostepow) {
        this.maxIloscDostepow = maxIloscDostepow;
    }

    public String getWykorzystanoIloscDostepow() {
        return wykorzystanoIloscDostepow;
    }

    public void setWykorzystanoIloscDostepow(String wykorzystanoIloscDostepow) {
        this.wykorzystanoIloscDostepow = wykorzystanoIloscDostepow;
    }
}
