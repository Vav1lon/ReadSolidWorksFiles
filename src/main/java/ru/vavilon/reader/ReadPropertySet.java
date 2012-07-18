package ru.vavilon.reader;

import org.apache.poi.hpsf.Property;
import org.apache.poi.hpsf.PropertySet;
import org.apache.poi.hpsf.Section;
import ru.vavilon.entity.PropertyEntry;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReadPropertySet {


    public List<PropertyEntry> read(PropertySet propertySet, String docName) {

        List<PropertyEntry> result = new ArrayList<PropertyEntry>();

        PropertyEntry propertyEntry;
        for (Section section : propertySet.getSections()) {
            Object[] objects = section.getDictionary().entrySet().toArray();
            Property[] properties = section.getProperties();

            for (int i = 0; i < objects.length; i++) {
                propertyEntry = new PropertyEntry();
                propertyEntry.setKey(((Map.Entry) objects[i]).getValue().toString());
                propertyEntry.setValue(properties[i].getValue().toString());
                propertyEntry.setIndex(i);
                propertyEntry.setDocumentName(docName);

                result.add(propertyEntry);
            }
        }

        return result;
    }
}
