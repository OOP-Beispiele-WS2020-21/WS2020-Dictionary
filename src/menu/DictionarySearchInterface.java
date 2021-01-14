package menu;

import dictionary.Dictionary;
import dictionary.DictionaryEntry;

import java.util.Scanner;

/**
 * Diese Klasse steuert die notwendige Ein- und Ausgabe innerhalb der Anwendung. Über die Konsole werden Informationen
 * für die Nutzer*innen angezeigt und Eingaben (z.B. Suchworte) von diesen angefordert.
 */

public class DictionarySearchInterface {

    /**
     * Diese vier Konstanten repräsentierten die möglichen Optionen, die die Nutzer*innen im Hauptmenü auswählen können.
     */
    public static final int RESPONSE_SHOW_INDEX = 1; // Einträge des Wörterbuchs anzeigen
    public static final int RESPONSE_SEARCH_TERM = 2; // Wort suchen
    public static final int RESPONSE_ADD_TERM = 3; // Wort hinzufügen
    public static final int RESPONSE_EXIT = 4; // Programm beenden

    // Zu verwendendes Wörterbuch: Wird an den Konstruktor der Klasse übergeben und dort in dieser Variable gespeichert
    private final Dictionary dictionary;

    public DictionarySearchInterface(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    /**
     * Gibt eine Liste aller möglichen Optionen auf der Konsole aus und frag die Nutzer*innen, welche Option ausgewählt werden
     * soll. Die ausgewählte Option wird als int-Wert (siehe Konstanten oben) zurückgegeben.
     *
     * @return
     */
    public int showMenuWithOptions() {
        System.out.println("### Hauptmenü ###");
        System.out.println("(1) Inhaltsverzeichnis einsehen");
        System.out.println("(2) Wort suchen");
        System.out.println("(3) Wort hinzufügen");
        System.out.println("(4) Beenden");
        int response = readIntFromUser("Bitte Option auswählen (1-4)");
        return response;
    }

    /**
     * Gibt eine Liste aller im Wörterbuch vorhandenen Stichwörter auf der Konsole aus
     */
    public void listEntries() {
        String[] keys = dictionary.getIndex();
        System.out.println("### Einträge im Wörterbuch ###");
        for (String key : keys) {
            System.out.println(key);
        }
        System.out.println(""); // Leerzeile nach Ausgabe aller Wörter
    }

    /**
     * Ermöglicht es Nutzer*innen, einen neuen Eintrag zum Wörterbuch hinzuzufügen
     */
    public void letUserAddEntry() {
        // Einlesen des neuen Stichworts
        String key = readStringFromUser("Bitte Stichwort eingeben");
        // Einlesen der Beschreibung zum Stichwort
        String description = readStringFromUser("Bitte Beschreibung eingeben");
        // Erstellen des Eintrags
        DictionaryEntry newEntry = new DictionaryEntry(key, description);
        // Hinzufügen des Eintrags zum Wörterbuch
        dictionary.addEntry(newEntry);
        System.out.println("Eintrag (" + newEntry.key + ") hinzugefügt!");
        System.out.println(""); // Leerzeile nach Eingabe des neuen des Eintrags
    }

    /**
     * Ermöglicht es Nutzer*innen, nach einem bestimmten Wort im Wörterbuch zu suchen
     */
    public void letUserSearchForEntry() {
        // Einlesen des Suchworts
        String key = readStringFromUser("Bitte Suchwort eingeben");
        // "Nachschlagen" im Wörterbuch
        DictionaryEntry entry = dictionary.getEntry(key);
        // Wenn kein passender Eintrag im Wörterbuch gefunden wurde ...
        if (entry == null) {
            // ... wird ein entsprechender Hinweis ausgegeben und die Methode beenden
            System.out.println("Für das Suchwort \"" + key + "\" konnte kein Eintrag gefunden werden\"");
            return;
        }
        // Wenn ein passender Eintrag gefunden wurde, wird dieser auf der Konsole ausgegeben
        printEntry(entry);
    }

    /**
     * Gibt den übergebenen Eintrag des Wörterbuchs sauber formatiert auf der Konsole aus
     *
     * @param entry
     */
    private static void printEntry(DictionaryEntry entry) {
        // Ausgabe von Stichwort und Erstellungsdatum
        System.out.print(entry.key + " (erstellt: " + entry.createdAt + ") => ");
        // Ausgabe der Beschreibung
        System.out.println("\"" + entry.description + "\"");
        System.out.println(""); // Leerzeile nach Ausgabe des Eintrags
    }

    /**
     * Liest einen String ein, den die Nutzer*innen auf der Konsole ausgeben
     *
     * @param prompt Hinweis für die Nutzer*innen, was eingegeben werden soll (wird vor der Eingabe angezeigt)
     * @return Der eingegeben String
     */
    private String readStringFromUser(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(prompt + ": ");
        return scanner.nextLine();
    }

    /**
     * Liest einen int-Wert ein, den die Nutzer*innen auf der Konsole ausgeben
     *
     * @param prompt Hinweis für die Nutzer*innen, was eingegeben werden soll (wird vor der Eingabe angezeigt)
     * @return Der eingegeben int-Wert
     */
    private int readIntFromUser(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(prompt + ": ");
        return scanner.nextInt();
    }


}
