package com.example.as.beinsured.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by as on 18.07.2017.
 */
public class NewsletterDetails {

    @SerializedName("status")
    private String status;
    @SerializedName("data")
    private Data data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public class Data {

        @SerializedName("spis_tresci")
        private SpisTresci spisTresci;
        @SerializedName("zawartosc")
        private ArrayList<Zawartosc> zawartosc = null;

        public SpisTresci getSpisTresci() {
            return spisTresci;
        }

        public void setSpisTresci(SpisTresci spisTresci) {
            this.spisTresci = spisTresci;
        }

        public ArrayList<Zawartosc> getZawartosc() {
            return zawartosc;
        }

        public void setZawartosc(ArrayList<Zawartosc> zawartosc) {
            this.zawartosc = zawartosc;
        }

        public class SpisTresci {

            @SerializedName("1")
            private Nr1 nr1;

            public Nr1 getNr1() {
                return nr1;
            }

            public void setNr1(Nr1 nr1) {
                this.nr1 = nr1;
            }

            public class Nr1 {

                @SerializedName("tytul")
                private String tytul;
                @SerializedName("pozycje")
                private ArrayList<Pozycje> pozycje = null;

                public String getTytul() {
                    return tytul;
                }

                public void setTytul(String tytul) {
                    this.tytul = tytul;
                }

                public ArrayList<Pozycje> getPozycje() {
                    return pozycje;
                }

                public void setPozycje(ArrayList<Pozycje> pozycje) {
                    this.pozycje = pozycje;
                }

                public class Pozycje {

                    @SerializedName("tytul")
                    private String tytul;
                    @SerializedName("kotwica")
                    private Integer kotwica;

                    public String getTytul() {
                        return tytul;
                    }

                    public void setTytul(String tytul) {
                        this.tytul = tytul;
                    }

                    public Integer getKotwica() {
                        return kotwica;
                    }

                    public void setKotwica(Integer kotwica) {
                        this.kotwica = kotwica;
                    }
                }
            }
        }

        public class Zawartosc {
            @SerializedName("tytul")
            private String tytul;
            @SerializedName("link")
            private String link;
            @SerializedName("typ")
            private String typ;
            @SerializedName("tresc")
            private String tresc;
            @SerializedName("id_aktualnosci")
            private String idAktualnosci;
            @SerializedName("autor")
            private String autor;
            @SerializedName("publikator")
            private String publikator;
            @SerializedName("image")
            private Image image;
            @SerializedName("baner_link")
            private String banerLink;
            @SerializedName("kotwica")
            private Integer kotwica;

            @Override
            public String toString() {
                return "Zawartosc{" +
                        "tytul='" + tytul + '\'' +
                        ", link='" + link + '\'' +
                        ", typ='" + typ + '\'' +
                        ", tresc='" + tresc + '\'' +
                        ", idAktualnosci='" + idAktualnosci + '\'' +
                        ", autor='" + autor + '\'' +
                        ", publikator='" + publikator + '\'' +
                        ", image=" + image +
                        ", banerLink='" + banerLink + '\'' +
                        ", kotwica=" + kotwica +
                        '}';
            }

            public String getTytul() {
                return tytul;
            }

            public void setTytul(String tytul) {
                this.tytul = tytul;
            }

            public String getLink() {
                return link;
            }

            public void setLink(String link) {
                this.link = link;
            }

            public String getTyp() {
                return typ;
            }

            public void setTyp(String typ) {
                this.typ = typ;
            }

            public String getTresc() {
                return tresc;
            }

            public void setTresc(String tresc) {
                this.tresc = tresc;
            }

            public String getIdAktualnosci() {
                return idAktualnosci;
            }

            public void setIdAktualnosci(String idAktualnosci) {
                this.idAktualnosci = idAktualnosci;
            }

            public String getAutor() {
                return autor;
            }

            public void setAutor(String autor) {
                this.autor = autor;
            }

            public String getPublikator() {
                return publikator;
            }

            public void setPublikator(String publikator) {
                this.publikator = publikator;
            }

            public Image getImage() {
                return image;
            }

            public void setImage(Image image) {
                this.image = image;
            }

            public String getBanerLink() {
                return banerLink;
            }

            public void setBanerLink(String banerLink) {
                this.banerLink = banerLink;
            }

            public Integer getKotwica() {
                return kotwica;
            }

            public void setKotwica(Integer kotwica) {
                this.kotwica = kotwica;
            }

            public class Image {
                @SerializedName("link")
                private String link;
                @SerializedName("width")
                private String width;
                @SerializedName("height")
                private String height;

                @Override
                public String toString() {
                    return "Image{" +
                            "link='" + link + '\'' +
                            ", width='" + width + '\'' +
                            ", height='" + height + '\'' +
                            '}';
                }

                public String getLink() {
                    return link;
                }

                public void setLink(String link) {
                    this.link = link;
                }

                public String getWidth() {
                    return width;
                }

                public void setWidth(String width) {
                    this.width = width;
                }

                public String getHeight() {
                    return height;
                }

                public void setHeight(String height) {
                    this.height = height;
                }
            }
        }
    }
}