package com.epam.university.java.project.core.cdi.bean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Collection;

@XmlRootElement(name = "bean")
@XmlAccessorType(XmlAccessType.FIELD)
public class BeanDefinitionImpl implements BeanDefinition {

    @XmlAttribute(name = "id")
    private String id;

    @XmlAttribute(name = "class")
    private String className;

    @XmlElement(name = "property", type = BeanPropertyDefinitionImpl.class)
    private Collection<BeanPropertyDefinition> properties;

    @XmlAttribute(name = "init")
    private String methodName;

    @XmlAttribute(name = "scope")
    private String scope;

    /**
     * Get the bean id.
     * @return id of bean
     */
    @Override
    public String getId() {
        return id;
    }

    /**
     * Set the bean id.
     * @param id id of bean
     */
    @Override
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Get bean class name.
     * @return name of class
     */
    @Override
    public String getClassName() {
        return className;
    }

    /**
     * Set bean class name.
     * @param className name of class
     */
    @Override
    public void setClassName(String className) {
        this.className = className;
    }

    /**
     * Get bean properties.
     * @return collection of bean properties
     */
    @Override
    public Collection<BeanPropertyDefinition> getProperties() {
        return properties;
    }

    /**
     * Set bean properties.
     * @param properties collection of bean properties
     */
    @Override
    public void setProperties(Collection<BeanPropertyDefinition> properties) {
        this.properties = properties;
    }

    /**
     * Get method name which is called after bean created and dependencies injected.
     * @return method name
     */
    @Override
    public String getPostConstruct() {
        return methodName;
    }

    /**
     * Set post-construct method name.
     * @param methodName method name
     */
    @Override
    public void setPostConstruct(String methodName) {
        this.methodName = methodName;
    }

    /**
     * Get the bean scope.
     * @return bean scope
     */
    @Override
    public String getScope() {
        return scope;
    }

    /**
     * Set the bean scope.
     * @param scope bean scope
     */
    @Override
    public void setScope(String scope) {
        this.scope = scope;
    }
}
