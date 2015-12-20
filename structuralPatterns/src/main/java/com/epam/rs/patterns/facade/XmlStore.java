package com.epam.rs.patterns.facade;

import com.epam.rs.AppUtils;
import com.epam.rs.data.Record;
import com.epam.rs.data.Records;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by catmo_000 on 12/20/2015.
 */
public class XmlStore implements Store<Record> {
    private Records records;
    private final String fileName;
    private final static Marshaller MARSHALLER;
    private final static Unmarshaller UNMARSHALLER;

    static {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Records.class);
            MARSHALLER = jaxbContext.createMarshaller();
            UNMARSHALLER = jaxbContext.createUnmarshaller();
            MARSHALLER.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    public XmlStore() {
        this.fileName = AppUtils.getProperty("xml");
    }

    public List<Record> getAll() {
        try {
            records = (Records) UNMARSHALLER.unmarshal(new File(AppUtils.getResource(fileName)));
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
        final Set<Record> records = this.records.getRecords();
        final List<Record> list = new ArrayList<>(records.size());
        records.stream().forEach(x -> list.add(new Record(x)));
        return list;
    }

    public void add(Record object) {
        records.getRecords().add(object);
    }

    public void remove(long id) {
        records.getRecords().removeIf(x -> x.getId() == id);
    }

    protected final void save() {
        try {
            MARSHALLER.marshal(records, new File(AppUtils.getResource(fileName)));
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }
}
