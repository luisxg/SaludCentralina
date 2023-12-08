package lgonzalez.saludcentralina.controller;

import lgonzalez.saludcentralina.model.Patient;
import lgonzalez.saludcentralina.service.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class PatientController {
    @Autowired
    private IPatientService service;

    @RequestMapping(value = "/patients")
    private String findAll(Model model){
        List<Patient> patientList = service.findAll();
        model.addAttribute("patients", patientList);
        model.addAttribute("editedPatient", new Patient());

        return "patients";
    }

    @GetMapping("/findById")
    public String findById(@RequestParam(name = "id", required = false) Integer id, Model model) {
        if (id != null) {
            Patient obj = service.findById(id);
            model.addAttribute("patientById", obj);
            model.addAttribute("editedPatient", new Patient());
        }else{
            List<Patient> patientList = service.findAll();
            model.addAttribute("patients", patientList);
            return "redirect:/patients";
        }
        return "patients";
    }

    @PostMapping("/deletePatient")
    public String delete(@RequestParam("id") Integer id) {
        service.delete(id);
        return "redirect:/patients";
    }

    @ModelAttribute("newPatient")
    public Patient createObject() {
        return new Patient();
    }

    @PostMapping("/savePatient")
    public String addPatient(@ModelAttribute("newPatient") Patient p) {
        service.save(p);
        return "redirect:/patients";
    }

    @GetMapping("/editPatient")
    public String editPatientForm(@RequestParam(name = "id", required = false) Integer id, Model model) {
        if (id != null) {
            Patient patient = service.findById(id);
            model.addAttribute("editedPatient", patient);
        } else {
            model.addAttribute("editedPatient", new Patient());
        }
        return "patients";
    }
}






















