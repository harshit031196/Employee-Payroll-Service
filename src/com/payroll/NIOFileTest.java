package com.payroll;

import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.IntStream;

import org.junit.Test;

public class NIOFileTest {

	private static String HOME = System.getProperty("user.home");
	private static String PLAY_WITH_NIO = "temp_play_ground";
	
	@Test
	public void givenPathWhenCheckedThenConfirmUC1() throws IOException {
		
		Path path = Paths.get(HOME);
		assertTrue(Files.exists(path));
		
		Path playPath = Paths.get(HOME+"/"+PLAY_WITH_NIO);
		if(Files.exists(playPath))
			FileDel.deleteFiles(playPath.toFile());
		assertTrue(Files.notExists(playPath));
		
		Files.createDirectory(playPath);
		assertTrue(Files.exists(playPath));
		
		IntStream.range(1,10).forEach(n->{
			Path tempFile = Paths.get(playPath+"/temp"+n);
			assertTrue(Files.notExists(tempFile));
			try {
				Files.createFile(tempFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
			assertTrue(Files.exists(tempFile));
		});
		
//		Files.newDirectoryStream(playPath).forEach(System.out::println);
//		Files.newDirectoryStream(playPath, path -> path.toFile().isFile() && path.toString().startsWith("temp"))
//				.forEach(System.out::println);
	}

}
