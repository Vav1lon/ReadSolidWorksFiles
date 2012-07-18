package ru.vavilon.utils;

import org.apache.poi.hpsf.DocumentSummaryInformation;
import org.apache.poi.hpsf.PropertySet;
import org.apache.poi.hpsf.SummaryInformation;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import ru.vavilon.entity.PropertyEntry;
import ru.vavilon.reader.ReadDocumentNode;
import ru.vavilon.reader.ReadFile;
import ru.vavilon.reader.ReadPropertySet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadBaseProperty {

    public static void main(String[] args) throws IOException {

        ReadDocumentNode readDocumentNode = new ReadDocumentNode();
        POIFSFileSystem poifsFileSystem = new ReadFile().getPoiFSFileSystem("/path/to/file");

        PropertySet documentSummaryInformation = readDocumentNode.read(poifsFileSystem, DocumentSummaryInformation.DEFAULT_STREAM_NAME);
        PropertySet summaryInformation = readDocumentNode.read(poifsFileSystem, SummaryInformation.DEFAULT_STREAM_NAME);

        ReadPropertySet readPropertySet = new ReadPropertySet();

        List<PropertyEntry> propertyEntryList = new ArrayList<PropertyEntry>();
        propertyEntryList.addAll(readPropertySet.read(documentSummaryInformation, DocumentSummaryInformation.DEFAULT_STREAM_NAME));
        propertyEntryList.addAll(readPropertySet.read(summaryInformation, SummaryInformation.DEFAULT_STREAM_NAME));

        for (PropertyEntry entry : propertyEntryList) {
            System.out.println(entry.getDocumentName() + " / " + entry.getKey() + " / " + entry.getValue());
        }

    }

}
