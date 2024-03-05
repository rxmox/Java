/*
 * Version: student test
*/


package edu.ucalgary.oop;

import static org.junit.Assert.*;
import org.junit.Test;

public class Quiz2v2Test {


    /**
     * Tests that Willow inherits from Plant.
     */
    @Test
    public void testInheritance() {
        Willow willow = new Willow("Black Willow", new String[]{"4a", "4b"}, "Water regularly", 10, 5);
        assertTrue("Willow should inherit from Plant", willow instanceof Plant);
    }


    /**
     * Tests that the displaySpecifications method is implemented in Willow
     */
    @Test
    public void testDisplaySpecificationsImplementation() {
        assertTrue("Willow should implement DisplaySpecifications interface.",
                DisplaySpecifications.class.isAssignableFrom(Willow.class));
    }


    /**
     * Tests that the displaySpecifications method returns the expected string format.
     */
    @Test
    public void testDisplaySpecifications() {
        Willow willow = new Willow("Example Plant", new String[]{"1a", "2b", "5a"}, "Water regularly, keep in sunlight", 10, 5);
        String expected = "Example Plant\nZone: 1a, 2b, 5a\nCare:\nWater regularly, keep in sunlight";
        assertEquals("Display specifications should match expected format", expected, willow.displaySpecifications("Example Plant", new String[]{"1a", "2b", "5a"}, "Water regularly, keep in sunlight"));
    }


    /**
     * Tests the setter methods in the Plant class.
     */
    @Test
    public void testInheritedSetters() {
        Willow willow = new Willow("Weeping Willow", new String[]{"4a", "4b"}, "Water regularly", 10, 5);

        // Test setCommonName
        willow.setCommonName("Babylon Willow");
        assertEquals("Common name should be updated", "Babylon Willow", willow.getCommonName());

        // Test setClimateZones
        willow.setClimateZones(new String[]{"1a", "2b", "1b"});
        assertArrayEquals("Climate zones should be updated", new String[]{"1a", "2b", "1b"}, willow.getClimateZones());
    }


    /**
     * Tests the setter methods in the Willow class.
     */
    public void testSetters() {
        Willow willow = new Willow("Weeping Willow", new String[]{"4a", "4b"}, "Water regularly", 10, 5);

        // Test setCareInstructions
        willow.setCareInstructions("Fertilize monthly");
        assertEquals("Care instructions should be updated", "Fertilize monthly", willow.getCareInstructions());

        // Test setHeight
        willow.setHeight(15);
        assertEquals("Height should be updated", 15, willow.getHeight());

        // Test setAge
        willow.setAge(8);
        assertEquals("Age should be updated", 8, willow.getAge());
    }


    /**
     * Tests that climate zones are normalized to lowercase.
     */
    @Test
    public void testZonesNormalization() {
        Willow willow = new Willow("Dappled Willow", new String[]{"4A", "10B"}, "Water regularly", 10, 5);
        
        // Add a new zone with uppercase letters
        willow.addClimateZone("5B");

        // Ensure that climate zones are normalized to lowercase and invalid characters are filtered out
        assertArrayEquals("Climate zones should be normalized to lowercase and invalid characters filtered out when adding a new zone",
                          new String[]{"4a", "10b", "5b"}, willow.getClimateZones());
    }

    /**
     * Tests the removeClimateZone method with invalid zone to be removed.
     */
    @Test
    public void testRemoveZoneInvalidInput() {
        Willow willow = new Willow("Purple Osier Willow", new String[]{"4a", "4b", "10a"}, "Water regularly", 10, 5);
        assertFalse("Removing non-existent zone should return false", willow.removeClimateZone("InvalidZone"));
        assertArrayEquals("Climate zones should remain unchanged", new String[]{"4a", "4b", "10a"}, willow.getClimateZones());
    }

    /**
     * Tests that trying to remove a zone that isn't one of the plant's climate zones returns false.
     */
    @Test
    public void testRemoveNonExistentZone() {
        Willow willow = new Willow("Dappled Willow", new String[]{"4a", "4b", "10a"}, "Water regularly", 10, 5);
        assertFalse("Removing non-existent zone should return false", willow.removeClimateZone("6b"));
        assertArrayEquals("Climate zones should remain unchanged", new String[]{"4a", "4b", "10a"}, willow.getClimateZones());
    }

    /**
     * Tests that an age outside of the range 1-100 (inclusive) throws an IllegalArgumentException.
     */
    @Test
    public void testOutOfRangeAgeBelow() {
        try {
            new Willow("Purple Osier Willow", new String[]{"4a", "4b"}, "Water regularly", 10, -1);
            fail("Expected IllegalArgumentException was not thrown.");
        } catch (IllegalArgumentException e) {
            assertEquals("Wrong exception type thrown.", IllegalArgumentException.class, e.getClass());
        } catch (Exception e) {
            fail("Unexpected exception was thrown: " + e.getClass().getName());
        }
    }

    /**
     * Tests that an age outside of the range 1-100 (inclusive) throws an IllegalArgumentException.
     */
    @Test
    public void testOutOfRangeAgeAbove() {
        try {
            new Willow("Purple Osier Willow", new String[]{"4a", "4b"}, "Water regularly", 10, 101);
            fail("Expected IllegalArgumentException was not thrown.");
        } catch (IllegalArgumentException e) {
            assertEquals("Wrong exception type thrown.", IllegalArgumentException.class, e.getClass());
        } catch (Exception e) {
            fail("Unexpected exception was thrown: " + e.getClass().getName());
        }
    }


    /**
     * Tests the constructor with default common name and specified zones.
     */
    @Test
    public void testConstructorWithDefaultCommonNameAndSpecifiedZones() {
        Willow willow = new Willow(new String[]{"1a", "2b", "3b"}, "Water regularly", 10, 5);
        assertEquals("Default common name should be used", "Weeping Willow", willow.getCommonName());
        assertArrayEquals("Climate zones should be set as specified", new String[]{"1a", "2b", "3b"}, willow.getClimateZones());
        assertEquals("Care instructions should be set as specified", "Water regularly", willow.getCareInstructions());
        assertEquals("Height should be set as specified", 10, willow.getHeight());
        assertEquals("Age should be set as specified", 5, willow.getAge());
    }

    /**
     * Tests the constructor with specified common name and default zones.
     */
    @Test
    public void testConstructorWithSpecifiedCommonNameAndDefaultZones() {
        Willow willow = new Willow("Custom Willow", "Water regularly", 10, 5);
        assertEquals("Common name should be set as specified", "Custom Willow", willow.getCommonName());
        assertArrayEquals("Default climate zones should be used", new String[]{"4a", "4b", "10a"}, willow.getClimateZones());
        assertEquals("Care instructions should be set as specified", "Water regularly", willow.getCareInstructions());
        assertEquals("Height should be set as specified", 10, willow.getHeight());
        assertEquals("Age should be set as specified", 5, willow.getAge());
    }

   
    /**
     * Tests the constructor with default common name and default zones.
     */
    @Test
    public void testConstructorWithDefaultCommonNameAndDefaultZones() {
        Willow willow = new Willow("Water regularly", 10, 5);
        assertEquals("Common name should be set to default", "Weeping Willow", willow.getCommonName());
        assertArrayEquals("Default climate zones should be used", new String[]{"4a", "4b", "10a"}, willow.getClimateZones());
    }

    /**
     * Tests the constructor with no defaults
     */
    @Test
    public void testConstructorWithNoDefaults() {
        Willow willow = new Willow("Custom Willow", new String[]{"10b"}, "Water regularly", 10, 5);
        assertEquals("Common name should be set as specified", "Custom Willow", willow.getCommonName());
        assertArrayEquals("Specified climate zones should be used", new String[]{"10b"}, willow.getClimateZones());
    }


    /**
     * Tests that displaySpecifications method returns approximately the right result (ignores whitespace).
     */
    public void testDisplaySpecificationsApproximate() {
        Willow willow = new Willow("Weeping Willow", new String[]{"4a", "4b"}, "Water regularly", 10, 5);
        String expected = "WeepingWillowZone:4a,4bCare:WaterregularlyHeight:10Age:5";
        String actual = willow.displaySpecifications("Weeping Willow", new String[]{"4a", "4b"}, "Water regularly");
    
        // Remove all whitespace from the actual value using a regular expression
        actual = actual.replaceAll("\\s", "");

        assertEquals("Display specifications should match approximately", expected, actual);
    }


    /**
     * Tests the addClimateZone and removeClimateZone methods.
     */
    @Test
    public void testAddAndRemoveZone() {
        Willow willow = new Willow("Weeping Willow", new String[]{"4a"}, "Water regularly", 10, 5);

        // Add a new zone
        willow.addClimateZone("10a");

        // Remove the initial zone
        willow.removeClimateZone("4a");
        assertArrayEquals("Removed zone should be gone and remaining zones shifted", new String[]{"10a"}, willow.getClimateZones());
    }


    /**
     * Tests adding a new zone when the zone array is full.
     * Expects the method to return false.
     */
    @Test
    public void testAddZoneWhenArrayIsFull() {
        // Create a willow with a full zone array
        Willow willow = new Willow("Weeping Willow", new String[]{"12b", "13a", "13b"}, "Water regularly", 10, 5);
    
        // Try adding a new zone
        assertFalse("Adding a new zone should return false when the array is full", willow.addClimateZone("1a"));
        assertArrayEquals("Climate zones should remain unchanged", 
                          new String[]{"12b", "13a", "13b"}, willow.getClimateZones());
    }

}
