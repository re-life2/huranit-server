package relife.huranit.global.common;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;

@RestController
public class HealthCheckApiController {

    @RequestMapping("/")
    public ResponseEntity<byte[]> HuranitServer() throws IOException {
        Resource resource = new ClassPathResource("static/example.mp4");
        InputStream videoStream = resource.getInputStream();
        byte[] videoBytes = StreamUtils.copyToByteArray(videoStream);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.valueOf("video/mp4"));
        headers.setContentLength(videoBytes.length);

        return new ResponseEntity<>(videoBytes, headers, HttpStatus.OK);
    }

    @RequestMapping("/example")
    public ResponseEntity<SuccessResponse<?>> example() {
        return SuccessResponse.ok("example");
    }
}