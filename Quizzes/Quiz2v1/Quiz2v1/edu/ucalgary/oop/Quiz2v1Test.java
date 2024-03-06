/*
 * Version: student test
*/

//package edu.ucalgary.oop;

import static org.junit.Assert.*;
import org.junit.*;
import java.util.Arrays;

public class Quiz2v1Test {

    // CustomGarmentProduction should implement DisplaySpecifications
    @Test
    public void testDisplaySpecificationsImplementation() {
        assertTrue("CustomGarmentProduction should implement DisplaySpecifications interface.",
                DisplaySpecifications.class.isAssignableFrom(CustomGarmentProduction.class));
    }


    // CustomGarmentProduction should inherit from Fabric
    @Test
    public void testCustomGarmentProductionInheritsFromFabric() {
        String fabric = "wool";
        String garmentCode = "ABC123";
        char size = 'M';
        CustomGarmentProduction garment = new CustomGarmentProduction(fabric, garmentCode, size);
        assertTrue("CustomGarmentProduction does not inherit from Fabric",
          (garment instanceof Fabric));
    }


    // addFabricType should normalize input to lower case
    // It should not throw an exception
    @Test
    public void testAddFabricTypeWithMixedCase() {
        String fabric = "wool";
        String garmentCode = "ABC123";
        char size = 'M';
        CustomGarmentProduction garment = new CustomGarmentProduction(fabric, garmentCode, size);

        try {
            garment.addFabricType("SiLk");
        } catch (Exception e) {
            fail("Adding fabric type with valid name but incorrect capitalization should not throw an exception.");
        }

        String[] fabrics = garment.getFabricTypes();
        assertTrue("Fabric type should be added as lowercase.", fabrics[1].equals("silk"));
    }


    // formatOrder should format text as shown here
    @Test
    public void testFormatOrder() {
        String[] fabrics = {"silk", "cotton"};
        String garmentCode = "ABC123";
        char size = 'M';
        String expectedOutput = "Garment Code: ABC123\nSize: M\nFabrics: silk, cotton";

        String actualOutput = DisplaySpecifications.formatOrder(fabrics, garmentCode, size);

        assertEquals("Formatted order does not match expected value.", expectedOutput, actualOutput);
    }


    // The built-in getters in CustomGarmentProduction work as expected
    @Test
    public void testGetters() {
        String[] fabrics = {"silk", "cotton", "wool"};
        String garmentCode = "ABC123";
        char size = 'M';
        CustomGarmentProduction garment = new CustomGarmentProduction(fabrics, garmentCode, size);

        assertEquals("Garment code does not match expected value.", garmentCode, garment.getGarmentCode());
        assertEquals("Garment size does not match expected value.", size, garment.getSize());
    }

    
    // The inherited getter in CustomGarmentProduction works as expected
    @Test
    public void testGetFabricTypes() {
        String[] fabrics = {"silk", "cotton", "wool"};
        CustomGarmentProduction garment = new CustomGarmentProduction(fabrics, "ABC123", 'M');

        assertArrayEquals("Array of fabric types does not match expected value.", fabrics, garment.getFabricTypes());
    }


    // A CustomGarmentProduction constructor with a single fabric works
    @Test
    public void testConstructorWithSingleFabric() {
        String fabric = "silk";
        String garmentCode = "ABC123";
        char size = 'M';
        CustomGarmentProduction garment = new CustomGarmentProduction(fabric, garmentCode, size);

        assertEquals("Garment code does not match expected value.", garmentCode, garment.getGarmentCode());
        assertEquals("Garment size does not match expected value.", size, garment.getSize());
        String[] actualFabric = garment.getFabricTypes();
        assertEquals("Fabric type does not match expected value.", fabric, actualFabric[0]);
    }

 
    // A CustomGarmentProduction constructor with multiple fabrics works
    @Test
    public void testConstructorWithMultipleFabrics() {
        String[] fabrics = {"silk", "cotton", "wool"};
        String garmentCode = "ABC123";
        char size = 'M';
        CustomGarmentProduction garment = new CustomGarmentProduction(fabrics, garmentCode, size);

        assertEquals("Garment code does not match expected value.", garmentCode, garment.getGarmentCode());
        assertEquals("Garment size does not match expected value.", size, garment.getSize());
        assertArrayEquals("Array of fabric types does not match expected value.", fabrics, garment.getFabricTypes());
    }


    // Trying to add an invalid fabric throws an IllegalArgumentException
    @Test
    public void testAddFabricInvalid() {
        boolean result = false;
        String message = "no exception was thrown";
        try { 
            Fabric fabric = new Fabric("pleather");
        }
        catch(IllegalArgumentException e) {
            result = true;
        }
        catch(Exception e) {
            message = "the wrong type of exception was thrown";
        }
        assertTrue("Invalid value for addFabric(String) should throw IllegalArgumentException, but " + message, result);
    }


    // Trying to add multiple fabrics where one is invalid throws an
    // IllegalArgumentException
    @Test
    public void testAddFabricsInvalid() {
        boolean result = false;
        String message = "no exception was thrown";
        try {
            String[] fabricTypes = {"silk", "cotton", "bambo"};
            Fabric fabric = new Fabric(fabricTypes);
        }
        catch(IllegalArgumentException e) {
            result = true;
        }
        catch(Exception e) {
            message = "the wrong type of exception was thrown";
        }
        assertTrue("Invalid value for addFabric(String[]) should throw IllegalArgumentException, but " + message, result);
    }


    // Removing a fabric actually removes it and returns true
    public void testRemoveFabricPresence() {
        String[] fabricTypes = {"silk", "cotton", "bamboo"};
        Fabric fabric = new Fabric(fabricTypes);

        assertTrue("removeFabricType returned false, implying fabric was not present, when the fabric argument was stored in fabricTypes", fabric.removeFabricType("cotton"));
        assertFalse("removeFabricType did not actually remove the fabric specified as an argument", Arrays.asList(fabric.getFabricTypes()).contains("cotton"));
    }


    // Removing a fabric shifts elements in the array to fill the gap
    @Test
    public void testShiftedArrayAfterRemoval() {
        String[] fabricTypes = {"silk", "cotton", "bamboo"};
        Fabric fabric = new Fabric(fabricTypes);
        
        fabric.removeFabricType("cotton");

        String[] actualFabrics = fabric.getFabricTypes();
        assertEquals("When a fabric was removed from the middle of the fabricTypes array, the third value wasn't moved to the second position", "bamboo", actualFabrics[1]);
    }

   
    // A fabric is removed and a new one is added to the end of the array
    @Test
    public void testRemoveAndAddFabric() {
        String[] fabrics = {"silk", "cotton", "wool"};
        String garmentCode = "ABC123";
        char size = 'M';
        CustomGarmentProduction garment = new CustomGarmentProduction(fabrics, garmentCode, size);

        // Remove the first fabric
        garment.removeFabricType("silk");

        // Add a new fabric
        garment.addFabricType("polyester");

        // Get the fabric types and verify the new fabric is at index 2
        String[] updatedFabrics = garment.getFabricTypes();
        assertEquals("Newly added fabric should be at index 2 after removing the first one.", "polyester", updatedFabrics[2]);
    }


    // Trying to remove a fabric which isn't part of the garment returns
    // false and doesn't throw an exception
    @Test
    public void testRemoveFabricNotIncluded() {
        String[] fabricTypes = {"silk", "bamboo", "polyester"};
        Fabric fabric = new Fabric(fabricTypes);
        assertFalse("When trying to remove a fabric which doesn't exist, removeFabricType should return false", fabric.removeFabricType("cotton"));
    }


    // An invalid garment size throws an IllegalArgumentException
    @Test
    public void testInvalidGarmentSize() {
        String[] fabrics = {"silk", "cotton", "wool"};
        String garmentCode = "ABC123";
        
        try {
            CustomGarmentProduction garment = new CustomGarmentProduction(fabrics, garmentCode, 'Z');
            fail("Expected IllegalArgumentException was not thrown.");
        } catch (IllegalArgumentException e) {
            // Check if the correct exception is thrown
            assertEquals("Wrong exception type thrown.", IllegalArgumentException.class, e.getClass());
        } catch (Exception e) {
            fail("Unexpected exception was thrown: " + e.getClass().getName());
        }
    }


    // Garment size is not normalized, so a lower case size throws an
    // IllegalArgumentException
    @Test
    public void testGarmentSizeIsNotNormalized() {
        String[] fabrics = {"silk", "cotton", "wool"};
        String garmentCode = "ABC123";

        // Try to create a garment with an invalid size "s" instead of "S"
        try {
            CustomGarmentProduction garment = new CustomGarmentProduction(fabrics, garmentCode, 's');
            fail("Expected IllegalArgumentException was not thrown.");
        } catch (IllegalArgumentException e) {
            // Check if the correct exception is thrown
            assertEquals("Wrong exception type thrown.", IllegalArgumentException.class, e.getClass());
        } catch (Exception e) {
            fail("Unexpected exception was thrown: " + e.getClass().getName());
        }
    }

}
