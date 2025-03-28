package com.techprimers.sessionmgmt;

import com.thoughtworks.xstream.XStream;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.json.AbstractJsonHttpMessageConverter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;

public class XStreamJsonHttpMessageConverter extends AbstractJsonHttpMessageConverter {

    private XStream xStream;

    public void setXStream(XStream xStream) {
        this.xStream = xStream;
    }

  

    @Override
    protected Object readInternal(Type resolvedType, Reader reader) throws Exception {
        int intValueOfChar;
        String targetString = "";
        while ((intValueOfChar = reader.read()) != -1) {
            targetString += (char) intValueOfChar;
        }
        reader.close();

         // Utilizza XStream per deserializzare JSON in un oggetto
         return xStream.fromXML(targetString);  // Legge il flusso di input JSON e lo converte in oggetto
    }

    @Override
    protected void writeInternal(Object object, Type type, Writer writer) throws Exception {
        // Utilizza XStream per serializzare l'oggetto in JSON
        xStream.toXML(object, writer);  // Scrive l'oggetto in formato JSON
    }

    
}