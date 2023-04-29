package com.example.fileviewer.model;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.math.BigInteger;

public class MD5{

    private static MD5 instance;

    //constructo privado

    private MD5(){}

    //getInstance -> Obtener la unica instancia de la clase

    public static MD5 getInstance(){
        if(instance == null){
            instance = new MD5();
        }
        return instance;
    }
    public static String getMD5Hash(String str) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(str.getBytes());
            BigInteger no = new BigInteger(1, messageDigest);
            String hash = no.toString(16);
            while (hash.length() < 32) {
                hash = "0" + hash;
            }
            return hash;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}