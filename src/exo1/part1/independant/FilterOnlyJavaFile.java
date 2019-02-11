package exo1.part1.independant;

import java.io.File;
import java.io.FilenameFilter;

public class FilterOnlyJavaFile implements FilenameFilter {
    @Override
    public boolean accept(File dir, String name) {
        File file = new File(dir.getAbsolutePath() + "/" + name);
        return name.endsWith(".java") || file.isDirectory();
    }
}
