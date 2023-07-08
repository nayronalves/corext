package br.com.corext.admcorext.controller;

import java.util.ArrayList;
import java.util.List;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.corext.admcorext.model.Decisoes;
import br.com.corext.admcorext.model.Serventias;
// import br.com.corext.admcorext.model.Style;
import br.com.corext.admcorext.repository.DecisoesRepository;
import br.com.corext.admcorext.repository.ServentiasRepository;

import java.util.regex.*;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private ServentiasRepository serventiasRepository;

    @Autowired
    private DecisoesRepository decisoesRepository;

    @GetMapping("/")
    public ModelAndView home() {
        // ModelAndView modelAndView = new ModelAndView("index.html");
        ModelAndView modelAndView = new ModelAndView("index.html");

        List<Decisoes> decisoes = decisoesRepository.findAll();
        modelAndView.addObject("decisoes", decisoes);

        List<Serventias> serventias = serventiasRepository.findAll();
        modelAndView.addObject("serventias", serventias);

        ArrayList<String> servInstaled = new ArrayList<>();
        ArrayList<String> servNotInstaled = new ArrayList<>();
        ArrayList<String> otherServ = new ArrayList<>();

        for (Serventias serv : serventias) {
            if (serv.getInstalacao() != null) {

                String servinsta = serv.getInstalacao();
                boolean pattern = Pattern.compile("^instalada", Pattern.UNICODE_CASE | Pattern.CASE_INSENSITIVE)
                        .matcher(servinsta).find();
                boolean patternNot = Pattern.compile("não instalada", Pattern.UNICODE_CASE | Pattern.CASE_INSENSITIVE)
                        .matcher(servinsta).find();

                if (pattern) {
                    servInstaled.add(servinsta.toLowerCase());
                } else if (patternNot) {
                    servNotInstaled.add(servinsta.toLowerCase());
                } else {
                    otherServ.add(servinsta.toLowerCase());
                }
            }
            // System.out.println(otherServ);
        }

        modelAndView.addObject("servInsta", servInstaled);
        modelAndView.addObject("servNotInsta", servNotInstaled);
        modelAndView.addObject("otherServ", otherServ);

        return modelAndView;
    }

    // @GetMapping("/login")
    // public ModelAndView loginSgext() {
    // ModelAndView modelAndView = new ModelAndView("/pages/sgext/login.html");
    // return modelAndView;
    // }

    @GetMapping("/index2")
    public ModelAndView home2() {
        ModelAndView modelAndView = new ModelAndView("index2.html");
        return modelAndView;
    }

    @GetMapping("/index3")
    public ModelAndView home3() {
        ModelAndView modelAndView = new ModelAndView("index3.html");
        return modelAndView;
    }

    @GetMapping("/iframe")
    public ModelAndView iframe() {
        ModelAndView modelAndView = new ModelAndView("iframe-dark.html");
        return modelAndView;
    }

    @GetMapping("/enhancedSearch")
    public ModelAndView enhanced() {
        ModelAndView modelAndView = new ModelAndView("pages/search/enhanced.html");

        return modelAndView;
    }

    @GetMapping("/enhancedSearchResult")
    public ModelAndView enhancedResult() {
        ModelAndView modelAndView = new ModelAndView("pages/search/enhanced-results.html");
        List<Decisoes> decisoes = decisoesRepository.findAll();
        modelAndView.addObject("decisoes", decisoes);

        return modelAndView;
    }

    @GetMapping("/tables/datatables")
    public ModelAndView datatables() {
        ModelAndView modelAndView = new ModelAndView("pages/tables/data.html");
        List<Serventias> serventias = serventiasRepository.findAll();

        modelAndView.addObject("serventias", serventias);

        return modelAndView;
    }

    @GetMapping("/tables/jsgrid")
    public ModelAndView jsgrid() {
        ModelAndView modelAndView = new ModelAndView("pages/tables/jsgrid.html");
        List<Serventias> serventias = serventiasRepository.findAll();

        modelAndView.addObject("serventias", serventias);

        return modelAndView;
    }

    @GetMapping("/tables/simple")
    public ModelAndView simpleTable() {
        ModelAndView modelAndView = new ModelAndView("pages/tables/simple.html");
        List<Serventias> serventias = serventiasRepository.findAll();

        modelAndView.addObject("serventias", serventias);

        return modelAndView;
    }

    @GetMapping("/search/simple")
    public ModelAndView simpleSearch() {
        ModelAndView modelAndView = new ModelAndView("pages/search/simple.html");
        // List<Decisoes> decisoes = decisoesRepository.findAll();
        // modelAndView.addObject("decisoes", decisoes);

        return modelAndView;
    }

    @GetMapping("/searchDec")
    public ModelAndView searchPublicDec() {
        ModelAndView modelAndView = new ModelAndView("pages/search/searchDec.html");
        // List<Decisoes> decisoes = decisoesRepository.findAll();
        // modelAndView.addObject("decisoes", decisoes);

        return modelAndView;
    }

    @GetMapping("/searchDecResults")
    public ModelAndView serachDecResult(@RequestParam("descricaoDecisao") String descricaoDecisao) {
        String title = "Resultado Pesquisa Decisões";

        ModelAndView modelAndView = new ModelAndView("pages/search/searchDecResults.html");
        List<Decisoes> decisoes = decisoesRepository.findDecisaoByDescricao(descricaoDecisao);
        modelAndView.addObject("decisoes", decisoes);
        modelAndView.addObject("title", title);

        return modelAndView;
    }

    @GetMapping("/search/simpleResult")
    public ModelAndView simpleSearchResult(@RequestParam("descricaoDecisao") String descricaoDecisao) {
        ModelAndView modelAndView = new ModelAndView("pages/search/simple-results.html");
        List<Decisoes> decisoes = decisoesRepository.findDecisaoByDescricao(descricaoDecisao);
        modelAndView.addObject("decisoes", decisoes);

        return modelAndView;
    }

}