package ru.vavilon.utils;

import org.apache.poi.poifs.filesystem.DirectoryNode;
import org.apache.poi.poifs.filesystem.DocumentInputStream;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import ru.vavilon.reader.ReadDocumentNode;
import ru.vavilon.reader.ReadFile;

import java.io.IOException;

public class ReadMaterialTree {

    public static void main(String[] args) throws IOException, DocumentException {

        ReadDocumentNode readDocumentNode = new ReadDocumentNode();

        POIFSFileSystem poifsFileSystem = new ReadFile().getPoiFSFileSystem("/path/to/file");

        DirectoryNode swXmlContentsDir = (DirectoryNode) poifsFileSystem.getRoot().getEntry("swXmlContents");

        DocumentInputStream dis = readDocumentNode.getDocumentInputStream(swXmlContentsDir, "MATERIALTREE");

        SAXReader reader = new SAXReader();
        Document document = reader.read(dis);

        //logic read xml
        Element root = document.getRootElement();
    }


}