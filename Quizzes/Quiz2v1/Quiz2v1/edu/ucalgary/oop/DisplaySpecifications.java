/*
 * Version: student code
*/

//package edu.ucalgary.oop;

public interface DisplaySpecifications {

    /**
     * Formats the order information.
     * 
     * @param fabrics     - Array of fabric types for the garment.
     * @param garmentCode - Code representing the garment.
     * @param size        - Size of the garment (e.g., S, M, L).
     * @return A formatted string representing the order information.
     * 
     * Example:
     * If fabrics = {"silk", "cotton", "wool"}, garmentCode = "ABC123", and size = 'M',
     * the returned string should be:
     * "Garment Code: ABC123
     * Size: M
     * Fabrics: silk, cotton, wool"
     */
    static String formatOrder(String[] fabrics, String garmentCode, char size) {
        StringBuilder result = new StringBuilder();
        // Fixed: displayed garmentCode first then size (reversed order)
        //Fixed: changed size to garmentCode
        result.append(String.format("Garment Code: %s\n", garmentCode));
        result.append(String.format("Size: %s\n", size));
        result.append("Fabrics: ");
        for (int i = 0; i < fabrics.length; i++) {
            result.append(fabrics[i]);
            if (i < fabrics.length - 1) {
                // Fixed: added space after comma
                result.append(", ");
            }
        }
        return result.toString();
    }
}
