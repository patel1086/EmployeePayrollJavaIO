package com.bridgelabz.fileIO;

import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Test;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.*;
import java.nio.file.*;

import org.junit.Assert;

public class NIOFileAPITest {
	public static String HOME = System.getProperty("user.home");
	public static String PLAY_WITH_NIO = "TempPlayGround";

	@Test
	public void givenPathWhenCheckedThenConfirm() throws IOException {
		Path homePath = Paths.get(HOME);
		Assert.assertTrue(Files.exists(homePath));
	}

	@Test
	public void givenNonexistentPath_whenConfirmsFileNotExists_thenCorrect() throws IOException {
		String fileName = "myfile_151020.txt";
		Path p = Paths.get(HOME + "/" + fileName);
		Files.createFile(p); // files create
		Assert.assertTrue(Files.exists(p));
	}

	@Test
	public void givenDirPath_whenCreatesNewDir_thenCorrect() throws IOException {
		String dirName = "BridgeLabz_Dir";
		Path p = Paths.get(HOME + "/" + dirName);
		Files.createDirectory(p); // directory Create
		Assert.assertTrue(Files.isDirectory(p));
	}
}
