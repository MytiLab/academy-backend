package it.myti.academy.backend.model.errori;

import lombok.Data;

import java.util.Date;

@Data
public class DettagliErrore {
    private Date data;
    private int codice;
    private String messaggio;

    public DettagliErrore(int codice, String messaggio){
        data = new Date();
        this.codice = codice;
        this.messaggio = messaggio;
    }
}
