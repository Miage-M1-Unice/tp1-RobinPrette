package exo1.c;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FilterCurrentDir implements FileVisitor<Path> {
    private String fileName;
    private Path startDir;

    public FilterCurrentDir(String fileName, Path startDir) {
        this.fileName = fileName;
        this.startDir = startDir;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        String fileN = file.toString();

        Pattern p = Pattern.compile(".*\\.java");
        Matcher m = p.matcher(fileN) ;

        if (m.matches()) {
            System.out.println("File found: " + file);
        }
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    public static void main(String[] args) throws IOException {
        Path startingDir = Paths.get(".");
        String fileToSearch = ".java";
        FilterCurrentDir crawler = new FilterCurrentDir(fileToSearch, startingDir);
        Files.walkFileTree(startingDir, crawler);
    }
}
