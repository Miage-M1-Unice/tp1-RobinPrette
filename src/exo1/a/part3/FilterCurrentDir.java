package exo1.a.part3;

import java.io.File;
import java.io.FilenameFilter;

public class FilterCurrentDir {

    private void recursivePrint(File dir, int step, FilenameFilter filter) {
        File[] files = dir.listFiles(filter);

        StringBuilder tabs = new StringBuilder();

        for (int i = 0; i < step; i++) {
            tabs.append("\t");
        }

        for (File currentFile : files) {
            System.out.println(tabs + currentFile.toString());

            if(currentFile.isDirectory()) {
                recursivePrint(currentFile, step + 1, filter);
            }
        }
    }

    private FilenameFilter filter = new FilenameFilter() {
        @Override
        public boolean accept(File dir, String name) {
            File file = new File(dir.getAbsolutePath() + "/" + name);
            return name.endsWith(".java") || file.isDirectory();
        }
    };

    private void printDir(File dir, FilenameFilter filter) {
        recursivePrint(dir, 0, filter);
    }

    public static void main(String[] args) {
        FilterCurrentDir filterCurrentDir = new FilterCurrentDir();
        File currentDir = new File(".");

        filterCurrentDir.printDir(currentDir, filterCurrentDir.filter);
    }

}
