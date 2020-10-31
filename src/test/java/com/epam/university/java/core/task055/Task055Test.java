package com.epam.university.java.core.task055;

import com.epam.university.java.core.helper.TestHelper;
import org.junit.Before;
import org.junit.Test;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class Task055Test {
    private Task055 instance;

    @Before
    public void setUp() throws Exception {
        instance = TestHelper.getInstance(Task055.class);
        instance.setInputFile("/task055/livingHousesPassports.xml");
    }

    @Test
    public void findTheOldestHouse() {
        Collection<HouseDefinition> collection = instance.oldestHouses();
        assertEquals("Incorrect length of collection", 2,
                collection.size());
        collection.forEach(houseDefinition -> assertEquals("Incorrect year of oldest houses",
                1728, houseDefinition.getYear()));
        collection.forEach(houseDefinition -> assertNotNull("Incorrect address",
                 houseDefinition.getAddress()));
    }

    @Test
    public void findAverageAge() {
        List<String> districts = List.of("Центральный", "Петроградский",
                "Адмиралтейский", "Василеостровский", "Московский", "Приморский", "Город");
        List<Integer> ages = List.of(133, 100, 137, 90, 55, 37, 70);
        districts.forEach(s -> assertTrue("Incorrect average age",
                instance.averageAge(s) != 0));
        for (int i = 0; i < districts.size(); i++) {
            assertEquals(String.format("Incorrect age for district %s", districts.get(i)),
                    ((int)ages.get(i)),
                    instance.averageAge(districts.get(i)));
        }
    }

    @Test
    public void findBiggestHouse() {
        HouseDefinition hd = instance.biggestTotalFloorSpace();
        assertEquals("Incorrect area of biggest house",
                233074.1, hd.getArea(), 0.0);
        assertNotNull("Incorrect address", hd.getAddress());
    }

    @Test
    public void findSmallestHouse() {
        HouseDefinition hd = instance.smallestTotalFloorSpace();
        assertEquals("Incorrect area of smallest house",
                24.2, hd.getArea(), 0.0);
        assertNotNull("Incorrect address", hd.getAddress());
    }

    @Test
    public void totalHouses() {
        assertEquals("Incorrect count of total houses",
                22771, instance.totalCountHouses());
    }

    @Test
    public void communalHouses() {
        assertEquals("Incorrect count of houses with communal flats",
                13498, instance.totalCountHousesWithCommunalFlats());
    }
}
