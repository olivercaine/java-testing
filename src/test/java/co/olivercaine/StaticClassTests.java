package co.olivercaine;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.powermock.api.mockito.PowerMockito.when;

class StaticClassWrapper {
    static String callStaticClassMethod() {
        return StaticClass.doSomeStuff();
    }
}

class StaticClass {
    private StaticClass() { }

    static String doSomeStuff() {
        System.out.println("Static aMethod() called");
        return "Real aMethod() called";
    }

}

@RunWith(PowerMockRunner.class)
@PrepareForTest(StaticClass.class)
public class StaticClassTests {

    @Test
    public void assertsStaticMethodCalled() {
        // Arrange
        PowerMockito.mockStatic(StaticClass.class);

        // Act
        StaticClassWrapper.callStaticClassMethod();

        // Assert
        PowerMockito.verifyStatic(StaticClass.class, Mockito.times(1));
        StaticClass.doSomeStuff();
    }

    @Test
    public void mocksStaticMethod() {
        // Arrange
        PowerMockito.mockStatic(StaticClass.class);
        when(StaticClass.doSomeStuff()).thenReturn("Mocked return string from static method");

        // Act
        String returnedString = StaticClassWrapper.callStaticClassMethod();

        // Assert
        assertEquals("Mocked return string from static method", returnedString);
    }
}
