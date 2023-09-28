package org.example.cipher;

public class RailFenceCipherMain {

    public static void main(String[] args) {
        System.out.println("Encrypted Message:");
        System.out.println(RailFenceCipher.encryptText("WEAREDISCOVEREDFLEEATONCE", 3));

        System.out.println("\nDecrypted Message:");
        System.out.println(RailFenceCipher.decryptCipher("WECRLTEERDSOEEFEAOCAIVDEN", 3));
    }
}
