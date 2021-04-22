package com.silvia.administrasijaringan.Latihan;

public class ModelLatihan {

    private String id_materi;
    private String judul_materi;

    public ModelLatihan(String id_materi, String judul_materi) {
        this.id_materi = id_materi;
        this.judul_materi = judul_materi;
    }

    public String getId_materi() {
        return id_materi;
    }

    public void setId_materi(String id_materi) {
        this.id_materi = id_materi;
    }

    public String getJudul_materi() {
        return judul_materi;
    }

    public void setJudul_materi(String judul_materi) {
        this.judul_materi = judul_materi;
    }
}
