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
            Map<Long, String> objects = section.getDictionary();
            Property[] properties = section.getProperties();

            Property property;
            for (int i = 0; i < objects.size(); i++) {
                property = properties[i];
                propertyEntry = new PropertyEntry();
                propertyEntry.setKey(objects.get(property.getID()));
                propertyEntry.setValue(property.getValue().toString());
                propertyEntry.setIndex(i);
                propertyEntry.setType(property.getType());
                propertyEntry.setDocumentName(docName);
                result.add(propertyEntry);
            }
        }

        return result;
    }
}
