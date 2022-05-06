package Project6;

import org.junit.Test;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class EnumTests {

    @Test
    public void SizeTest() {
        try {
            Size.valueOf("REGULAR");
            Size.valueOf("LARGE");
            Size.valueOf("HOLE");
        }
        catch(IllegalArgumentException e) {
            fail(e.getLocalizedMessage());
        }
        assertEquals("When looking at the number of values in the Size enum, we",3,Size.values().length);
    }

    @Test
    public void FlavorTest() {
        try {
            Flavor.valueOf("OLD_FASHIONED");
            Flavor.valueOf("VANILLA");
            Flavor.valueOf("CHOCOLATE");
            Flavor.valueOf("APPLE");
        }
        catch(IllegalArgumentException e) {
            fail(e.getLocalizedMessage());
        }
        assertEquals("When looking at the number of values in the Flavor enum, we",4,Flavor.values().length);
    }

    @Test
    public void IcingTest() {
        try {
            Icing.valueOf("NONE");
            Icing.valueOf("SUGAR_GLAZE");
            Icing.valueOf("CHOCOLATE");
            Icing.valueOf("STRAWBERRY");
        }
        catch(IllegalArgumentException e) {
            fail(e.getLocalizedMessage());
        }
        assertEquals("When looking at the number of values in the Icing enum, we",4,Icing.values().length);
    }

    @Test
    public void ToppingTest() {
        try {
            Topping.valueOf("NONE");
            Topping.valueOf("SPRINKLES");
            Topping.valueOf("NUTS");
            Topping.valueOf("POWDERED_SUGAR");
            Topping.valueOf("CEREAL");
            Topping.valueOf("CANDY");
        }
        catch(IllegalArgumentException e) {
            fail(e.getLocalizedMessage());
        }
        assertEquals("When looking at the number of values in the Topping enum, we",6,Topping.values().length);
    }

}