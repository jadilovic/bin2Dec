package vjezbe;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

public class FilePaths {

	public static void main(String[] args) throws IOException {

		Path path = Paths.get("test.txt");
		Files.createFile(path);

		System.out.println("Da li fajl postoji? " + Files.exists(path));
		System.out.println("Velicina fajla " + Files.size(path) + " bajta.");
		System.out.println("Da li fajl moze biti procitan? " + Files.isReadable(path));
		System.out.println("Da li u fajl mozete pisati? " + Files.isWritable(path));
		System.out.println("Da li je direktorij? " + Files.isDirectory(path));
		System.out.println("Da li je fajl? " + Files.isRegularFile(path));
		System.out.println("Da li je skriven fajl? " + Files.isHidden(path));
		System.out.println("Da li je path apsolutan? " + path.isAbsolute());
		System.out.println("Apsolutni path: " + path.toAbsolutePath());
		System.out.println(
				"Kada je fajl zadnji put modifikovan? " + new Date(Files.getLastModifiedTime(path).toMillis()));

	}

}
