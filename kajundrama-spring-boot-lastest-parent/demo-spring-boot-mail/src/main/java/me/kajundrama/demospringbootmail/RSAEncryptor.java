package me.kajundrama.demospringbootmail;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import javax.annotation.PostConstruct;
import javax.crypto.Cipher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class RSAEncryptor {

  private final Logger logger = LoggerFactory.getLogger(RSAEncryptor.class);

  private KeyPairGenerator keypairgen;
  private KeyPair keyPair;
  private RSAPrivateKey privateKey;
  private RSAPublicKey publicKey;
  private Cipher cipher;

  @PostConstruct
  private void init() throws Exception {
    logger.info("init..");
    // RSA 비밀키와 공개키를 생성
    this.keypairgen = KeyPairGenerator.getInstance("RSA");
    this.keyPair = keypairgen.generateKeyPair();
    this.privateKey = (RSAPrivateKey) keyPair.getPrivate();
    this.publicKey = (RSAPublicKey) keyPair.getPublic();
    // Cipher 객체 생성과 비밀키 초기화
    this.cipher = Cipher.getInstance("RSA");
  }


  public byte[] encryt(String plainText) throws Exception {

    this.cipher.init(Cipher.ENCRYPT_MODE, privateKey);
    // 암호화 완료
    byte[] encryptBytes = cipher.doFinal(plainText.getBytes());
    return encryptBytes;
  }

  public byte[] decrypt(byte[] encryptBytes) throws Exception {

    // 복호화 Chipher 초기화, 비밀키와 쌍인 공개키로 복호화함.
    this.cipher.init(cipher.DECRYPT_MODE, publicKey);
    byte[] decryptBytes = cipher.doFinal(encryptBytes);
    return decryptBytes;
  }
}
