package exo1.a.part4;

import java.io.File;
import java.io.FilenameFilter;

public class FilterCurrentDir {

    private void recursivePrint(File dir, int step) {
        FilenameFilter filter = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                File file = new File(dir.getAbsolutePath() + "/" + name);
                return name.endsWith(".java") || file.isDirectory();
            }
        };

        File[] files = dir.listFiles(filter);

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
