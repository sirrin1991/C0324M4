package com.example.spring_mvc.controller;

import com.example.spring_mvc.model.Student;
import com.example.spring_mvc.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;

@Controller // annotation
@RequestMapping("/") // URL handle mapping
public class StudentController {

    @Autowired
    private IStudentService iStudentService;

    @GetMapping
    public String showHomePage(Model model) {
        // Model, ModelAndView, ModelMap %a% -> lấy hết
        List<Student> list = iStudentService.findAll();
        model.addAttribute("list", list);
        return "home";
    }

    @GetMapping("show-create-form")
    public String showCreateForm(Model model) {
        model.addAttribute("student", new Student());
        return "create_form";
    }

    @PostMapping("save-student")
    public String save(@ModelAttribute("student") Student student, RedirectAttributes redirectAttributes) {
        iStudentService.save(student);
        redirectAttributes.addFlashAttribute("msg","thêm mới thành công");
        return "redirect:/"; // <=> respone.sendRedirect
    }// HTTP POST: form post

    @GetMapping("show-update-form/{id}")
    public String showUpdateForm(@PathVariable("id") int id){
        System.out.println(id);
        return "update_form";
    }
}
