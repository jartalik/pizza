package talstudio.pizza.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import talstudio.pizza.Ingredient;
import talstudio.pizza.Type;

@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {

    private Map<String, Ingredient> ingredientMap = new HashMap<>();

    public IngredientByIdConverter() {
        ingredientMap.put("GRU", new Ingredient("GRU", "Grube ciasto", Type.CIASTO));
        ingredientMap.put("CIE", new Ingredient("CIE", "Cienkie ciasto", Type.CIASTO));
        ingredientMap.put("BOC", new Ingredient("BOC", "Boczek", Type.MIESO));
        ingredientMap.put("SAL", new Ingredient("SAL", "Salami", Type.MIESO));
        ingredientMap.put("SZY", new Ingredient("SZY", "Szynka", Type.MIESO));
        ingredientMap.put("TUN", new Ingredient("TUN", "Tuńczyk", Type.RYBA));
        ingredientMap.put("MOZ", new Ingredient("MOZ", "Mozzarella", Type.SER));
        ingredientMap.put("PAR", new Ingredient("PAR", "Parmezan", Type.SER));
        ingredientMap.put("SOS", new Ingredient("SOS", "Sos pomidorowy", Type.SOS));
        ingredientMap.put("CEB", new Ingredient("CEB", "Cebula", Type.WARZYWO));


    }

    @Override
    public Ingredient convert(String id) {
        return ingredientMap.get(id);
    }

}