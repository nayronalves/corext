package br.com.corext.admcorext.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.corext.admcorext.model.Faq;
import br.com.corext.admcorext.model.Serventias;
import br.com.corext.admcorext.model.Style;
import br.com.corext.admcorext.repository.FaqRepository;
import br.com.corext.admcorext.repository.ServentiasRepository;

// import java.util.regex.*;

@Controller
@RequestMapping("/sgext/")
public class SgextController {

    @Autowired
    private ServentiasRepository serventiasRepository;

    @Autowired
    private FaqRepository faqRepository;

    @GetMapping("/")
    public ModelAndView home() {

        ModelAndView modelAndView = new ModelAndView("pages/sgext/indsgext.html");

        List<Serventias> serventias = serventiasRepository.findAll();
        List<Serventias> serventias2 = serventiasRepository.findByResponsavelIsNotNull();
        List<Faq> faqs = faqRepository.findAll();
        modelAndView.addObject("serventiasAll", serventias);
        modelAndView.addObject("serventiasRespNoNull", serventias2);
        modelAndView.addObject("faqs", faqs);

        return modelAndView;
    }

    @PutMapping("/faq")
    public String putFaq(Faq faq, Model model) {

        Faq faq2 = faqRepository.getReferenceById(faq.getId());
        String action = "ALTERADO";
        System.out.println("REGISTRO ANTERIOR => " + faq2);

        faq2.setQuestion(faq.getQuestion());
        faq2.setAnswer(faq.getAnswer());
        faq2.setImportance(faq.getImportance());

        model.addAttribute("action", action);

        System.out.println("REGISTRO MODIFICADO => " + faq);
        faqRepository.save(faq2);
        return "redirect:faq";
    }

    @DeleteMapping("/faq/{id}")
    public String delete(@ModelAttribute @PathVariable Long id, Model model) {
        // entityClassName savedItem = repository.save(item);
        Faq f = faqRepository.getReferenceById(id);
        String action = "EXCLUÍDO";

        model.addAttribute("faq", f);
        model.addAttribute("action", action);
        faqRepository.delete(f);
        System.out.println(f);

        return "pages/sgext/faqFormRes";
    }

    @GetMapping("listserv-sgext")
    public ModelAndView listServ() {
        ModelAndView modelAndView = new ModelAndView("pages/sgext/listServ-sgext.html");
        // modelAndView.addObject("decisoes", decisoes);
        List<Serventias> serventias = serventiasRepository.findAll();

        modelAndView.addObject("serventias", serventias);

        return modelAndView;
    }

    @GetMapping("contact")
    public ModelAndView contact() {
        ModelAndView modelAndView = new ModelAndView("pages/sgext/contact-us.html");
        // modelAndView.addObject("decisoes", decisoes);

        return modelAndView;
    }

    @GetMapping("contacts-sgext")
    public ModelAndView contactsServ() {
        ModelAndView modelAndView = new ModelAndView("pages/sgext/contacts-sgext.html");
        // modelAndView.addObject("decisoes", decisoes);
        List<Serventias> serventias = serventiasRepository.findByResponsavelIsNotNull();

        modelAndView.addObject("serventias", serventias);

        return modelAndView;
    }

    @GetMapping("faq")
    public ModelAndView faqServ(Model model) {
        ModelAndView modelAndView = new ModelAndView("pages/sgext/faq-sgext.html");

        Faq newFaq = new Faq();

        Style[] cssStyle = {
                new Style("cssStyle1", "bg-info"),
                new Style("cssStyle2", "bg-teal")
        };

        String[] importance = { "warning", "danger", "primary", "success" };

        List<Serventias> serventias = serventiasRepository.findAll();

        List<Faq> faqs = faqRepository.findAll();

        modelAndView.addObject("serventias", serventias);
        modelAndView.addObject("cssStyle", cssStyle);
        modelAndView.addObject("faqs", faqs);
        modelAndView.addObject("importances", importance);

        model.addAttribute("newFaq", newFaq);

        return modelAndView;
    }

    @GetMapping("faq-form")
    public ModelAndView faqForm(Model model) {
        ModelAndView modelAndView = new ModelAndView("pages/sgext/faqForm.html");

        model.addAttribute("faq", new Faq());

        Style[] cssStyle = {
                new Style("cssStyle1", "bg-info"),
                new Style("cssStyle2", "bg-teal")
        };

        List<Serventias> serventias = serventiasRepository.findAll();

        String[] importance = { "warning", "danger", "info", "success" };

        List<Faq> faqs = faqRepository.findAll();

        modelAndView.addObject("serventias", serventias);
        modelAndView.addObject("cssStyle", cssStyle);
        modelAndView.addObject("faqs", faqs);
        modelAndView.addObject("importances", importance);

        // System.out.println(cssStyle[0].getNameClass());

        return modelAndView;
    }

    @PostMapping("faqForm")
    public String faqFormSave(@ModelAttribute Faq faq, Model model) {
        String action = "CADASTRADO";

        model.addAttribute("faq", faq);
        model.addAttribute("action", action);

        faqRepository.save(faq);

        System.out.println(faq);

        return "pages/sgext/faqFormRes";
    }

    // @GetMapping("upFile")
    // public ModelAndView upFile(){
    //     ModelAndView modelAndView = new ModelAndView("/pages/sgext/upFile-sgext.html");

    //     return modelAndView;
    // }

}
