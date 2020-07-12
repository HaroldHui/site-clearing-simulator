package com.shu;

import com.shu.blocks.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        String mapFilePath = args[0];

        try (Stream<String> stream = Files.lines(Paths.get(mapFilePath))) {
            Block[][] blocks = MapReader.read(stream);
            Scanner in = new Scanner(System.in);
            new ConstructionSiteSimulator(blocks, in).start();
        } catch (IOException e) {
            System.out.printf("File not found: %s\n", e.getMessage());
        }

    }
}
