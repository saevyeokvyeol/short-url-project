package com.shorturl.shorturlproject;

import com.shorturl.shorturlproject.domain.Url;
import com.shorturl.shorturlproject.dto.UrlRequestDto;
import com.shorturl.shorturlproject.repository.UrlRepository;
import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ShortControllerTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private UrlRepository urlRepository;

    @After
    public void tearDown() throws Exception {
        urlRepository.deleteAll();
    }

    @Test
    public void createUrlTest() throws Exception {
        String destinationUrl = "http://www.yes24.com/product/search?query=%EC%86%8C%ED%94%84%ED%8A%B8%EC%9B%A8%EC%96%B4%20%EC%9E%A5%EC%9D%B8";
        String password = "0000";
        UrlRequestDto requestDto = UrlRequestDto.builder()
                .destinationUrl(destinationUrl)
                .password(password)
                .build();

        String url = "http://localhost:" + port + "/url";

        // when
        ResponseEntity<String> responseEntity = testRestTemplate.postForEntity(url, requestDto, String.class);

        // then
        Assertions.assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);

        List<Url> all = urlRepository.findAll();
        Assertions.assertThat(all.get(0).getDestinationUrl()).isEqualTo(destinationUrl);
        Assertions.assertThat(all.get(0).getPassword()).isEqualTo(password);
    }
}
