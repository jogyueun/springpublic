package com.example.firstproject.controller;

import com.example.firstproject.dto.SignForm;
import com.example.firstproject.entity.Sign;
import com.example.firstproject.repository.SignRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

@Slf4j
@Controller
public class SignController {

    @Autowired
    private SignRepository signRepository;

    @GetMapping("/signs/new")
    public String newSignForm() {
        return "signs/new";
    }

    @PostMapping("/signs/create")
    public String createSign (SignForm form) {
//        System.out.println(form.toString());
        log.info(form.toString());

        // 1. DTO를 엔티티로 변환
        Sign sign = form.Entity();
//        System.out.println(sign.toString());
        log.info(sign.toString());
        // 2. 리파지터리로 엔티티를 DB에 저장
        Sign saved = signRepository.save(sign);
//        System.out.println(saved.toString());
        log.info(saved.toString());
        return "redirect:/signs/" + saved.getId(); // 리다이렉트를 작성할 위치


    }

    @GetMapping("/signs/{id}")
    public String show(@PathVariable Long id, Model model){
        // 1. id를 조회해 데이터 가져오기
        log.info("id = " + id);
        Sign signEntity = signRepository.findById(id).orElse(null);
        // 2. 모델에 데이터 등록하기
        model.addAttribute("sign", signEntity);
        // 3. 뷰 페이지 반환하기
        return "signs/show";
    }

    @GetMapping("/signs")
    public String index(Model model){
        // 1. 모든 데이터 가져오기
        ArrayList<Sign> signEntityList = signRepository.findAll();
        // 2. 모델에 데이터 등록하기
        model.addAttribute("signList", signEntityList);
        // 3. 뷰 페이지 설정하기
        return "signs/index";
    }
}
