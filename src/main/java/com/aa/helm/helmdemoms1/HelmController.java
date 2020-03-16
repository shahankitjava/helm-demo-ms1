package com.aa.helm.helmdemoms1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelmController {

    @GetMapping(value = "/{id}")
    public @ResponseBody
    HelmResponse greet(@PathVariable String id) {
        HelmResponse helmResponse = new HelmResponse();
        helmResponse.setWelcome("Hello : " + id);
        return helmResponse;
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
