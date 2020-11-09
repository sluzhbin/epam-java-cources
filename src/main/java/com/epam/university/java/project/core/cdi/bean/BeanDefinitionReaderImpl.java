package com.epam.university.java.project.core.cdi.bean;

import com.epam.university.java.project.core.cdi.io.Resource;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.Collection;

public class BeanDefinitionReaderImpl implements BeanDefinitionReader {

    private final BeanDefinitionRegistry registry;

    public BeanDefinitionReaderImpl(BeanDefinitionRegistry registry) {
        this.registry = registry;
    }

    /**
     * Load bean definitions from designated resource.
     *
     * @param resource resource instance
     * @return amount of loaded definitions
     */
    @Override
    public int loadBeanDefinitions(Resource resource) {
        try {
            JAXBContext context = JAXBContext.newInstance(BeanEntity.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            File file = resource.getFile();
            BeanEntity beans = (BeanEntity) unmarshaller.unmarshal(file);

            BeanDefinitionRegistryImpl reg = (BeanDefinitionRegistryImpl) registry;
            reg.setCollection(beans);
            return beans.getBeans().size();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * Load bean definitions from collection of resources.
     *
     * @param resources collection of resources
     * @return amount of loaded definitions
     */
    @Override
    public int loadBeanDefinitions(Collection<Resource> resources) {
        int numOfBeans = 0;
        for (Resource resource : resources) {
            numOfBeans += loadBeanDefinitions(resource);
        }
        return numOfBeans;
    }
}

