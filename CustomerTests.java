package Project6;

import org.junit.Test;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class CustomerTests {

    @Test
    public void Customer_instanceCountTest(){
        Customer testCustomer = new Customer();
        @SuppressWarnings("rawtypes")
        Class c = testCustomer.getClass();
        try {
            assertEquals(
                    "You must only have the instance variables specified. When looking at the number of instance variables we",
                    5, c.getDeclaredFields().length);
        }
        catch (Exception e) {
            fail("Something weird went wrong");
        }
    }

    @Test
    public void Customer_instanceVariablesTest(){
        Customer testCustomer = new Customer();
        instanceVariablePrivate("lastName",testCustomer);
        instanceVariablePrivate("firstName",testCustomer);
        instanceVariablePrivate("phone",testCustomer);
        instanceVariablePrivate("email",testCustomer);
        instanceVariablePrivate("donuts",testCustomer);

        instanceVariableStatic("lastName",testCustomer);
        instanceVariableStatic("firstName",testCustomer);
        instanceVariableStatic("phone",testCustomer);
        instanceVariableStatic("email",testCustomer);
        instanceVariableStatic("donuts",testCustomer);

        instanceVariableCorrectType("lastName",String.class,testCustomer);
        instanceVariableCorrectType("firstName",String.class,testCustomer);
        instanceVariableCorrectType("phone",String.class,testCustomer);
        instanceVariableCorrectType("email",String.class,testCustomer);
        instanceVariableCorrectType("donuts",ArrayList.class,testCustomer);
    }

    @Test
    public void Customer_defaultConstructorTest() {
        Customer testCustomer = new Customer();

        testVariable("lastName",testCustomer,"","When checking the value of lastName we");
        testVariable("firstName",testCustomer,"","When checking the value of firstName we");
        testVariable("phone",testCustomer,"","When checking the value of phone we");
        testVariable("email",testCustomer,"","When checking the value of email we");
        testVariable("donuts",testCustomer,new ArrayList<>(),"When checking the value of donuts we");
    }

    @Test
    public void Customer_parameterizedConstructorTest() {
        Customer testCustomer = new Customer("Budwell","Caroline","804-937-8111","ccbudwell@vcu.edu");

        testVariable("lastName",testCustomer,"Budwell","When checking the value of lastName we");
        testVariable("firstName",testCustomer,"Caroline","When checking the value of firstName we");
        testVariable("phone",testCustomer,"804-937-8111","When checking the value of phone we");
        testVariable("email",testCustomer,"ccbudwell@vcu.edu","When checking the value of email we");
        testVariable("donuts",testCustomer,new ArrayList<>(),"When checking the value of donuts we");
    }

    @Test
    public void Customer_getLastNameTest() {
        ArrayList<Donut> someDonut = new ArrayList<>();
        Customer testCustomer = createCustomer("Sparks","Zach","978-281-8911","zwhitten@vcu.edu",someDonut);
        assertEquals("With a Customer object who's lastName instance variable is Sparks, when calling getLastName we","Sparks",testCustomer.getLastName());
    }

    @Test
    public void Customer_setLastNameTest() {
        ArrayList<Donut> someDonut = new ArrayList<>();
        Customer testCustomer = createCustomer("Whitten","Zach","978-281-8911","zwhitten@vcu.edu",someDonut);

        testCustomer.setLastName("Sparks");
        testVariable("lastName",testCustomer,"Sparks","After calling Customer's setLastName method with an argument of Sparks, for the value of lastName we");
    }

    @Test
    public void Customer_getFirstNameTest() {
        ArrayList<Donut> someDonut = new ArrayList<>();
        Customer testCustomer = createCustomer("Whitten","Zach","978-281-8911","zwhitten@vcu.edu",someDonut);
        assertEquals("With a Customer object who's firstName instance variable is Zach, when calling getFirstName we","Zach",testCustomer.getFirstName());
    }

    @Test
    public void Customer_setFirstNameTest() {
        ArrayList<Donut> someDonut = new ArrayList<>();
        Customer testCustomer = createCustomer("Sparks","Zach","978-281-8911","zwhitten@vcu.edu",someDonut);

        testCustomer.setFirstName("Clare");
        testVariable("firstName",testCustomer,"Clare","After calling Customer's setFirstName method with an argument of Clare, for the value of firstName we");
    }

    @Test
    public void Customer_getPhoneTest() {
        ArrayList<Donut> someDonut = new ArrayList<>();
        Customer testCustomer = createCustomer("Whitten","Zach","978-281-8911","zwhitten@vcu.edu",someDonut);
        assertEquals("With a Customer object who's phone instance variable is 978-281-8911, when calling getPhone we","978-281-8911",testCustomer.getPhone());
    }

    @Test
    public void Customer_setPhoneTest() {
        ArrayList<Donut> someDonut = new ArrayList<>();
        Customer testCustomer = createCustomer("Whitten","Zach","978-281-8911","zwhitten@vcu.edu",someDonut);

        testCustomer.setPhone("978-750-9785");
        testVariable("phone",testCustomer,"978-750-9785","After calling Customer's setPhone method with an argument of 978-750-9785, for the value of phone we");
    }

    @Test
    public void Customer_getEmailTest() {
        ArrayList<Donut> someDonut = new ArrayList<>();
        Customer testCustomer = createCustomer("Whitten","Zach","978-281-8911","zwhitten@vcu.edu",someDonut);
        assertEquals("With a Customer object who's email instance variable is zwhitten@vcu.edu, when calling getEmail we","zwhitten@vcu.edu",testCustomer.getEmail());
    }

    @Test
    public void Customer_setEmailTest() {
        ArrayList<Donut> someDonut = new ArrayList<>();
        Customer testCustomer = createCustomer("Whitten","Zach","978-281-8911","zwhitten@vcu.edu",someDonut);

        testCustomer.setEmail("zachary.whitten.11@cnu.edu");
        testVariable("email",testCustomer,"zachary.whitten.11@cnu.edu","After calling Customer's setEmail method with an argument of zachary.whitten.11@cnu.edu, for the value of email we");
    }

    @Test
    public void Customer_getNumDonutTest() {
        ArrayList<Donut> someDonut = new ArrayList<>();
        someDonut.add(createDonut(Size.LARGE,Flavor.CHOCOLATE,Icing.NONE,Topping.SPRINKLES));
        someDonut.add(createDonut(Size.LARGE,Flavor.APPLE,Icing.STRAWBERRY,Topping.SPRINKLES));
        Customer testCustomer = createCustomer("Whitten","Zach","978-281-8911","zwhitten@vcu.edu",someDonut);
        assertEquals("With a Customer object who's donuts instance variable is has two elements, when calling getNumDonut we",2,testCustomer.getNumDonut());
    }

    @Test
    public void Customer_getDonutTest() {
        ArrayList<Donut> someDonut = new ArrayList<>();
        someDonut.add(createDonut(Size.LARGE,Flavor.CHOCOLATE,Icing.NONE,Topping.SPRINKLES));
        someDonut.add(createDonut(Size.LARGE,Flavor.APPLE,Icing.STRAWBERRY,Topping.SPRINKLES));

        ArrayList<Donut> expectedDonut = new ArrayList<>();
        expectedDonut.add(createDonut(Size.LARGE,Flavor.CHOCOLATE,Icing.NONE,Topping.SPRINKLES));
        expectedDonut.add(createDonut(Size.LARGE,Flavor.APPLE,Icing.STRAWBERRY,Topping.SPRINKLES));

        Customer testCustomer = createCustomer("Whitten","Zach","978-281-8911","zwhitten@vcu.edu",someDonut);
        testDonutArray("With a Customer object who's donuts instance variable is has two elements, when calling getDonut we",expectedDonut,testCustomer.getDonut());
    }

    @Test
    public void Customer_orderDonutOneDonutTest() {
        ArrayList<Donut> someDonut = new ArrayList<>();

        ArrayList<Donut> expectedDonut = new ArrayList<>();
        expectedDonut.add(createDonut(Size.LARGE,Flavor.CHOCOLATE,Icing.NONE,Topping.SPRINKLES));
        Customer testCustomer = createCustomer("Whitten","Zach","978-281-8911","zwhitten@vcu.edu",someDonut);

        testCustomer.orderDonut(createDonut(Size.LARGE,Flavor.CHOCOLATE,Icing.NONE,Topping.SPRINKLES));

        testVariable("donuts",testCustomer,expectedDonut,"After a Customer object orders a single donut, when checking the donuts instance variable we");

    }

    @Test
    public void Customer_orderDonutFourDonutTest() {
        ArrayList<Donut> someDonut = new ArrayList<>();

        ArrayList<Donut> expectedDonut = new ArrayList<>();
        expectedDonut.add(createDonut(Size.LARGE,Flavor.CHOCOLATE,Icing.NONE,Topping.SPRINKLES));
        expectedDonut.add(createDonut(Size.REGULAR,Flavor.OLD_FASHIONED,Icing.CHOCOLATE,Topping.NUTS));
        expectedDonut.add(createDonut(Size.HOLE,Flavor.APPLE,Icing.STRAWBERRY,Topping.CANDY));
        expectedDonut.add(createDonut(Size.REGULAR,Flavor.VANILLA,Icing.SUGAR_GLAZE,Topping.CEREAL));
        Customer testCustomer = createCustomer("Whitten","Zach","978-281-8911","zwhitten@vcu.edu",someDonut);


        testCustomer.orderDonut(createDonut(Size.LARGE,Flavor.CHOCOLATE,Icing.NONE,Topping.SPRINKLES));
        testCustomer.orderDonut(createDonut(Size.REGULAR,Flavor.OLD_FASHIONED,Icing.CHOCOLATE,Topping.NUTS));
        testCustomer.orderDonut(createDonut(Size.HOLE,Flavor.APPLE,Icing.STRAWBERRY,Topping.CANDY));
        testCustomer.orderDonut(createDonut(Size.REGULAR,Flavor.VANILLA,Icing.SUGAR_GLAZE,Topping.CEREAL));

        testVariable("donuts",testCustomer,expectedDonut,"After a Customer object orders a single donut, when checking the donuts instance variable we");

    }

    @Test
    public void Customer_toStringTest() {
        ArrayList<Donut> someDonut = new ArrayList<>();
        someDonut.add(createDonut(Size.LARGE,Flavor.CHOCOLATE,Icing.NONE,Topping.SPRINKLES));
        Customer testCustomer = createCustomer("Whitten","Zach","978-281-8911","zwhitten@vcu.edu",someDonut);


        assertEquals(  "Zach Whitten\n" +
                "978-281-8911\n" +
                "zwhitten@vcu.edu\n" +
                "Donut Order:\n\n" +
                "\tLARGE\n" +
                "\tCHOCOLATE\n" +
                "\tNONE\n" +
                "\tSPRINKLES\n", testCustomer.toString());


        someDonut = new ArrayList<>();
        someDonut.add(createDonut(Size.LARGE,Flavor.CHOCOLATE,Icing.NONE,Topping.SPRINKLES));
        someDonut.add(createDonut(Size.REGULAR,Flavor.APPLE,Icing.CHOCOLATE,Topping.NUTS));
        someDonut.add(createDonut(Size.HOLE,Flavor.OLD_FASHIONED,Icing.SUGAR_GLAZE,Topping.POWDERED_SUGAR));
        someDonut.add(createDonut(Size.LARGE,Flavor.VANILLA,Icing.STRAWBERRY,Topping.CANDY));
        testCustomer = createCustomer("Sparks","Clare","978-281-8911","sparks.clare@gmail.com",someDonut);


        assertEquals(  "Clare Sparks\n" +
                "978-281-8911\n" +
                "sparks.clare@gmail.com\n" +
                "Donut Order:\n" +
                "\n" +
                "\tLARGE\n" +
                "\tCHOCOLATE\n" +
                "\tNONE\n" +
                "\tSPRINKLES\n" +
                "\n" +
                "\tREGULAR\n" +
                "\tAPPLE\n" +
                "\tCHOCOLATE\n" +
                "\tNUTS\n" +
                "\n" +
                "\tHOLE\n" +
                "\tOLD_FASHIONED\n" +
                "\tSUGAR_GLAZE\n" +
                "\tPOWDERED_SUGAR\n" +
                "\n" +
                "\tLARGE\n" +
                "\tVANILLA\n" +
                "\tSTRAWBERRY\n" +
                "\tCANDY\n", testCustomer.toString());
    }


    private Customer createCustomer(String aLastName, String aFirstName, String aPhone, String anEmail, ArrayList<Donut> someDonut){
        Customer testCustomer = new Customer();
        @SuppressWarnings("rawtypes")
        Class c = testCustomer.getClass();

        try {
            Field size = c.getDeclaredField("lastName");
            size.setAccessible(true);
            size.set(testCustomer, aLastName);

            Field flavor = c.getDeclaredField("firstName");
            flavor.setAccessible(true);
            flavor.set(testCustomer, aFirstName);

            Field phone = c.getDeclaredField("phone");
            phone.setAccessible(true);
            phone.set(testCustomer, aPhone);

            Field email = c.getDeclaredField("email");
            email.setAccessible(true);
            email.set(testCustomer, anEmail);

            Field donuts = c.getDeclaredField("donuts");
            donuts.setAccessible(true);
            donuts.set(testCustomer, someDonut);

        } catch (Exception e) {
            fail(e.toString());
        }

        return testCustomer;
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

            assertFalse("Your instance variables must NOT be static.", Modifier.isStatic(c.getDeclaredField(aField).getModifiers()));

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

            return sizeo1.equals(sizeo2) && flavoro1.equals(flavoro2) && icingo1.equals(icingo2) && toppingo1.equals(toppingo2);


        } catch (NoSuchFieldException e) {
            fail("Could not find the " + e.getLocalizedMessage() + " instance variable");
        } catch (Exception e) {
            fail("Something weird went wrong");
        }

        return false;
    }

}