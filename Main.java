public class Main {
    public static void main(String[] args) {
        EnglishSpanishDictionary dictionary = new EnglishSpanishDictionary();
        dictionary.buildDictionaryFromFile("dictionary.txt");

        // Prueba de traducción de documento
        String document = "The woman asked me to do my homework about my town.";
        String translatedDocument = dictionary.translateDocument(document);
        System.out.println("Documento traducido: " + translatedDocument);

        // Pruebas unitarias
        dictionary.testInsertion();
        dictionary.testSearch();
    }
}
