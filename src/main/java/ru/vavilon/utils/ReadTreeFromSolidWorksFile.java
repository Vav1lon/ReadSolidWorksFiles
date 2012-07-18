package ru.vavilon.utils;

import org.apache.poi.poifs.filesystem.DirectoryNode;
import ru.vavilon.reader.ReadFile;
import ru.vavilon.reader.ReaderTree;

import java.io.IOException;

public class ReadTreeFromSolidWorksFile {

    public static void main(String[] args) {

        try {
            ReaderTree readerTree = new ReaderTree();
            DirectoryNode rootNode = new ReadFile().getRootNode("/path/to/file");
            readerTree.readNodeAndWriteToConsoleContains(rootNode);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
