package talstudio.pizza.web;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import lombok.extern.slf4j.Slf4j;
import talstudio.pizza.Ingredient;
import talstudio.pizza.Type;
import talstudio.pizza.Pizza;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("tacoOrder")
public class DesignPizzaController {

    @ModelAttribute
    public void addIngredientsToModel(Model model) {
        List<Ingredient> ingredients = Arrays.asList(
                new Ingredient("GRU", "Grube ciasto", Type.CIASTO),
                new Ingredient("CIE", "Cienkie ciasto", Type.CIASTO),
                new Ingredient("BOC", "Boczek", Type.MIESO),
                new Ingredient("SAL", "Salami", Type.MIESO),
                new Ingredient("SZY", "Szynka", Type.MIESO),
                new Ingredient("TUN", "Tuńczyk", Type.RYBA),
                new Ingredient("MOZ", "Mozzarella", Type.SER),
                new Ingredient("PAR", "Parmezan", Type.SER),
                new Ingredient("SOS", "Sos pomidorowy", Type.SOS),
                new Ingredient("CEB", "Cebula", Type.WARZYWO)
        );

        Type[] types = Type.values();
        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type));
        }
    }

    @GetMapping
    public String showDesignForm(Model model) {
        model.addAttribute("pizza", new Pizza());

        return "design";
    }

    private Iterable<Ingredient> filterByType(List<Ingredient> ingredients, Type type) {
        return ingredients
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }

    @PostMapping
    public String processPizza(@Valid @ModelAttribute("pizza") Pizza pizza, Errors errors) {
        // Jeśli formularz zawiera błędy walidacji zwracany jest do poprawy
        if (errors.hasErrors()) {
            return "design";
        }
        // Save the taco...
        // We'll do this in chapter 3
        log.info("Przetwarzanie pizzy: " + pizza);

        return "redirect:/orders/current";
    }

}