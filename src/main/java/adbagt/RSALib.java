package adbagt;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author William
 */
import java.io.FileNotFoundException;  
import java.io.FileOutputStream;  
import java.io.IOException;  
import java.io.ObjectOutputStream;  
import java.math.BigInteger;  
import java.security.Key;  
import java.security.KeyFactory;  
import java.security.KeyPair;  
import java.security.KeyPairGenerator;  
import java.security.NoSuchAlgorithmException;  
import java.security.interfaces.RSAPrivateKey;  
import java.security.interfaces.RSAPublicKey;  
import java.security.spec.RSAPrivateKeySpec;  
import java.security.spec.RSAPublicKeySpec;  
import javax.crypto.Cipher;  
import javax.crypto.NoSuchPaddingException;  
  
public class RSALib {  
  
    public static void makekeyfile(String pubkeyfile, String privatekeyfile)  
            throws NoSuchAlgorithmException, FileNotFoundException, IOException {  
        // KeyPairGenerator类用于生成公钥和私钥对，基于RSA算法生成对象  
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");  
        // 初始化密钥对生成器，密钥大小为1024位  
        keyPairGen.initialize(1024);  
        // 生成一个密钥对，保存在keyPair中  
        KeyPair keyPair = keyPairGen.generateKeyPair();  
  
        // 得到私钥  
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();   
  
        // 得到公钥  
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();  
  
        // 生成私钥  
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(  
                privatekeyfile));  
        oos.writeObject(privateKey);  
        oos.flush();  
        oos.close();  
  
        oos = new ObjectOutputStream(new FileOutputStream(pubkeyfile));  
        oos.writeObject(publicKey);  
        oos.flush();  
        oos.close();  
  
        System.out.println("make file ok!");  
    }  
    
    /** 
     *  
     * @param k 
     * @param data 
     * @param encrypt 
     *            1 加密 0解密 
     * @return 
     * @throws NoSuchPaddingException 
     * @throws Exception 
     */  
    public static byte[] handleData(Key k, byte[] data, int encrypt)  
            throws Exception {  
  
        if (k != null) {  
  
            Cipher cipher = Cipher.getInstance("RSA");  
  
            if (encrypt == 1) {  
                cipher.init(Cipher.ENCRYPT_MODE, k);  
                byte[] resultBytes = cipher.doFinal(data);  
                return resultBytes;  
            } else if (encrypt == 0) {  
                cipher.init(Cipher.DECRYPT_MODE, k);  
                byte[] resultBytes = cipher.doFinal(data);  
                return resultBytes;  
            } else {  
                System.out.println("参数必须为: 1 加密 0解密");  
            }  
        }  
        return null;  
    }  

    public static RSAPublicKey getPublicKey(String modulus, String exponent) {
        try {
            BigInteger b1 = new BigInteger(modulus);
            BigInteger b2 = new BigInteger(exponent);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            RSAPublicKeySpec keySpec = new RSAPublicKeySpec(b1, b2);
            return (RSAPublicKey) keyFactory.generatePublic(keySpec);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static RSAPrivateKey getPrivateKey(String modulus, String exponent) {
        try {
            BigInteger b1 = new BigInteger(modulus);
            BigInteger b2 = new BigInteger(exponent);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            RSAPrivateKeySpec keySpec = new RSAPrivateKeySpec(b1, b2);
            return (RSAPrivateKey) keyFactory.generatePrivate(keySpec);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    //简单加密配置文件密码
    public static String encryptstring(String s_in){
        //return s_in + s_in;
        return s_in;
    }
    //简单解密配置文件密码
    public static String decryptstring(String s_in){
        //return s_in.substring(0, (s_in.length() / 2));
        return s_in;
    }
    
    public static String encrypt(String s_in) throws Exception {  
        RSAPublicKey pbk = getPublicKey(
                "127753449818291535172129958290293407037067517392799927983072742977722110612419372910860806509738370806833069512812990502872441706871592883065954126268628663801079533115455753103353206633119547194226535892624156721769705060351851727434065397094090261710350423581951456402987479907973167964888505639892339323137",
                "65537");
        // 获取明文m  
        //System.out.println("明文：" + s_in);   
        byte ptext[] = s_in.getBytes("UTF-8");  
        BigInteger m = new BigInteger(ptext);  
        // 计算密文c  
        BigInteger c = m.modPow(pbk.getPublicExponent(), pbk.getModulus());  
        //System.out.println("密文：" + c.toString());   
        return c.toString();  
    }  
    
    public static String decrypt(String s_out) throws Exception {
        BigInteger c = new BigInteger(s_out); 
        RSAPrivateKey prk = getPrivateKey(
                "127753449818291535172129958290293407037067517392799927983072742977722110612419372910860806509738370806833069512812990502872441706871592883065954126268628663801079533115455753103353206633119547194226535892624156721769705060351851727434065397094090261710350423581951456402987479907973167964888505639892339323137",
                "48201161994856261199036536287045258034477753064250176529860074699942545876578022093883686506344518286472699541378561975136592552082241744656786970417388351751770600274387852947092723496439630703614978169172406769008847297756869737596266337726742843722437003584741437705034598611547020907494382554800431082589");
        BigInteger m = c.modPow(prk.getPrivateExponent(), prk.getModulus());
        //System.out.println("m= " + m);
        byte[] mt = m.toByteArray();
        String s_ret = "";
        for (int i = 0; i < mt.length; i++) {
            //System.out.print((char) mt[i]);
            s_ret = s_ret + (char) mt[i];
        }
        //System.out.println("明文：" + s_ret);   
        return s_ret;
    }
    
    public static void main(String[] args) throws Exception {  
  
        //String pubfile = "c:/pub.key";  
        //String prifile = "c:/pri.key";  
        
        //makekeyfile("c:/pub.key", "c:/pri.key");
  
        // makekeyfile(pubfile, prifile);  
  
        /*ObjectInputStream ois = new ObjectInputStream(new FileInputStream(  
                pubfile));  
        RSAPublicKey pubkey = (RSAPublicKey) ois.readObject();  
        ois.close();  
  
        ois = new ObjectInputStream(new FileInputStream(prifile));  
        RSAPrivateKey prikey = (RSAPrivateKey) ois.readObject();  
        ois.close();  
  
        // 使用公钥加密  
        String msg = "~O(∩_∩)O哈哈~";  
        String enc = "UTF-8";  
  
        // 使用公钥加密私钥解密  
        System.out.println("原文: " + msg);  
        byte[] result = handleData(pubkey, msg.getBytes(enc), 1);  
        System.out.println("加密: " + new String(result, enc));  
        byte[] deresult = handleData(prikey, result, 0);  
        System.out.println("解密: " + new String(deresult, enc));  
  
        msg = "嚯嚯";  
        // 使用私钥加密公钥解密  
        System.out.println("原文: " + msg);  
        byte[] result2 = handleData(prikey, msg.getBytes(enc), 1);  
        System.out.println("加密: " + new String(result2, enc));  
        byte[] deresult2 = handleData(pubkey, result2, 0);  
        System.out.println("解密: " + new String(deresult2, enc));  */
        decrypt(encrypt("1234567890!@#$%^&*()_+qwertyuiop[]\';lkjhgfdsazxcvbnm,./"));
  
    }  
    
}