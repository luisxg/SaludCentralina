package lgonzalez.saludcentralina.controller;

import lgonzalez.saludcentralina.model.Consult;
import lgonzalez.saludcentralina.model.ConsultDetail;
import lgonzalez.saludcentralina.service.IConsultService;
import lgonzalez.saludcentralina.service.IMedicService;
import lgonzalez.saludcentralina.service.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.Thymeleaf;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ConsultController {
    @Autowired
    private IConsultService service;
    @Autowired
    private IPatientService patientService;
    @Autowired
    private IMedicService medicService;
    private List<ConsultDetail> consultDetails = new ArrayList<>();
    private void loadModels(Model model) {
        model.addAttribute("consult", new Consult());
        model.addAttribute("newdetail", new ConsultDetail());
        model.addAttribute("patients", patientService.findAll());
        model.addAttribute("medics", medicService.findAll());
        model.addAttribute("consultDetailsList", consultDetails);
        model.addAttribute("consultArray", service.findAll());
    }

    private void clearModels(Model model) {
        model.asMap().clear();
        consultDetails = new ArrayList<>();
        model.addAttribute("consult", new Consult());
        model.addAttribute("newdetail", new ConsultDetail());
        model.addAttribute("patients", patientService.findAll());
        model.addAttribute("medics", medicService.findAll());
        model.addAttribute("consultDetailsList", consultDetails);

    }

    @RequestMapping(value = "/consults")
    private String create(Model model){
        loadModels(model);
        return "newConsult";
    }

    @PostMapping("/createDetail")
    public String createDetails(@ModelAttribute ConsultDetail detail, Model model) {
        consultDetails.add(detail);
        loadModels(model);

        return "redirect:consults";
    }

    @PostMapping("/crearConsulta")
    public String createConsult(@ModelAttribute Consult c, Model model) {
        if (consultDetails.size() > 0){
            c.setDetails(consultDetails);
            service.saveTransactional(c);
            loadModels(model);
            clearModels(model);
            return "redirect:consults";
        }
        return "redirect:consults";
    }

    @RequestMapping(value = "/consultsList")
    private String consultList(Model model){
        loadModels(model);
        return "consultList";
    }


}