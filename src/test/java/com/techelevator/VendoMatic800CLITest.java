package com.techelevator;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertArrayEquals;

public class VendoMatic800CLITest {

    private static final String OUT_FILE_PATH = "src/test/resources/out.txt";

    @AfterClass
    public static void afterClass() throws Exception {
        File outFile = new File(OUT_FILE_PATH);
        if(outFile.exists()) {
            outFile.delete();
        }
    }

    @Test
    public void machine_test() throws IOException {
        String userInput = concatWithNewLineFeed("3");
        File outFile = new File(OUT_FILE_PATH);
        PrintStream printStream = new PrintStream(outFile);
        System.setOut(printStream);
        System.setIn(new ByteArrayInputStream(userInput.getBytes()));
        VendoMatic800CLI.main(null);

        List<String> lines = Files.readAllLines(outFile.toPath());
        List<String> actual = new ArrayList<>(lines);
        printStream.close();

        List<String> expected = List.of(
                "##########################################",
                "##### WELCOME TO THE VENDO-MATIC-800 #####",
                "##########################################",
                "",
                "############### MAIN MENU ################",
                "",
                "(1) Display Vending Machine Items",
                "(2) Purchase",
                "(3) Exit",
                "",
                "Please choose an option >>> ");

        for (String line : actual) {
            System.out.println(line);
        }

        assertArrayEquals(expected.toArray(),actual.toArray());
    }

    private String concatWithNewLineFeed(String ...inputs) {
        String userInput = "";
        for(String s : inputs) {
            userInput += s + System.lineSeparator();
        }
        return userInput;
    }

}
