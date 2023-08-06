package com.epicode.classes;

import java.time.LocalDate;

import com.epicode.enums.Stato;

public abstract class MezzoTrasporto {
private int capienzaPersone;
private Stato stato;
private LocalDate inizioServizio;
private LocalDate fineServizio;
private LocalDate inizioManutenzione;
private LocalDate fineManutenzione;
private boolean validazione;

}
