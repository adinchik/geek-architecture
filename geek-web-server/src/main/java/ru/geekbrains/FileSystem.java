package ru.geekbrains;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileSystem {
    private Path path;

    public boolean isFileExist(String folder, String fileName) {
        this.path = Paths.get(folder, fileName);
        return !Files.exists(path);
    }

    public void transferToOutput(PrintWriter output) throws IOException {
        Files.newBufferedReader(path).transferTo(output);
    }
}
