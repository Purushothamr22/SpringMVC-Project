package com.xworkz.metroapplication.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Component
@Slf4j
public class Encryption {

    static Cipher cipher;
    final static String secretKeyString = "aeroplaneaeropla";


    public String encrypt(String plainText) {
        SecretKey secretKey;
        try {
            secretKey = new SecretKeySpec(secretKeyString.getBytes("UTF-8"), "AES");
            cipher = Cipher.getInstance("AES");
            byte[] plainTextByte = plainText.getBytes();
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] encryptedByte = cipher.doFinal(plainTextByte);
            Base64.Encoder encoder = Base64.getEncoder();
            return encoder.encodeToString(encryptedByte);
        } catch (Exception e) {
            log.info("Error in encrypt method :   =========== {}",e.getMessage());
        }
        return null;
    }

    public String decrypt(String encryptedText) {
        SecretKey secretKey;
        try {
            secretKey = new SecretKeySpec(secretKeyString.getBytes(StandardCharsets.UTF_8), "AES");
            cipher = Cipher.getInstance("AES");
            Base64.Decoder decoder = Base64.getDecoder();
            byte[] encryptedTextByte = decoder.decode(encryptedText);
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] decryptedByte = cipher.doFinal(encryptedTextByte);
            return new String(decryptedByte);
        } catch (Exception e) {
            log.info("Error in decrypt method :   =========== {}",e.getMessage());
        }
        return null;
    }


}