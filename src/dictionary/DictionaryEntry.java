package dictionary;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Repräsentiert einen Eintrag im Wörterbuch, bestehend aus Stichwort, Beschreibung und Datum des Erstellens
 */

public class DictionaryEntry {

    // Formatvorgabe (Stunde:Minute Tag-Monat-Jahr) für die Darstellung des Erstelldatums
    public static final SimpleDateFormat CREATION_DATE_PATTERN = new SimpleDateFormat("HH:mm dd-MM-yyyy");

    /**
     * Alle Eigenschaften sind final, d.h. sie können nachträglich nicht geändert werden: Bei den Instanzen der
     * DictionaryEntry-Klasse handelt es sich um immutable objects.
     */

    public final String key; // Stichwort für den Eintrag
    public final String description; // Beschreibung des Eintrags
    public final String createdAt; // Erstellungsdatum

    // Im Konstruktor werden die Eigenschaften über die Parameter gesetzt bzw. berechnet (Erstellungsdatum)
    public DictionaryEntry(String key, String description) {
        this.key = key;
        this.description = description;
        this.createdAt = CREATION_DATE_PATTERN.format(new Date());
    }

}
