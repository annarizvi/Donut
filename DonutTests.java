package Project6;

import org.junit.Test;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class DonutTests {

    @Test
    public void Donut_instanceCountTest(){
        Donut testFan = new Donut();
        @SuppressWarnings("rawtypes")
        Class c = testFan.getClass();
        try {
            assertEquals(
                    "You must only have the instance variables specified. When looking at the number of instance variables we",
                    4, c.getDeclaredFields().length);
        }
        catch (Exception e) {
            fail("Something weird went wrong");
        }
    }

    @Test
    public void Donut_instanceVariablesTest(){
        Donut testDonut = new Donut();
        instanceVariablePrivate("size",testDonut);
        instanceVariablePrivate("flavor",testDonut);
        instanceVariablePrivate("icing",testDonut);
        instanceVariablePrivate("topping",testDonut);

        instanceVariableStatic("size",testDonut);
        instanceVariableStatic("flavor",testDonut);
        instanceVariableStatic("icing",testDonut);
        instanceVariableStatic("topping",testDonut);

        instanceVariableCorrectType("size",Size.class,testDonut);
        instanceVariableCorrectType("flavor",Flavor.class,testDonut);
        instanceVariableCorrectType("icing",Icing.class,testDonut);
        instanceVariableCorrectType("topping",Topping.class,testDonut);
    }

    @Test
    public void Donut_defaultConstructorTest() {
        Donut testDonut = new Donut();

        testVariable("size",testDonut,Size.REGULAR,"When checking the value of size we");
        testVariable("flavor",testDonut,Flavor.OLD_FASHIONED,"When checking the value of flavor we");
        testVariable("icing",testDonut,Icing.NONE,"When checking the value of icing we");
        testVariable("topping",testDonut,Topping.NONE,"When checking the value of topping we");
    }

    @Test
    public void Donut_parameterizedConstructorTest() {
        Donut testDonut = new Donut(Size.HOLE);

        testVariable("size",testDonut,Size.HOLE,"When checking the value of size we");
        testVariable("flavor",testDonut,Flavor.OLD_FASHIONED,"When checking the value of flavor we");
        testVariable("icing",testDonut,Icing.NONE,"When checking the value of icing we");
        testVariable("topping",testDonut,Topping.NONE,"When checking the value of topping we");
    }

    @Test
    public void Donut_getSizeTest() {
        Donut testDonut = createDonut(Size.LARGE,Flavor.CHOCOLATE,Icing.SUGAR_GLAZE,Topping.SPRINKLES);
        assertEquals("With an Donut object who's size instance variable is LARGE, when calling getSize we",Size.LARGE,testDonut.getSize());
    }

    @Test
    public void Donut_setSizeTest() {
        Donut testDonut = createDonut(Size.REGULAR,Flavor.APPLE,Icing.NONE,Topping.SPRINKLES);
        testDonut.setSize(Size.REGULAR);
        testVariable("size",testDonut,Size.REGULAR,"After calling Donut's setSize method with an argument of REGULAR, for the value of size we");
    }

    @Test
    public void Donut_getFlavorTest() {
        Donut testDonut = createDonut(Size.HOLE,Flavor.CHOCOLATE,Icing.NONE,Topping.POWDERED_SUGAR);
        assertEquals("With an Donut object who's flavor instance variable is CHOCOLATE, when calling getFlavor we",Flavor.CHOCOLATE,testDonut.getFlavor());
    }

    @Test
    public void Donut_setFlavorTest() {
        Donut testDonut = createDonut(Size.LARGE,Flavor.CHOCOLATE,Icing.NONE,Topping.SPRINKLES);
        testDonut.setFlavor(Flavor.APPLE);
        testVariable("flavor",testDonut,Flavor.APPLE,"After calling Donut's setFlavor method with an argument of APPLE, for the value of flavor we");
    }

    @Test
    public void Donut_getSauceTest() {
        Donut testDonut = createDonut(Size.LARGE,Flavor.CHOCOLATE,Icing.NONE,Topping.SPRINKLES);
        assertEquals("With an Donut object who's sauce instance variable is NONE, when calling getIcing we",Icing.NONE,testDonut.getIcing());
    }

    @Test
    public void Donut_setIcingTest() {
        Donut testDonut = createDonut(Size.LARGE,Flavor.CHOCOLATE,Icing.NONE,Topping.SPRINKLES);
        testDonut.setIcing(Icing.STRAWBERRY);
        testVariable("icing",testDonut,Icing.STRAWBERRY,"After calling Donut's setIcing method with an argument of STRAWBERRY, for the value of icing we");
    }

    @Test
    public void Donut_getToppingTest() {
        Donut testDonut = createDonut(Size.LARGE,Flavor.CHOCOLATE,Icing.NONE,Topping.SPRINKLES);
        assertEquals("With an Donut object who's topping instance variable is SPRINKLES, when calling getTopping we",Topping.SPRINKLES,testDonut.getTopping());
    }

    @Test
    public void Donut_setToppingTest() {
        Donut testDonut = createDonut(Size.LARGE,Flavor.CHOCOLATE,Icing.NONE,Topping.SPRINKLES);
        testDonut.setTopping(Topping.POWDERED_SUGAR);
        testVariable("topping",testDonut,Topping.POWDERED_SUGAR,"After calling Donut's setTopping method with an argument of POWDERED_SUGAR, for the value of topping we");
    }

    @Test
    public void Donut_toStringTest() {
        Donut testDonut = createDonut(Size.REGULAR,Flavor.CHOCOLATE,Icing.NONE,Topping.SPRINKLES);
        assertEquals(  "\n\tREGULAR\n" +
                "\tCHOCOLATE\n" +
                "\tNONE\n" +
                "\tSPRINKLES\n", testDonut.toString());

        testDonut = createDonut(Size.LARGE,Flavor.VANILLA,Icing.SUGAR_GLAZE,Topping.NUTS);
        assertEquals(  "\n\tLARGE\n" +
                "\tVANILLA\n" +
                "\tSUGAR_GLAZE\n" +
                "\tNUTS\n", testDonut.toString());
    }

    private Donut createDonut(Size aSize, Flavor aFlavor, Icing aIcing, Topping aTopping){
        Donut testDonut = new Donut();
        @SuppressWarnings("rawtypes")
        Class c = testDonut.getClass();

        try {
            Field size = c.getDeclaredField("size");
            size.setAccessible(true);
            size.set(testDonut, aSize);

            Field flavor = c.getDeclaredField("flavor");
            flavor.setAccessible(true);
            flavor.set(testDonut, aFlavor);

            Field icing = c.getDeclaredField("icing");
            icing.setAccessible(true);
            icing.set(testDonut, aIcing);

            Field topping = c.getDeclaredField("topping");
            topping.setAccessible(true);
            topping.set(testDonut, aTopping);

        } catch (Exception e) {
            fail(e.toString());
        }

        return testDonut;
    }

    private void instanceVariablePrivate(String aField, Object testObject) {
        @SuppressWarnings("rawtypes")
        Class c = testObject.getClass();
        try {
            c.getDeclaredField(aField);

            assertTrue("You must make your instance variables private.", Modifier.isPrivate(c.getDeclaredField(aField).getModifiers()));

        } catch (NoSuchFieldException e) {
            fail("Could not find the " + e.getLocalizedMessage() + " instance variable");
        } catch (Exception e) {
            fail("Something weird went wrong");
        }
    }

    private void instanceVariableStatic(String aField, Object testObject) {
        @SuppressWarnings("rawtypes")
        Class c = testObject.getClass();
        try {
            c.getDeclaredField(aField);

            assertEquals("Your instance variables must NOT be static.", false,
                    Modifier.isStatic(c.getDeclaredField(aField).getModifiers()));

        } catch (NoSuchFieldException e) {
            fail("Could not find the " + e.getLocalizedMessage() + " instance variable");
        } catch (Exception e) {
            fail("Something weird went wrong");
        }
    }

    private void instanceVariableCorrectType(String aField, Class<?> aClass,  Object testObject) {
        @SuppressWarnings("rawtypes")
        Class c = testObject.getClass();
        try {
            c.getDeclaredField(aField);

            assertEquals("You must make the speed instance variable of type"+ aClass.toString() +".", aClass, c.getDeclaredField(aField).getType());

        } catch (NoSuchFieldException e) {
            fail("Could not find the " + e.getLocalizedMessage() + " instance variable");
        } catch (Exception e) {
            fail("Something weird went wrong");
        }
    }

    private void testVariable(String aField, Object testObject, Object expected, String message){
        @SuppressWarnings("rawtypes")
        Class c = testObject.getClass();
        try {
            Field field = c.getDeclaredField(aField);
            field.setAccessible(true);
            Object fieldValue = field.get(testObject);

            if(expected == null){
                assertNull(message,fieldValue);
            }
            //If class is a double we have a special Junit assert to run
            else if(expected.getClass().equals(Double.class)){
                double doubleFieldValue = (double) fieldValue;
                double doubleExpected = (double) expected;
                assertEquals(message, doubleExpected, doubleFieldValue, .01);
            }
            //Array of some kind yay
            else if(expected.getClass().isArray()){

            }
            else if(expected.getClass().equals(ArrayList.class)){
                //CUSTOM FOR PROJECT6TESTS!!!
                testDonutArray(message,(ArrayList) expected, (ArrayList) fieldValue);
            }
            else{
                assertEquals(message, expected, fieldValue);
            }

        }
        catch (Exception e) {
            fail(e.toString());
        }
    }

    private void testDonutArray(String message, ArrayList expected, ArrayList actual){
        assertEquals(message + " looked at the size and ",expected.size(),actual.size());

        for(int i = 0; i < expected.size(); i++) {
            if (!DonutIsEqual(expected.get(i), actual.get(i))) {
                assertEquals(message, expected, actual);
            }
        }
    }

    private boolean DonutIsEqual(Object o1, Object o2){
        @SuppressWarnings("rawtypes")
        Class c = o1.getClass();
        try {
            Field sizeFieldo1 = c.getDeclaredField("size");
            sizeFieldo1.setAccessible(true);
            Object sizeo1 = sizeFieldo1.get(o1);

            Field sizeFieldo2 = c.getDeclaredField("size");
            sizeFieldo2.setAccessible(true);
            Object sizeo2 = sizeFieldo2.get(o2);

            Field flavorFieldo1 = c.getDeclaredField("flavor");
            flavorFieldo1.setAccessible(true);
            Object flavoro1 = flavorFieldo1.get(o1);

            Field flavorFieldo2 = c.getDeclaredField("flavor");
            flavorFieldo2.setAccessible(true);
            Object flavoro2 = flavorFieldo2.get(o2);

            Field icingFieldo1 = c.getDeclaredField("icing");
            icingFieldo1.setAccessible(true);
            Object icingo1 = icingFieldo1.get(o1);

            Field icingFieldo2 = c.getDeclaredField("icing");
            icingFieldo2.setAccessible(true);
            Object icingo2 = icingFieldo2.get(o2);

            Field toppingFieldo1 = c.getDeclaredField("topping");
            toppingFieldo1.setAccessible(true);
            Object toppingo1 = toppingFieldo1.get(o1);

            Field toppingFieldo2 = c.getDeclaredField("topping");
            toppingFieldo2.setAccessible(true);
            Object toppingo2 = toppingFieldo2.get(o2);

            if(sizeo1.equals(sizeo2) && flavoro1.equals(flavoro2) && icingo1.equals(icingo2) && toppingo1.equals(toppingo2)){
                return true;
            }
            else{
                return false;
            }


        } catch (NoSuchFieldException e) {
            fail("Could not find the " + e.getLocalizedMessage() + " instance variable");
        } catch (Exception e) {
            fail("Something weird went wrong");
        }

        return false;
    }

}