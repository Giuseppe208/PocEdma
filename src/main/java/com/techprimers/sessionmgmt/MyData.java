package com.techprimers.sessionmgmt;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MyData {

    private String name;
    private int value;

    public MyData(String name, int value) {
        this.name = name;
        this.value = value;
    }

    @XmlElement
    public String getName() {
        return name;
    }

    @XmlElement
    public int getValue() {
        return value;
    }
}
