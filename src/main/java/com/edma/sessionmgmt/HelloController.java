package com.edma.sessionmgmt;

import java.util.Arrays;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping
    public String hello(HttpSession session) { 
        return "Hello Giuseppe";
    }

    @GetMapping("/write")
    public ResponseEntity<String> writeSession(@RequestParam String key, @RequestParam String value
            , HttpSession session) {
        session.setAttribute(key, value);
        return ResponseEntity.ok("Cart updated!");
    }

    @GetMapping("/read")
    public ResponseEntity<String> readSession(@RequestParam String key, HttpSession session) {
        String data = (String) session.getAttribute(key);
        return ResponseEntity.ok(data);
    }

    @GetMapping("/data")
    public ResponseEntity<Object> getData(@RequestHeader("Accept") String acceptHeader) {
        Customer data = new Customer("Mario", "Rossi", new Date(), "40", Arrays.asList(new DettaglioContatti("3333333333", "mario.rossi@test.it", "Via Roma 1"), new DettaglioContatti("4444444444", "elisabetta@test.it", "Via Milano 2")));
        
        if (acceptHeader.contains("application/xml")) {
            // Risposta in XML
            com.thoughtworks.xstream.XStream xstream = new com.thoughtworks.xstream.XStream();
            String dataXml = xstream.toXML(data); 
            return ResponseEntity.ok()
                                 .header("Content-Type", "application/xml")
                                 .body(dataXml);
        } else {
            // Risposta in JSON
            com.thoughtworks.xstream.XStream xstream = new com.thoughtworks.xstream.XStream(new JettisonMappedXmlDriver());
            String dataJson = xstream.toXML(data); 
            return ResponseEntity.ok()
                                 .header("Content-Type", "application/json")
                                 .body(dataJson);
        }
    }

    @GetMapping("/dataStandard")
    public Customer getData() {
        //return new MyData("Esempio", 123);
        return   new Customer("Mario", "Rossi", new Date(), "40", Arrays.asList(new DettaglioContatti("3333333333", "mario.rossi@test.it", "Via Roma 1"), new DettaglioContatti("4444444444", "elisabetta@test.it", "Via Milano 2")));
    }


     @PostMapping("/findLastByCodice")
    public ResponseEntity<Object> findLastByCodice(@RequestBody Object customer) {
        if(customer!=null && customer instanceof Customer) {
            Customer customerObj = (Customer) customer;
            return ResponseEntity.ok().body(customerObj);
        }else{
            return ResponseEntity.badRequest().body(null);
        }
	}
}
