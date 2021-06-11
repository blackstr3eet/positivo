package br.com.positivo.bitwise;

import static java.lang.Integer.parseInt;

public class Bitwise {

    public static final String MESSAGE_ERROR_INPUT = "Value Input Is Invalid";

    private static final int BASE_BINARY = 2;
    private static final String REGEX_VALID_HEXADECIMAL = "^(\\d|[A-F])+$";

    public static String xor(String hexadecimalInput1, String hexadecimalInput2) {
        final StringBuilder bitwise = new StringBuilder();

        hexadecimalInput1 = hexadecimalInput1.toUpperCase();
        hexadecimalInput2 = hexadecimalInput2.toUpperCase();

        if (validHexadecimalFormatInput(hexadecimalInput1, hexadecimalInput2)) {
            CharSequence binarySequence1 = convertHexadecimalToBinary(hexadecimalInput1);
            CharSequence binarySequence2 = convertHexadecimalToBinary(hexadecimalInput2);

            int maxLength = binarySequence1.length() > binarySequence2.length() ? binarySequence1.length() : binarySequence2.length();

            char[] array1 = fillWithZerosForCompare(maxLength, binarySequence1).toString().toCharArray();
            char[] array2 = fillWithZerosForCompare(maxLength, binarySequence2).toString().toCharArray();

            for (int index = 0; index < maxLength; index++) {
                if (array1[index] == '1' && array2[index] == '1') {
                    bitwise.append("0");
                    continue;
                } else if (array1[index] == '1' || array2[index] == '1') {
                    bitwise.append("1");
                    continue;
                }

                bitwise.append("0");
            }

            return convertBinaryToHexadecimal(bitwise).toString();
        } else {
            return MESSAGE_ERROR_INPUT;
        }
    }

    public static String xor(byte[] input1, byte[] input2) {
        return null;
    }

    public static String or(String hexadecimalInput1, String hexadecimalInput2) {
        final StringBuilder bitwise = new StringBuilder();

        hexadecimalInput1 = hexadecimalInput1.toUpperCase();
        hexadecimalInput2 = hexadecimalInput2.toUpperCase();

        if (validHexadecimalFormatInput(hexadecimalInput1, hexadecimalInput2)) {
            CharSequence binarySequence1 = convertHexadecimalToBinary(hexadecimalInput1);
            CharSequence binarySequence2 = convertHexadecimalToBinary(hexadecimalInput2);

            int maxLength = binarySequence1.length() > binarySequence2.length() ? binarySequence1.length() : binarySequence2.length();

            char[] array1 = fillWithZerosForCompare(maxLength, binarySequence1).toString().toCharArray();
            char[] array2 = fillWithZerosForCompare(maxLength, binarySequence2).toString().toCharArray();

            for (int index = 0; index < maxLength; index++) {
                if (array1[index] == '1' || array2[index] == '1') {
                    bitwise.append("1");
                    continue;
                }

                bitwise.append("0");
            }

            return convertBinaryToHexadecimal(bitwise).toString();
        } else {
            return MESSAGE_ERROR_INPUT;
        }
    }

    private static boolean validHexadecimalFormatInput(final String input1, final String input2) {
        return input1.matches(REGEX_VALID_HEXADECIMAL) && input2.matches(REGEX_VALID_HEXADECIMAL);
    }

    private static int convertHexadecimalToDecimal(final char character) {
        switch (character) {
            case '0':
                return 0;
            case '1':
                return 1;
            case '2':
                return 2;
            case '3':
                return 3;
            case '4':
                return 4;
            case '5':
                return 5;
            case '6':
                return 6;
            case '7':
                return 7;
            case '8':
                return 8;
            case '9':
                return 9;
            case 'A':
                return 10;
            case 'B':
                return 11;
            case 'C':
                return 12;
            case 'D':
                return 13;
            case 'E':
                return 14;
            case 'F':
                return 15;
            default:
                return -1;
        }
    }

    private static String convertDecimalToHexadecimal(final int decimal) {
        switch (decimal) {
            case 0:
                return "0";
            case 1:
                return "1";
            case 2:
                return "2";
            case 3:
                return "3";
            case 4:
                return "4";
            case 5:
                return "5";
            case 6:
                return "6";
            case 7:
                return "7";
            case 8:
                return "8";
            case 9:
                return "9";
            case 10:
                return "A";
            case 11:
                return "B";
            case 12:
                return "C";
            case 13:
                return "D";
            case 14:
                return "E";
            case 15:
                return "F";
            default:
                return null;
        }
    }

    private static CharSequence convertHexadecimalToBinary(String hexadecimalInput) {
        final StringBuilder binaryGroup = new StringBuilder();
        final char[] chars = hexadecimalInput.toCharArray();

        for (char sequence : chars) {
            int decimal = convertHexadecimalToDecimal(sequence);

            if (decimal == 0) {
                binaryGroup.append("0000");
            }

            if (decimal > 0) {
                final StringBuilder binaryInverse = new StringBuilder();

                while (decimal > 0) {
                    binaryInverse.append(decimal % BASE_BINARY);
                    decimal /= BASE_BINARY;
                }

                binaryGroup.append(binaryGroupFormatter(binaryInverse));
            }
        }

        return binaryGroup;
    }

    private static CharSequence convertBinaryToHexadecimal(final CharSequence binaryInput) {
        final StringBuilder outputHexadecimal = new StringBuilder();
        int sumDecimal = 0;
        int count = 3;

        for (char bit : binaryInput.toString().toCharArray()) {
            sumDecimal += Math.pow(BASE_BINARY, count) * parseInt(Character.toString(bit));

            count--;

            if (count < 0) {
                outputHexadecimal.append(convertDecimalToHexadecimal(sumDecimal));
                sumDecimal = 0;
                count = 3;
            }
        }

        return outputHexadecimal;
    }

    private static CharSequence binaryGroupFormatter(final StringBuilder binaryInverse) {
        switch (binaryInverse.length()) {
            case 1:
                return String.format("000%s", binaryInverse.reverse());
            case 2:
                return String.format("00%s", binaryInverse.reverse());
            case 3:
                return String.format("0%s", binaryInverse.reverse());
            default:
                return binaryInverse.reverse();
        }
    }

    private static CharSequence fillWithZerosForCompare(final int maxLength, final CharSequence binarySequence) {
        final StringBuilder newBinarySequence = new StringBuilder();

        if (binarySequence.length() == maxLength) {
            return binarySequence;
        }

        for (int count = 0; count < maxLength - binarySequence.length(); count++) {
            newBinarySequence.append("0");
        }

        return newBinarySequence.append(binarySequence);
    }
}