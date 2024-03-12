package tp.tva.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.DecimalFormat;

@Controller
// @RequestMapping : permet de définir un préfixe d'url sur toutes les méthdoes du controller @GetMapping / @PostMapping
@RequestMapping("/tva")
public class TvaController {


    @GetMapping
    public String getTva(){
        return "tva";
    }

    @PostMapping
    public String postTva(@RequestParam double prixHT, @RequestParam double taux, Model model){

      //  System.out.println("Prix HT: " + prixHT);
       // System.out.println("Taux TVA : " + taux);

        System.out.println("PrixTTC : " + prixHT + prixHT*taux);
        double ttc = (prixHT + prixHT*taux/100);

        model.addAttribute("ttc",  new DecimalFormat("0.00").format(ttc) + " €");

        return "tva";
    }

}
