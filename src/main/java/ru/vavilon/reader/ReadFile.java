package ru.vavilon.reader;

import org.apache.poi.poifs.filesystem.DirectoryNode;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadFile {

    public DirectoryNode getRootNode(String path) throws IOException {
        FileInputStream fis = new FileInputStream(new File(path));
        POIFSFileSystem poifsFileSystem = new POIFSFileSystem(fis);
        fis.close();
        return poifsFileSystem.getRoot();
    }

    public POIFSFileSystem getPoiFSFileSystem(String path) throws IOException {
        FileInputStream fis = new FileInputStream(new File(path));
        POIFSFileSystem poifsFileSystem = new POIFSFileSystem(fis);
        fis.close();
        return poifsFileSystem;
    }

}
