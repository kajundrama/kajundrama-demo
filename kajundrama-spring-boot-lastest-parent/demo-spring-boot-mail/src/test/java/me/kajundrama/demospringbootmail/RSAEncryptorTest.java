package me.kajundrama.demospringbootmail;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {RSAEncryptor.class})
public class RSAEncryptorTest {

  @Autowired
  private RSAEncryptor rsaEncryptor;

  @Test
  public void testEncrypt() throws Exception {
    String plainText = "ABC";
    byte[] encBytes = rsaEncryptor.encryt(plainText);

    System.out.println("encText : " + new String(encBytes));

    byte[] decBytes = rsaEncryptor.decrypt(encBytes);

    System.out.println("decText : " + new String(decBytes));

    assertEquals(plainText, new String(decBytes));

  }
}