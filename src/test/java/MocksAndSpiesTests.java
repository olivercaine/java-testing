
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

class ClassUnderTest {
    static final String RESPONSE_REAL = "RESPONSE_REAL";
    String aMethod() {
        return RESPONSE_REAL;
    }
}

class MocksAndSpiesTests {

    private static final String RESPONSE_MOCKED = "RESPONSE_MOCKED";

    private static final String RESPONSE_SPY = "RESPONSE_SPY";


    @Test
    void givenARealClass_whenCallingAMethod_thenResponseShouldBeReal() {
        // Arrange
        ClassUnderTest classUnderTest = new ClassUnderTest();

        // Act
        String result = classUnderTest.aMethod();

        // Assert
        assertEquals(ClassUnderTest.RESPONSE_REAL, result);
    }

    @Test
    void givenAMockedClass_whenCallingAMethod_thenResponseShouldBeNull() {
        // Arrange
        ClassUnderTest classUnderTest = Mockito.mock(ClassUnderTest.class);

        // Act
        String result = classUnderTest.aMethod();

        // Assert
        assertNull(result);
    }

    @Test
    void givenAMockedClassWithMockedMethod_whenCallingAMethod_thenResponseShouldMocked() {
        // Arrange
        ClassUnderTest classUnderTest = Mockito.mock(ClassUnderTest.class);
        Mockito.when(classUnderTest.aMethod()).thenReturn(RESPONSE_MOCKED);

        // Act
        String result = classUnderTest.aMethod();

        // Assert
        assertEquals(RESPONSE_MOCKED, result);
    }

    @Test
    void givenAMockedClassWithRealMethodCalled_whenCallingAMethod_thenResponseShouldReal() {
        // Arrange
        ClassUnderTest classUnderTest = Mockito.mock(ClassUnderTest.class);
        when(classUnderTest.aMethod()).thenCallRealMethod();

        // Act
        String result = classUnderTest.aMethod();

        // Assert
        assertEquals(ClassUnderTest.RESPONSE_REAL, result);
    }

    @Test
    void givenASpyClass_whenCallingAMethod_thenResponseShouldBeReal() {
        // Arrange
        ClassUnderTest classUnderTest = Mockito.spy(ClassUnderTest.class);

        // Act
        String result = classUnderTest.aMethod();

        // Assert
        assertEquals(ClassUnderTest.RESPONSE_REAL, result);
    }

    @Test
    void givenASpyClassWithASpyMethod_whenCallingAMethod_thenResponseShouldBeSpy() {
        // Arrange
        ClassUnderTest classUnderTest = Mockito.spy(ClassUnderTest.class);
        Mockito.when(classUnderTest.aMethod()).thenReturn(RESPONSE_SPY);

        // Act
        String result = classUnderTest.aMethod();

        // Assert
        assertEquals(RESPONSE_SPY, result);
    }
}