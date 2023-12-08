package lgonzalez.saludcentralina.controller;

import lgonzalez.saludcentralina.model.Medic;
import lgonzalez.saludcentralina.service.IMedicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MedicController {
    @Autowired
    private IMedicService service;

    @RequestMapping(value = "/medics")
    private String findAll(Model model){
        List<Medic> medicList = service.findAll();
        model.addAttribute("medics", medicList);
        model.addAttribute("editedMedic", new Medic());

        return "medics";
    }

    @GetMapping("/findByIdMedic")
    public String findById(@RequestParam(name = "id", required = false) Integer id, Model model) {
        if (id != null) {
            Medic obj = service.findById(id);
            model.addAttribute("medicById", obj);
            model.addAttribute("editedMedic", new Medic());
        }else{
            List<Medic> medicList = service.findAll();
            model.addAttribute("medics", medicList);
            return "redirect:/medics";
        }
        return "medics";
    }

    @PostMapping("/deleteMedic")
    public String delete(@RequestParam("id") Integer id) {
        service.delete(id);
        return "redirect:/medics";
    }

    @ModelAttribute("newMedic")
    public Medic createObject() {
        return new Medic();
    }

    @PostMapping("/saveMedic")
    public String addMedic(@ModelAttribute("newMedic") Medic m) {
        service.save(m);
        return "redirect:/medics";
    }

    @GetMapping("/editMedic")
    public String editMedicForm(@RequestParam(name = "id", required = false) Integer id, Model model) {
        if (id != null) {
            Medic medic = service.findById(id);
            model.addAttribute("editedMedic", medic);
        } else {
            model.addAttribute("editedMedic", new Medic());
        }
        return "medics";
    }
}






















