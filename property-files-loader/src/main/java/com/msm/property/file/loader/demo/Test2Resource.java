package com.msm.property.file.loader.demo;

import com.msm.property.file.loader.annotations.PropertiesResource;
import com.msm.property.file.loader.annotations.PropertyName;

/**
 * @author riste.jovanoski
 * @since 6/13/2017
 */
@PropertiesResource("test2.properties")
public class Test2Resource {
    @PropertyName("resource.property.1")
    private String property1;
    @PropertyName("resource.property.2")
    private String property2;
    @PropertyName("resource.property.3")
    private String property3;
    @PropertyName("resource.property.4")
    private String property4;
    @PropertyName("resource.property.5")
    private String property5;

    public String getProperty1() {
        return property1;
    }

    public void setProperty1(String property1) {
        this.property1 = property1;
    }

    public String getProperty2() {
        return property2;
    }

    public void setProperty2(String property2) {
        this.property2 = property2;
    }

    public String getProperty3() {
        return property3;
    }

    public void setProperty3(String property3) {
        this.property3 = property3;
    }

    public String getProperty4() {
        return property4;
    }

    public void setProperty4(String property4) {
        this.property4 = property4;
    }

    public String getProperty5() {
        return property5;
    }

    public void setProperty5(String property5) {
        this.property5 = property5;
    }
}
