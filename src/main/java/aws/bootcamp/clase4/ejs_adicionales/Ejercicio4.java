package aws.bootcamp.clase4.ejs_adicionales;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
/*
4 - Tome un texto considerablemente largo de alguna página de internet y colóquelo en un String.  Proceda a quitarle los
       simbolos de puntuación (, . ;).  Luego realice un split en base a los espacios en blanco.  Asi obtenemos una arreglo de palabras.
    Procesar dicho arreglo con un stream, quitando los duplicados y clasificando las palabras respecto de su
       dimensión, para lograr algo similar a esto:

        1 letra [5]:
        A
        a
        y
        e
        o

        2 letras [2]:
        de
        un

        3 letras ....
*/
/**
 * Esta dependencia se utiliza para conectarse a la página web
 * "<dependency>
 * <groupId>org.jsoup</groupId>
 * <artifactId>jsoup</artifactId>
 * <version>1.16.1</version>
 * </dependency>";
 */
public class Ejercicio4 {
    public static void main(String[] args) throws IOException {
        String url = "https://vicentemza.github.io/CV_Web/";
        Ejercicio4 process = new Ejercicio4();
        process.start(url);
    }

    /**
     * @param url La URL de la página web a procesar.
     * @throws IOException Si hay algún error al conectarse a la página web o al procesar el texto.
     */
    private void start(String url) {
        try {
            String text = getWebPageText(url);
            List<String> listWords = getWordList(text);
            Map<Integer, List<String>> wordsByDimension = groupWordsByLength(listWords);
            printWordsByDimension(wordsByDimension);
        } catch (IOException e) {
            System.err.println("Error al obtener el texto de la página web: " + e.getMessage());
        }
    }

    /**
     * Obtiene el texto de la página web especificada.
     *
     * @param url La URL de la página web a procesar.
     * @return El texto de la página web.
     * @throws IOException Si hay algún error al conectarse a la página web o al obtener el texto.
     */
    private String getWebPageText(String url) throws IOException {
        Document doc = Jsoup.connect(url).get();
        return doc.text().replaceAll("[,.;]", "");
    }

    /**
     * Obtiene una lista de palabras a partir del texto especificado.
     *
     * @param text El texto a procesar.
     * @return Una lista de palabras.
     */
    private List<String> getWordList(String text) {
        String[] words = text.split("\\s+");
        return Arrays.asList(words);
    }

    /**
     * Agrupa las palabras de la lista especificada por su longitud.
     *
     * @param listWords La lista de palabras a agrupar.
     * @return Un mapa que contiene las palabras agrupadas por su longitud.
     */
    private Map<Integer, List<String>> groupWordsByLength(List<String> listWords) {
        return listWords.stream()
                .distinct()
                .collect(Collectors.groupingBy(String::length));
    }

    /**
     * Imprime las palabras agrupadas por su longitud.
     *
     * @param wordsByDimension Un mapa que contiene las palabras agrupadas por su longitud.
     */
    private void printWordsByDimension(Map<Integer, List<String>> wordsByDimension) {
        wordsByDimension.forEach((dimension, list) -> {
            System.out.println("\n" + dimension + " letras [" + list.size() + "]:");
            list.forEach(System.out::println);
        });
    }
}