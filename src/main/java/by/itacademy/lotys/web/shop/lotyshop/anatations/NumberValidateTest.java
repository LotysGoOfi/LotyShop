package by.itacademy.lotys.web.shop.lotyshop.anatations;

import org.junit.jupiter.api.Test;

import static com.ibm.icu.impl.Assert.assrt;

class NumberValidateTest {

    static class TestValid {
        @NumberToString(number = 2)
        String nameOne;
        @NumberToString(number = 2)
        String nameTwo;
        TestValid(String nameOne,String nameTwo){
            this.nameOne = nameOne;
            this.nameTwo = nameTwo;
        }
    }

    @Test
    void validate() {
        TestValid testTrue = new TestValid("Vania","Pol");
        TestValid testTrue2 = new TestValid("Va","Port");
        TestValid testFalse = new TestValid("Vania","P");

        assrt(NumberValidate.validate(testTrue));
        assrt(!NumberValidate.validate(testFalse));
        assrt(NumberValidate.validate(testTrue2));
    }
}
