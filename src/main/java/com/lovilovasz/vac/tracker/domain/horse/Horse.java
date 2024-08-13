package com.lovilovasz.vac.tracker.domain.horse;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Horse {
    @JsonProperty("loId")
    private long loId;

    @JsonProperty("nev")
    private String name;

    @JsonProperty("loAzon")
    private String loAzon;

    @JsonProperty("tkvSzam")
    private String tkvSzam;

    @JsonProperty("anyaId")
    private long anyaId;

    @JsonProperty("apaId")
    private long apaId;

    @JsonProperty("anyApId")
    private long anyApId;

    @JsonProperty("anyaNev")
    private String anyaNev;

    @JsonProperty("apaNev")
    private String apaNev;

    @JsonProperty("anyApNev")
    private String anyApNev;

    @JsonProperty("ueln")
    private String ueln;

    @JsonProperty("fajtaKod")
    private String fajtaKod;

    @JsonProperty("fajtaHu")
    private String fajtaHu;

    @JsonProperty("fajtaEn")
    private String fajtaEn;

    @JsonProperty("szuletesiEv")
    private int szuletesiEv;

    @JsonProperty("szuletesiHo")
    private int szuletesiHo;

    @JsonProperty("szuletesiNap")
    private int szuletesiNap;

    @JsonProperty("nemKod")
    private String nemKod;

    @JsonProperty("nemHu")
    private String nemHu;

    @JsonProperty("nemEn")
    private String nemEn;

    @JsonProperty("aktivFedezomen")
    private boolean aktivFedezomen;

    @JsonProperty("szinKod")
    private String szinKod;

    @JsonProperty("szinHu")
    private String szinHu;

    @JsonProperty("szinEn")
    private String szinEn;

    @JsonProperty("ivartalanitva")
    private boolean ivartalanitva;

    @JsonProperty("laraSzincsoportKod")
    private String laraSzincsoportKod;

    @JsonProperty("laraSzincsoportHu")
    private String laraSzincsoportHu;

    @JsonProperty("laraSzincsoportEn")
    private String laraSzincsoportEn;

    @JsonProperty("importLo")
    private boolean importLo;

    @JsonProperty("eladoLo")
    private boolean eladoLo;

    @JsonProperty("arKategoria")
    private String arKategoria;

    @JsonProperty("hasznositasiIrany")
    private String hasznositasiIrany;

    @JsonProperty("fedeztetesiDij")
    private String fedeztetesiDij;

    @JsonProperty("tartasiHely")
    private String tartasiHely;

    @JsonProperty("mikrochip")
    private String mikrochip;

    @JsonProperty("loutlevelStatus")
    private boolean loutlevelStatus;

    @JsonProperty("fogyatekVegleges")
    private boolean fogyatekVegleges;

    @JsonProperty("szarmazasEllenorzes")
    private boolean szarmazasEllenorzes;

    @JsonProperty("tenyesztoNev")
    private String tenyesztoNev;
}

