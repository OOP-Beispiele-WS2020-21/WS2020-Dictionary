package dictionary;

import java.util.HashMap;

/**
 * Repräsentiert das Wörterbuch, in dem die DictionaryEntry-Objekte gespeichert werden.
 */

public class Dictionary {

    // Variable für die HashMap zum Speichern der Einträge (die Map wird im Konstruktor erstellt)
    private HashMap<String, DictionaryEntry> dictionary;

    public Dictionary() {
        dictionary = new HashMap<>();
    }

    /**
     * Fügt einen neuen Eintrag zum Wörterbuch hinzu
     *
     * @param entry Der neue Eintrag
     */
    public void addEntry(DictionaryEntry entry) {
        dictionary.put(entry.key, entry);
    }

    /**
     * Sucht nach einem Eintrag, der unter dem übergebenen Stichwort in dem Wörterbuch gespeichert wurde
     *
     * @param key Stichwort (key) für den zu suchenden Eintrag
     * @return DictionaryEntry-Objekt, das unter dem übergebenen Stichwort gespeichert ist oder null, falls kein passende Objekt gefunden wurde
     */
    public DictionaryEntry getEntry(String key) {
        return dictionary.get(key);
    }

    /**
     * Gibt alle Stichwörter (Keys) des Wörterbuchs als Array zurück
     *
     * @return Array mit allen Stichwörtern des Wörterbuchs
     */
    public String[] getIndex() {
        return dictionary.keySet().toArray(new String[0]);
    }

}
