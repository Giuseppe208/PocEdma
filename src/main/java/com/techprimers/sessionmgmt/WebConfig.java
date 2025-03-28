package com.techprimers.sessionmgmt;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;
import com.thoughtworks.xstream.io.xml.Dom4JDriver;
import com.thoughtworks.xstream.security.WildcardTypePermission;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        

        XStream xStreamJson = new XStream(new JettisonMappedXmlDriver());
        xStreamJson.alias("customer", Customer.class);  // Definisci il tuo alias

        // Permetti esplicitamente la classe Customer
        xStreamJson.addPermission(new WildcardTypePermission(new String[] { "com.techprimers.sessionmgmt.Customer" }));
        xStreamJson.addPermission(new WildcardTypePermission(new String[] { "com.techprimers.sessionmgmt.DettaglioContatti" }));

        // Usa un convertitore personalizzato per JSON
        XStreamJsonHttpMessageConverter jsonConverter = new XStreamJsonHttpMessageConverter();
        jsonConverter.setXStream(xStreamJson);

        // Aggiungi il convertitore alla lista dei convertitori di messaggi
        converters.add(0, jsonConverter);

        XStream xStream = new XStream();
        xStream.alias("customer", Customer.class);  // Definisci il tuo alias

        // Permetti esplicitamente la classe Customer
        xStream.addPermission(new WildcardTypePermission(new String[] { "com.techprimers.sessionmgmt.Customer" }));
        xStream.addPermission(new WildcardTypePermission(new String[] { "com.techprimers.sessionmgmt.DettaglioContatti" }));
        
        // Aggiungi il tuo XStreamHttpMessageConverter
        converters.add(1, new XStreamHttpMessageConverter(xStream));
    }
}