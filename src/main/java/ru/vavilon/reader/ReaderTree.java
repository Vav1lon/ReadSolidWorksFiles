package ru.vavilon.reader;

import org.apache.poi.poifs.filesystem.DirectoryNode;
import org.apache.poi.poifs.filesystem.Entry;

import java.util.Iterator;

public class ReaderTree {

    public void readNodeAndWriteToConsoleContains(DirectoryNode node) {
        Iterator<Entry> iterator = node.getEntries();
        readIterator(iterator);
    }

    private void readIterator(Iterator<Entry> iterator) {
        while (iterator.hasNext()) {
            readNode(iterator.next());
        }
    }

    private void readNode(Entry node) {
        if (node.isDocumentEntry()) {
            System.out.println(" == Directory name: " + ((Entry) node.getParent()).getName() + " -- Document: " + node.getName());
        }
        if (node.isDirectoryEntry()) {
            System.out.println("");
            System.out.println(" == Directory name: " + ((Entry) node).getName());
            readIterator(((DirectoryNode) node).getEntries());
            System.out.println("");
        }
    }
}
