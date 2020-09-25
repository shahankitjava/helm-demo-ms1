package com.aa.helm.helmdemoms1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelmController {

    @Value("${helm2.url}")
    private String helm2Url;

    @GetMapping(value = "/")
    public @ResponseBody
    HelmResponse greet() {
        HelmResponse helmResponse = new HelmResponse();
        helmResponse.setWelcome("Welcome from helm-demo-ms1");
        return helmResponse;
    }

    @GetMapping(value = "/callHelm2")
    public @ResponseBody
    HelmResponse greetHelm2() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<HelmResponse> response = restTemplate.getForEntity(helm2Url, HelmResponse.class);
        return response.getBody();
    }
}

class HelmResponse {
    private String welcome;

    public String getWelcome() {
        return welcome;
    }

    public void setWelcome(String welcome) {
        this.welcome = welcome;
    }
}
