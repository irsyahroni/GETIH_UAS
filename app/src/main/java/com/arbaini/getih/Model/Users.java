package com.arbaini.getih.Model;

public class Users {

    private String UserId;
    private String NoHp;
    private String GolDar;
    private String BeratBadan;
    private String Email;
    private String nama;


    private String Alamat;

    public Users(String noHp, String golDar, String beratBadan, String email, String nama, String alamat) {
        NoHp = noHp;
        GolDar = golDar;
        BeratBadan = beratBadan;
        Email = email;
        this.nama = nama;
        Alamat = alamat;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getNoHp() {
        return NoHp;
    }

    public void setNoHp(String noHp) {
        NoHp = noHp;
    }

    public String getGolDar() {
        return GolDar;
    }

    public void setGolDar(String golDar) {
        GolDar = golDar;
    }

    public String getBeratBadan() {
        return BeratBadan;
    }

    public void setBeratBadan(String beratBadan) {
        BeratBadan = beratBadan;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
    public String getAlamat() {
        return Alamat;
    }

    public void setAlamat(String alamat) {
        Alamat = alamat;
    }


    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
}
