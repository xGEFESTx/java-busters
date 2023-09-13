package hmac;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.lang.reflect.Field;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import java.sql.Timestamp;
import java.util.Map;
import java.util.TreeMap;


public class GenerationHmac {

    public static void main(String[] args){

        Payload payload = new Payload();
        long timeStamp = new Timestamp(System.currentTimeMillis()).getTime();;
        final String SECRET = "mFg2SQ4LdxldU7UQAsW4Zwznb88A7P2mMjg4R5qJqjFe7Mc8OeXQjpDhf1IcgVxP";

        String message = getMessage(payload, timeStamp);
        String hmacSha512 = generateHmacSha512(SECRET, message);
        System.out.println(hmacSha512);
    }

    public static String getMessage(Object o, long date) {
        Field[] fields = o.getClass().getDeclaredFields();
        StringBuilder str = new StringBuilder();

        Map<String, Object> map = new TreeMap<>();
        for (Field field: fields){
            if(field.getType().getSimpleName().equals("String")){
                field.setAccessible(true);
                try {
                    map.put(field.getName(), field.get(o));
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        for(String st: map.keySet()){
            str.append(map.get(st));
        }
        return str.append(date).toString();
     }

    private static StringBuilder arrayToHexString(byte[] arr){
        StringBuilder   ssh = new StringBuilder();
        for (byte b: arr) {
            ssh.append(String.format("%02X", b).toLowerCase());
        }
        return ssh;
    }

    public static String generateHmacSha512(String secret, String message){
        Mac ssh512;

        try {
            ssh512 = Mac.getInstance("HmacSHA512");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        SecretKey secretKey = new SecretKeySpec(secret.getBytes(), "HmacSHA512");

        try {
            ssh512.init(secretKey);
        } catch (InvalidKeyException e) {
            throw new RuntimeException(e);
        }

        byte hash [] = ssh512.doFinal(message.getBytes());
        return arrayToHexString(hash).toString();
    }
}
