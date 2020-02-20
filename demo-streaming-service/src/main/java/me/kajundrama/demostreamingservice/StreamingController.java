package me.kajundrama.demostreamingservice;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.servlet.http.HttpServletRequest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

@Controller
@RequestMapping("/stream")
public class StreamingController {


  @GetMapping("/")
  public String getTestPage() {
    return "index";
  }

  @GetMapping("/download")
  public StreamingResponseBody stream(HttpServletRequest req, @RequestParam("fileName") String fileName) throws Exception {
//    InputStream is = this.getClass().getResourceAsStream(fileName);
//    System.out.println("file : " + is);
    File file = new ClassPathResource(fileName).getFile();
    System.out.println("file : " + file.getName() + ", " + file.exists());
    final InputStream is = new FileInputStream(file);
    return os -> {
      readAndWrite(is, os);
    };
  }

  private void readAndWrite(final InputStream is, OutputStream os) throws IOException {
    byte[] data = new byte[2048];
    int read = 0;
    while ((read = is.read(data)) > 0) {
      os.write(data, 0, read);
    }
    os.flush();
  }

}
