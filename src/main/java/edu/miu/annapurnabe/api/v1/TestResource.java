package edu.miu.annapurnabe.api.v1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static edu.miu.annapurnabe.constant.WebResourceKeyConstant.API_V1_BASE;
import static edu.miu.annapurnabe.constant.WebResourceKeyConstant.TEST;

/**
 * @author bijayshrestha on 7/6/22
 * @project annapurna-be
 */
@RestController
@RequestMapping( API_V1_BASE + TEST)
public class TestResource {

    @GetMapping
    public String test(){
        return "Application is working";
    }
}
