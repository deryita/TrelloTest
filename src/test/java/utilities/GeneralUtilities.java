package utilities;


import org.apache.commons.codec.binary.Base64;

public class GeneralUtilities {
    public static String encode(String toBeEncodedStr) {

        return new String(Base64.encodeBase64(toBeEncodedStr.getBytes()));

    }

    public static String decode(String toBeDecodedStr) {
        return new String(Base64.decodeBase64(toBeDecodedStr.getBytes()));
    }
}
