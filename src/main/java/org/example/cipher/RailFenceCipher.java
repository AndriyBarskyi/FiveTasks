package org.example.cipher;

public class RailFenceCipher {

    /**
     * Encrypts the given text using the rail fence cipher algorithm.
     *
     * @param text the text to be encrypted
     * @param key  the key used for encryption
     * @return the encrypted text
     */
    public static String encryptText(String text, int key) {
        if (key <= 1 || text.isEmpty() || key > text.length()) {
            return "";
        }

        StringBuilder[] rails = createEmptyRails(key);
        fillRailsWithText(rails, text, key);

        return combineRailsIntoString(rails);
    }

    /**
     * Decrypts the given cipher using the rail fence cipher algorithm with the specified key.
     *
     * @param cipher the cipher text to be decrypted
     * @param key    the key used to decrypt the cipher text
     * @return the decrypted plain text
     */
    public static String decryptCipher(String cipher, int key) {
        if (key <= 1 || cipher.isEmpty() || key > cipher.length()) {
            return "";
        }

        StringBuilder[] rails = constructRailsFromCipher(cipher, key);
        return constructDecryptedTextFromRails(cipher.length(), rails, key);
    }

    /**
     * Generates an array of StringBuilder objects representing the rails constructed from
     * the given cipher using the specified key.
     *
     * @param cipher the string representing the cipher
     * @param key    the integer representing the key for constructing the rails
     * @return an array of StringBuilder objects representing the constructed rails
     */
    public static StringBuilder[] constructRailsFromCipher(String cipher,
        int key) {
        StringBuilder[] rails = new StringBuilder[key];
        for (int i = 0; i < key; i++) {
            rails[i] = new StringBuilder();
        }

        int[] railLengths = calculateRailLengths(cipher, key);
        int currentIndex = 0;

        for (int i = 0; i < key; i++) {
            for (int j = 0; j < railLengths[i]; j++) {
                rails[i].append(cipher.charAt(currentIndex));
                currentIndex++;
            }
        }

        return rails;
    }

    /**
     * Construct decrypted text from the given rails.
     *
     * @param textLength the length of the text
     * @param rails      an array of StringBuilder representing the rails
     * @param key        the key used for encryption
     * @return the decrypted text
     */
    public static String constructDecryptedTextFromRails(int textLength,
        StringBuilder[] rails, int key) {
        StringBuilder result = new StringBuilder();
        int row = 0;
        boolean down = false;

        for (int i = 0; i < textLength; i++) {
            result.append(rails[row].charAt(0));
            rails[row].deleteCharAt(0);

            if (row == 0 || row == key - 1) {
                down = !down;
            }
            row += down ? 1 : -1;
        }

        return result.toString();
    }

    /**
     * Creates an array of empty StringBuilder objects to represent rails.
     *
     * @param key the number of rails to create
     * @return an array of StringBuilder objects representing empty rails
     */
    private static StringBuilder[] createEmptyRails(int key) {
        StringBuilder[] rails = new StringBuilder[key];
        for (int i = 0; i < key; i++) {
            rails[i] = new StringBuilder();
        }
        return rails;
    }

    /**
     * Fills an array of StringBuilder objects with characters from a given text,
     * following a zigzag pattern along the rows.
     *
     * @param rails an array of StringBuilder objects representing the rails
     * @param text  the text to be filled into the rails
     * @param key   the number of rows in the rails
     */
    private static void fillRailsWithText(StringBuilder[] rails,
        String text,
        int key) {
        int row = 0;
        boolean down = false;

        for (char c : text.toCharArray()) {
            rails[row].append(c);

            if (row == 0 || row == key - 1) {
                down = !down;
            }

            row += down ? 1 : -1;
        }
    }

    /**
     * Combine the StringBuilder rails into a single string.
     *
     * @param rails an array of StringBuilder rails
     * @return the combined string
     */
    private static String combineRailsIntoString(StringBuilder[] rails) {
        StringBuilder result = new StringBuilder();
        for (StringBuilder rail : rails) {
            result.append(rail);
        }
        return result.toString();
    }

    /**
     * Calculates the lengths of the rails for a rail cipher given the cipher text and the key.
     *
     * @param cipher the cipher text to encrypt or decrypt
     * @param key    the number of rails to be used in the rail cipher
     * @return an array containing the lengths of the rails
     */
    private static int[] calculateRailLengths(String cipher, int key) {
        int[] railLengths = new int[key];
        int row = 0;
        boolean down = false;

        for (int i = 0; i < cipher.length(); i++) {
            railLengths[row]++;
            if (row == 0 || row == key - 1) {
                down = !down;
            }
            row += down ? 1 : -1;
        }

        return railLengths;
    }
}
