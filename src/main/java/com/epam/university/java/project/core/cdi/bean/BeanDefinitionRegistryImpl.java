package com.epam.university.java.project.core.cdi.bean;

import java.util.ArrayList;
import java.util.Collection;

public class BeanDefinitionRegistryImpl implements BeanDefinitionRegistry {

    private BeanEntity collection;

    public BeanDefinitionRegistryImpl() {
        collection = new BeanEntity();
    }

    /**
     * Add bean definition to registry.
     *
     * @param definition bean definition object
     */
    @Override
    public void addBeanDefinition(BeanDefinition definition) {
        Collection<BeanDefinition> beans = collection.getBeans();
        beans.add(definition);
    }

    /**
     * Get bean definition by id from registry.
     *
     * @param beanId bean id
     * @return bean definition
     */
    @Override
    public BeanDefinition getBeanDefinition(String beanId) {
        Collection<BeanDefinition> beans = new ArrayList<>(collection.getBeans());
        for (BeanDefinition bean : beans) {
            if (bean.getId().equals(beanId)) {
                return bean;
            }
        }
        return null;
    }

    public BeanEntity getCollection() {
        return collection;
    }

    public void setCollection(BeanEntity collection) {
        this.collection = collection;
    }

}
