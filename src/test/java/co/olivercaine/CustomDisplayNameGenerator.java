package co.olivercaine;

import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import java.lang.reflect.Method;

import static org.junit.Assert.assertEquals;

public class CustomDisplayNameGenerator {

    @Test
    void makesCamelCaseTestMethodNamesMoreReadable(){
        assertEquals("Should convert camel case to readable sentence", CamelCaseDisplayNameGenerator.makeCamelCaseMoreReadable("shouldConvertCamelCaseToReadableSentence"));
    }

    static class CamelCaseDisplayNameGenerator extends DisplayNameGenerator.Standard {
        public CamelCaseDisplayNameGenerator() { }

        public String generateDisplayNameForMethod(Class<?> testClass, Method testMethod) {
            return makeCamelCaseMoreReadable(testMethod.getName());
        }

        static String makeCamelCaseMoreReadable(String camelCase) {
            camelCase = camelCase.replaceAll("([A-Z])", " $1"); // Separate CamelCasing to words
            camelCase = camelCase.replaceAll("([0-9]+)", " $1"); // Split numbers
            camelCase = camelCase.toLowerCase();
            camelCase = camelCase.substring(0, 1).toUpperCase() + camelCase.substring(1); // Capitalise beginning of sentence
            camelCase = camelCase.replaceAll("_", " "); // Remove underscores
            return camelCase;
        }
    }

}
