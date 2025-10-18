package com.lorenzo.CadastroDeFuncionarios;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/ui")
    public String uiHome() {
        return "index";
    }
}