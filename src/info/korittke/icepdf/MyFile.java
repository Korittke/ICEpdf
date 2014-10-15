package info.korittke.icepdf;

import java.io.File;

public class MyFile {
    private final File file;
    
    public MyFile(File file) {
        this.file = file;
    }
    
    @Override
    public String toString() {
        return file.getName();
    }

    public String getPath() {
        return file.getAbsolutePath();
    }
}
