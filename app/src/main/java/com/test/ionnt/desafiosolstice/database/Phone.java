
package com.test.ionnt.desafiosolstice.database;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Phone implements Serializable {

    private String work;
    private String home;
    private String mobile;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
