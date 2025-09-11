import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.function.Consumer;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        File f = new File("files/ada.txt");
        System.out.println(f.isFile());
        boolean exist = f.exists();

        Path ruta = Path.of("files/ada.txt");
        Path ruta2 = Paths.get("files/ada2.txt");

        Files.exists(ruta);
        try {


           // Path nuevo2 = Paths.get("files/nuevo2.txt");

           // Files.createFile(Path.of("files/nuevo.txt"));
            //Files.delete(fileCreated);
           // Files.copy(ruta,Path.of("file/nuevo.txt"));

           // Files.copy(ruta,nuevo2, StandardCopyOption.REPLACE_EXISTING);
           // long tam = Files.size(nuevo2);
           // System.out.println(tam);

            // operaciones con directorios.

           // Path dir = Paths.get("dir/");
           // Path newDir = Files.createDirectories(dir);

           try  (DirectoryStream<Path>  stream=
                    Files.newDirectoryStream(Path.of("files"))){
               Consumer<Path> c = p  -> System.out.println(p);
                stream.forEach(c);

            }

        } catch (IOException e) {
            System.err.println("Error al crear el fichero");
        }




    }

}