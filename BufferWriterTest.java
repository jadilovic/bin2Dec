package vjezbe;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BufferWriterTest {
	
	public static void main(String[] args) throws IOException {
		
		Path path = Paths.get("scores.txt");
		
		if (!Files.exists(path)) {
			Files.createFile(path);
		}

		BufferedWriter writer = Files.newBufferedWriter(path);
		
		writer.write("Student 1 ");
		writer.write(90 + "");
		
		writer.newLine();
		
		writer.write("Student 2 ");
		writer.write(77 + "");
		
		writer.close();
	}

}
