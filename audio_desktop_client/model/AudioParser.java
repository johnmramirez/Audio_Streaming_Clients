package model;

import java.io.IOException;
import java.io.InputStream;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.SAXException;

public class AudioParser {

    public String[] getMetaData(InputStream audioFile) throws IOException, SAXException, TikaException{
        AutoDetectParser parser = new AutoDetectParser();
        BodyContentHandler handler = new BodyContentHandler();
        Metadata metadata = new Metadata();
        try (InputStream stream = audioFile) {
            parser.parse(stream, handler, metadata);
            System.out.println(metadata.toString());
        }
        return null;
    }
    
}
