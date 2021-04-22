package com.silvia.administrasijaringan;

public class API {

    private String HOST = "https://mediapembelajaran.mantagi.com/";

    public String URL_LOGIN = HOST + "api/login";
    public String URL_MATERI = HOST + "api/getDataMateri";
    public String URL_JOBSHEET = HOST + "api/getDataRpp";
    public String URL = HOST + "api/getDataJobsheet";
    public String URL_VIDEO = HOST + "api/getDataVideo";
    public String URL_EVALUASI = HOST + "api/getDataSoal?id_materi=";
    public String URL_NILAI =  HOST + "api/insert_nilai";
    public String URL_IsiMateri = HOST + "Materi/download/";
    public String URL_IsiRpp= HOST +  "Rpp/download/";



}
