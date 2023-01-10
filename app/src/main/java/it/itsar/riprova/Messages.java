package it.itsar.riprova;

import android.os.Build;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Messages implements Serializable {
    private String messaggio;
    private LocalDateTime localDateTime;
    private String nome_soggetto;

    public Messages(String messaggio, LocalDateTime localDateTime, String nome_soggetto) {
        this.messaggio = messaggio;
        this.localDateTime = localDateTime;
        this.nome_soggetto = nome_soggetto;
    }

    public String getMessaggio() {
        return messaggio;
    }

    public void setMessaggio(String messaggio) {
        this.messaggio = messaggio;
    }

    public String getLocalDateTime() {
        String orario = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            orario = localDateTime.getDayOfMonth() + "/" + localDateTime.getMonthValue() + "/" + localDateTime.getYear() + " " + localDateTime.getHour() + ":" + localDateTime.getMinute();
        }
        return orario;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public String getNome_soggetto() {
        return nome_soggetto;
    }

    public void setNome_soggetto(String nome_soggetto) {
        this.nome_soggetto = nome_soggetto;
    }
}
