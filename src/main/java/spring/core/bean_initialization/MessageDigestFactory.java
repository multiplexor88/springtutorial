package spring.core.bean_initialization;

import java.security.MessageDigest;

/**
 * Created by multi on 25.04.2016.
 */
public class MessageDigestFactory {
    private MessageDigest messageDigest;
    private String algorithmName = "MD5";

    public void setAlgorithmName(String algorithmName) {
        this.algorithmName = algorithmName;
    }
    public MessageDigest getInstance() throws Exception {
        return MessageDigest.getInstance(algorithmName);
    }
}
