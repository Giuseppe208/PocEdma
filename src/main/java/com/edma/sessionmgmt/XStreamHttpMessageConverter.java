package com.edma.sessionmgmt;

import com.thoughtworks.xstream.XStream;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class XStreamHttpMessageConverter extends AbstractHttpMessageConverter<Object> {

    private XStream xStream;

    public XStreamHttpMessageConverter(XStream xStream) {
        super();
        this.xStream = xStream;
        setSupportedMediaTypes(List.of(MediaType.APPLICATION_XML, MediaType.TEXT_XML));
    }

    @Override
    protected boolean supports(Class<?> clazz) {
        return true;  // Supporta tutte le classi
    }

    @Override
    protected Object readInternal(Class<? extends Object> clazz, HttpInputMessage inputMessage) throws IOException {
        String xml = StreamUtils.copyToString(inputMessage.getBody(), StandardCharsets.UTF_8);
        return xStream.fromXML(xml);
    }

    @Override
    protected void writeInternal(Object object, HttpOutputMessage outputMessage) throws IOException {
        String xml = xStream.toXML(object);
        outputMessage.getBody().write(xml.getBytes(StandardCharsets.UTF_8));
    }
}