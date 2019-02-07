package com.wemppywp.projecttest.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Ayahs {

    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("numberInSurah")
    @Expose
    private String numberInSurah;
    @SerializedName("juz")
    @Expose
    private Integer juz;
    @SerializedName("manzil")
    @Expose
    private Integer manzil;
    @SerializedName("page")
    @Expose
    private Integer page;
    @SerializedName("ruku")
    @Expose
    private Integer ruku;
    @SerializedName("hizbQuarter")
    @Expose
    private Integer hizbQuarter;
    @SerializedName("sajda")
    @Expose
    private Boolean sajda;

    public Ayahs(String text, String numberInSurah, Integer juz, Integer manzil, Integer page, Integer ruku, Integer hizbQuarter, Boolean sajda) {
        this.text = text;
        this.numberInSurah = numberInSurah;
        this.juz = juz;
        this.manzil = manzil;
        this.page = page;
        this.ruku = ruku;
        this.hizbQuarter = hizbQuarter;
        this.sajda = sajda;
    }

    public String getText() {
        return text;
    }

    public String getNumberInSurah() {
        return numberInSurah;
    }

    public Integer getJuz() {
        return juz;
    }

    public Integer getManzil() {
        return manzil;
    }

    public Integer getPage() {
        return page;
    }

    public Integer getRuku() {
        return ruku;
    }

    public Integer getHizbQuarter() {
        return hizbQuarter;
    }

    public Boolean getSajda() {
        return sajda;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setNumberInSurah(String numberInSurah) {
        this.numberInSurah = numberInSurah;
    }

    public void setJuz(Integer juz) {
        this.juz = juz;
    }

    public void setManzil(Integer manzil) {
        this.manzil = manzil;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public void setRuku(Integer ruku) {
        this.ruku = ruku;
    }

    public void setHizbQuarter(Integer hizbQuarter) {
        this.hizbQuarter = hizbQuarter;
    }

    public void setSajda(boolean sajda) {
        this.sajda = sajda;
    }
}
