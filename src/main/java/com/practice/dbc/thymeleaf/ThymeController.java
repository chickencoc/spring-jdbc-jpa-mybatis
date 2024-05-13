package com.practice.dbc.thymeleaf;

import com.practice.dbc.common.domain.Company;
import com.practice.dbc.common.dto.CompanyRequest;
import com.practice.dbc.mybatis.repository.MbsCompanyRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ThymeController {

    @Autowired
    private MbsCompanyRepository mbsCompanyRepository;

    @GetMapping
    public String page(Model model) {
        model.addAttribute("companyRequest", new CompanyRequest());
        return "add";
    }

    // PRG : Post Redirect Get
    @PostMapping("/list")
    public String insertCompany(Model model, @Valid CompanyRequest companyRequest, BindingResult result) {

        if(result.hasErrors())
            return "add";

        mbsCompanyRepository.save(companyRequest);
        return "redirect:/list";
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<Company> companys = mbsCompanyRepository.findAll();
        model.addAttribute("companys", companys);
        return "list";
    }
}
