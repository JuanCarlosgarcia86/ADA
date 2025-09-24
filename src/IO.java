import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class IO {
    public static void main(String[] args) {
        //buscar las lineas que contiene ada.
       /* try (Stream<String> stream = Files.lines(Path.of("files/ada2"))) {
            stream
            .filter(s -> s.contains("ada"))
                    .forEach(System.out::println);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //buscar las lineas que tiene digitos.
        try (Stream<String> stream = Files.lines(Path.of("files/ada2"))) {
            stream
                    .filter(s -> s.matches(".*[0-9].*"))
                    .forEach(System.out::println);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/
        //buscar las lineas que tiene digitos y convertilas los numero en puntos


        try (Stream<String> stream = Files.lines(Path.of("files/ada.txt"))) {
            stream
                    .flatMap(lineas -> Arrays.stream(lineas.split(" ")))
                    .filter(s -> s.matches("\\w{3}"))
                    //.map(s -> 2) cambia el contenido entero.
                    .forEach(System.out::println);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Pattern p = Pattern.compile("\\s");
        try (Stream<String> stream = Files.lines(Path.of("files/ada.txt"))) {
            long preposiciones= stream
                    .flatMap(lineas -> p.splitAsStream(lineas))
                    .filter(words -> words.length() <=3)
                    //.map(s -> 2) cambia el contenido entero.
                    .count();
            System.out.println(preposiciones);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        Pattern p = Pattern.compile("\\s");
        try (Stream<String> stream = Files.lines(Path.of("files/ada.txt"))) {
            long preposiciones= stream
                    .flatMap(lineas -> p.splitAsStream(lineas))
                    .filter(words -> words.length() <=3)
                    //.map(s -> 2) cambia el contenido entero.
                    .mapToInt(word -> Integer.parseInt(word))
                    .sum();
            System.out.println(preposiciones);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //contar con un map
        Map<String,Integer> conteo = new HashMap();
        conteo.put("java",
                conteo.getOrDefault("java",0)+1);

        // cuantos numero hay.
        Pattern p = Pattern.compile("\\s");
        try (Stream<String> stream = Files.lines(Path.of("files/ada.txt"))) {
            long preposiciones= stream
                    .flatMap(lineas -> p.splitAsStream(lineas))
                    .filter(words -> words.length() <=3)
                    //.map(s -> 2) cambia el contenido entero.
                    .mapToInt(word -> Integer.parseInt(word));

            System.out.println(preposiciones);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
