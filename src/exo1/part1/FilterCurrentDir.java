package exo1.part1;

import exo1.part1.independant.FilterOnlyJavaFile;

import java.io.File;

public class FilterCurrentDir {

    private void recursivePrint(File dir, int step) {
        File[] files = dir.listFiles(new FilterOnlyJavaFile());

        StringBuilder tabs = new StringBuilder();

        for (int i = 0; i < step; i++) {
            tabs.append("\t");
        }

        for (File currentFile : files) {
            System.out.println(tabs + currentFile.toString());

            if(currentFile.isDirectory()) {
                recursivePrint(currentFile, step + 1);
            }
        }
    }

    private void printDir(File dir) {
        recursivePrint(dir, 0);
    }

    public static void main(String[] args) {
        FilterCurrentDir filterCurrentDir = new FilterCurrentDir();
        File currentDir = new File(".");
        filterCurrentDir.printDir(currentDir);
    }

}
