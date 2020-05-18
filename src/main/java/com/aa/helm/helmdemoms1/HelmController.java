package com.aa.helm.helmdemoms1;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelmController {

    @Value("${helm2.url}")
    private String helm2Url;

    @GetMapping(value = "/helm1/{id}")
    public @ResponseBody HelmResponse greet(@PathVariable String id) {
        HelmResponse helmResponse = new HelmResponse();
        helmResponse.setWelcome("Helm Demo MS 1 : " + id);
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        for (Integer integer : list) {
            System.out.println(integer);
        }
        return helmResponse;
    }

    @GetMapping(value = "/callHelm2")
    public @ResponseBody HelmResponse greetHelm2() {
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
