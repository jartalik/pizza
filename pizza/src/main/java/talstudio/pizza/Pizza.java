package talstudio.pizza;

import java.util.List;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class Pizza {
//    walidacja
    @NotNull
    @Size(min=5, message="Nazwa musi być minimum długa na pięć znaków!")
    private String name;
    @NotNull
    @Size(min=1, message="Musisz wskazać przynajmniej jeden składnik!")
    private List<Ingredient> ingredients;

}