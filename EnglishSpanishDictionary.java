import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// Clase principal para el diccionario inglés-español
public class EnglishSpanishDictionary {
    private BinaryTree<Association<String, String>> dictionary;

    public EnglishSpanishDictionary() {
        dictionary = new BinaryTree<Association<String, String>>();
    }


    // Método para construir el diccionario a partir de un archivo
    public void buildDictionaryFromFile(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String key = parts[0].trim();
                    String value = parts[1].trim();
                    Association<String, String> association = new Association<>(key, value);
                    dictionary.insert(association);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para traducir un documento en inglés al español
    public String translateDocument(String document) {
        StringBuilder translatedDocument = new StringBuilder();
        String[] words = document.split("\\s+");
        for (String word : words) {
            String translation = translateWord(word);
            translatedDocument.append(translation).append(" ");
        }
        return translatedDocument.toString().trim();
    }

    // Método auxiliar para traducir una palabra del documento
    private String translateWord(String word) {
        Association<String, String> association = new Association<>(word.toLowerCase(), "");
        boolean found = dictionary.search(association);
        if (found) {
            return association.getValue();
        } else {
            return "*" + word + "*";
        }
    }

    // Pruebas unitarias para insertar un elemento en el árbol
    public void testInsertion() {
        Association<String, String> association = new Association<>("test", "prueba");
        dictionary.insert(association);
        if (!dictionary.search(association)) {
            System.out.println("Error: no se insertó correctamente el elemento.");
        } else {
            System.out.println("La inserción del elemento fue exitosa.");
        }
    }

    // Pruebas unitarias para buscar un elemento en el árbol
    public void testSearch() {
        Association<String, String> association = new Association<>("test", "prueba");
        dictionary.insert(association);
        if (!dictionary.search(association)) {
            System.out.println("Error: no se encontró el elemento insertado.");
        } else {
            System.out.println("La búsqueda del elemento fue exitosa.");
        }
    }
}
