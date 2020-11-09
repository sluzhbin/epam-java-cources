package com.epam.university.java.project.core.cdi.bean;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;
import java.util.Objects;

public class BeanFactoryImpl implements BeanFactory {

    private BeanDefinitionRegistry registry;
    private Map<Class<?>, Object> singletonMap = new HashMap<>();
    private BeanPropertySetter setter;

    public BeanFactoryImpl(BeanDefinitionRegistry registry) {
        this.registry = registry;
        this.setter = new BeanPropertySetter(this);
    }

    /**
     * Get bean instances by class.
     *
     * @param beanClass bean class to get
     * @return bean instance
     */
    @Override
    @SuppressWarnings("unchecked")
    public <T> T getBean(Class<T> beanClass) {
        BeanDefinitionRegistryImpl reg = (BeanDefinitionRegistryImpl) registry;
        Collection<BeanDefinition> beans = reg.getCollection().getBeans();
        for (BeanDefinition bean : beans) {
            Class<?> clazz = null;
            try {
                clazz = Class.forName(bean.getClassName());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            Class<?>[] interfaces = clazz.getInterfaces();
            if (clazz.equals(beanClass) || Arrays.asList(interfaces).contains(beanClass)) {
                return (T) getBean(bean.getId());
            }
        }
        return null;
    }

    /**
     * Get bean instance by  definition name.
     *
     * @param beanName bean definition name
     * @return bean instance
     */
    @Override
    public Object getBean(String beanName) {
        BeanDefinition beanDefinition = registry.getBeanDefinition(beanName);
        Class<?> beanClass = null;
        try {
            beanClass = Class.forName(beanDefinition.getClassName());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException();
        }
        if (singletonMap.containsKey(beanClass)) {
            return singletonMap.get(beanClass);
        }
        Object bean = null;
        try {
            bean = Objects.requireNonNull(beanClass).getConstructor().newInstance();
            Collection<BeanPropertyDefinition> properties = beanDefinition.getProperties();
            if (properties != null && properties.size() > 0) {
                for (BeanPropertyDefinition property : properties) {
                    Field field = beanClass.getDeclaredField(property.getName());
                    if (property.getRef() != null) {
                        setter.setReference(bean, field, property);
                    } else if (property.getData() == null) {
                        setter.setValue(bean, field, property);
                    } else if (property.getData() != null) {
                        setter.setData(bean, field, property);
                    }
                }
            }
            if (beanDefinition.getPostConstruct() != null) {
                beanClass.getMethod(beanDefinition.getPostConstruct()).invoke(bean);
            }
            if (beanDefinition.getScope() != null
                    && beanDefinition.getScope().equals("singleton")) {
                singletonMap.put(beanClass, bean);
            }
        } catch (ReflectiveOperationException e) {
            System.err.println("Something gone wrong with reflection!");
            e.printStackTrace();
        }
        return bean;
    }

    /**
     * Get bean instance by definition name and target class.
     *
     * @param beanName  bean definition name
     * @param beanClass target bean class
     * @return bean instance
     */
    @Override
    @SuppressWarnings("unchecked")
    public <T> T getBean(String beanName, Class<T> beanClass) {
        return (T) getBean(beanName);
    }
}
