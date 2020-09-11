package co.olivercaine;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

class StaticClassWrapper {
    public static void main(String[] args) {
        StaticClass.aMethod();
    }
}

class StaticClass {
    private StaticClass() { }
    static void aMethod() {
        System.out.println("Static aMethod() called");
    }
}

@RunWith(PowerMockRunner.class)
@PrepareForTest(StaticClass.class)
public class StaticClassTests {

    @Test
    public void should_be_able_to_assert_static_method_called() {
        // Arrange
        PowerMockito.mockStatic(StaticClass.class);

        // Act
        StaticClassWrapper.main(null);

        // Assert
        PowerMockito.verifyStatic(StaticClass.class, Mockito.times(1));
        StaticClass.aMethod();
    }
}
