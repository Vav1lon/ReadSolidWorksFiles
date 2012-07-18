package ru.vavilon.reader;

import org.apache.poi.hpsf.MarkUnsupportedException;
import org.apache.poi.hpsf.NoPropertySetStreamException;
import org.apache.poi.hpsf.PropertySet;
import org.apache.poi.poifs.filesystem.DirectoryNode;
import org.apache.poi.poifs.filesystem.DocumentEntry;
import org.apache.poi.poifs.filesystem.DocumentInputStream;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import java.io.IOException;

public class ReadDocumentNode {


    public DocumentInputStream getDocumentInputStream(DirectoryNode dir, String documentNodeName) throws IOException {
        return new DocumentInputStream((DocumentEntry) dir.getEntry(documentNodeName));
    }

    public PropertySet read(POIFSFileSystem poifsFileSystem, String nameDocument) throws IOException {
        PropertySet ps = null;
        DocumentInputStream dis = poifsFileSystem.createDocumentInputStream(nameDocument);
        try {
            ps = new PropertySet(dis);
        } catch (NoPropertySetStreamException e) {
            e.printStackTrace();
        } catch (MarkUnsupportedException e) {
            e.printStackTrace();
        } finally {
            dis.close();
        }
        return ps;
    }

}
