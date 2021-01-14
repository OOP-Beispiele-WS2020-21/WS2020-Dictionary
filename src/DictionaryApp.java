import dictionary.Dictionary;
import menu.DictionarySearchInterface;

/**
 * Diese Konsolenanwendung demonstriert die Verwendung von HashMaps zu Speicherung und effizienten Suche von
 * Objekten über Schlüssel-Objekte am Beispiel eines einfachen Wörterbuchs. Nutzer*innen können über eine textuelle
 * Schnittstelle (in der Konsole) neue Einträge zum Wörterbuch hinzufügen, einer Liste aller Stichworte ausgeben und
 * nach Einträgen suchen.
 * <p>
 * Aufbau:
 * <p>
 * DictionaryEntry: Diese Klasse repräsentiert einen Eintrag im Wörterbuch, bestehend aus Stichwort, Beschreibung und Erstellungsdatum
 * Dictionary: Diese Klasse repräsentiert das Wörterbuch selbst. Hier können neue Einträge (DictionaryEntry) zur HashMap hinzugefügt werden
 * DictionarySearchInterface: Diese Klasse kümmert sich um die Aus- und Eingabe auf der Konsole
 */

public class DictionaryApp {

    public static void main(String[] args) {
        // Erstellen des (leeren) Wörterbuchs
        Dictionary myDictionary = new Dictionary();
        // Erstellen der "User Interfaces", das über die Konsole den Zugriff auf das Wörterbuch ermöglicht
        DictionarySearchInterface searchInterface = new DictionarySearchInterface(myDictionary);
        int response = 0;
        // Wir fragen die Nutzer*innen solange danach, was sie machen wollen, bis Sie die Option "Beenden (RESPONSE_EXIT)" wählen
        while (response != DictionarySearchInterface.RESPONSE_EXIT) {
            // Die Methode showMenuWithOptions liefert einen int-Wert zurück, der die Auswahl der Nutzer*innen repräsentiert
            response = searchInterface.showMenuWithOptions();
            switch (response) {
                // Der User möchte alle Stichwörter des Wörterbuchs ausgeben
                case DictionarySearchInterface.RESPONSE_SHOW_INDEX:
                    searchInterface.listEntries();
                    break;
                // Der User möchte nach einem Begriff im Wörterbuch suchen
                case DictionarySearchInterface.RESPONSE_SEARCH_TERM:
                    searchInterface.letUserSearchForEntry();
                    break;
                // Der User möchte einen Begriff zum Wörterbuch hinzufügen
                case DictionarySearchInterface.RESPONSE_ADD_TERM:
                    searchInterface.letUserAddEntry();
                    break;
                default:
                    break;
            }
        }
    }


}
