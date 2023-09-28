package org.example.cipher;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class RailFenceCipherTest {

    private static Stream<Arguments> positiveValues() {
        return Stream.of(
            Arguments.of("WEAREDISCOVEREDFLEEATONCE", 3,
                "WECRLTEERDSOEEFEAOCAIVDEN"),
            Arguments.of("WEAREDISCOVEREDFLEEATONCE", 4,
                "WIREEEDSEEEACAECVDLTNROFO"),
            Arguments.of("ABCD", 2, "ACBD")
        );
    }

    private static Stream<Arguments> negativeValues() {
        return Stream.of(
            Arguments.of("WEAREDISCOVEREDFLEEATONCE", 0, ""),
            Arguments.of("WEAREDISCOVEREDFLEEATONCE", -1, ""),
            Arguments.of("ABC", 4, "")
        );
    }

    @ParameterizedTest
    @MethodSource("positiveValues")
    void testEncryptPositive(String text, int key, String expected) {
        Assertions.assertEquals(expected,
            RailFenceCipher.encryptText(text, key));
    }

    @ParameterizedTest
    @MethodSource("negativeValues")
    void testEncryptNegative(String text, int key, String expected) {
        Assertions.assertEquals(expected,
            RailFenceCipher.encryptText(text, key));
    }

    @ParameterizedTest
    @MethodSource("positiveValues")
    void testDecryptPositive(String expected, int key, String cipher) {
        Assertions.assertEquals(expected,
            RailFenceCipher.decryptCipher(cipher, key));
    }

    @ParameterizedTest
    @MethodSource("negativeValues")
    void testDecryptNegative(String cipher, int key, String expected) {
        Assertions.assertEquals(expected,
            RailFenceCipher.decryptCipher(cipher, key));
    }
}
