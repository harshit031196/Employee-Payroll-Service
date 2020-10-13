package com.payroll;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.IntStream;

import org.junit.Test;

public class WatchServiceTest {

	private static String HOME = System.getProperty("user.home");
	private static String PLAY_WITH_NIO = "temp_play_ground";
	@Test
	public void createTempDirectory() throws IOException {
		Path playPath = Paths.get(HOME + "/" + PLAY_WITH_NIO);
		Files.createDirectory(playPath);
		assert (Files.exists(playPath));
		IntStream.range(1, 10).forEach(cntr -> {
			Path tempFile = Paths.get(HOME + "/" + PLAY_WITH_NIO + "/temp" + cntr);
			assertTrue(Files.notExists(tempFile));
			try {
				Files.createFile(tempFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
			assertTrue(Files.exists(tempFile));
		});
	}
	@Test
	public void givenADirectoryWhenWatchedListsAllTheActivities() throws IOException {
		Path dir = Paths.get(HOME + "/" + PLAY_WITH_NIO);
		Files.list(dir).filter(Files::isRegularFile).forEach(System.out::println);
		new JavaWatchServiceExample(dir).processEvents();
	}
}
