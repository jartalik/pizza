package talstudio.pizza;

import java.util.List;
import java.util.ArrayList;
import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class PizzaOrder {

    @NotBlank(message="Nazwa dostawy jest wymagany!")
    private String deliveryName;

    @NotBlank(message="Nazwa ulicy jest wymagana")
    private String deliveryStreet;

    @NotBlank(message="Miejscowość jest wymagana")
    private String deliveryCity;

    @NotBlank(message="Województwo jest wymagane")
    private String deliveryState;

    @NotBlank(message="Kod pocztowy jest wymagany")
    private String deliveryZip;

    @CreditCardNumber(message="Błędny numer karty")
    private String ccNumber;

    @Pattern(regexp="^(0[1-9]|1[0-2])([\\/])([1-9][0-9])$",
            message="Format daty MM/YY")
    private String ccExpiration;

    @Digits(integer=3, fraction=0, message="Błędny CVV")
    private String ccCVV;


    private List<Pizza> pizza = new ArrayList<>();

    public void addPizza(Pizza pizza) {
        this.pizza.add(pizza);
    }
}