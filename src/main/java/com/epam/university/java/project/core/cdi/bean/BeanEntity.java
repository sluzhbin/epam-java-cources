package com.epam.university.java.project.core.cdi.bean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Collection;

@XmlRootElement(name = "beans")
@XmlAccessorType(XmlAccessType.FIELD)
public class BeanEntity {

    @XmlElement(name = "bean", type = BeanDefinitionImpl.class)

    private Collection<BeanDefinition> beans = new ArrayList<>();

    /**
     * Get the beans collection.
     *
     * @return collection of beans
     */
    public Collection<BeanDefinition> getBeans() {
        return beans;
    }

    /**
     * Set the beans list.
     *
     * @param beansList list of beans
     */
    public void setBeans(Collection<BeanDefinition> beansList) {
        this.beans = beansList;
    }
}
