import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TestDemoTest {

  private TestDemo testDemo;

  @BeforeEach
  void setUp() throws Exception {
    testDemo = new TestDemo(); //provide new object each test
  }

  @ParameterizedTest
  @MethodSource("TestDemoTest#argumentsForAddPositive") //path
  void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, 
      Boolean expectException) {
    // Given: two positive numbers

    // When: the addPositive method is called

    // Then: assert that the two positive numbers are added correctly

    if (!expectException) {
      assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
      
    } else {
      assertThatThrownBy(() -> testDemo.addPositive(a, b))
          .isInstanceOf(IllegalArgumentException.class);

    }
  }

  public static Stream<Arguments> argumentsForAddPositive() { // test cases to prove working viablity
    
    return Stream.of(
        arguments(2, 4, 6, false),
        arguments(1, 9, 10, false),
        arguments(0, 1, 1, true),
        arguments(3, 0, 3, true),
        arguments(-3, 4, 1, true),
        arguments(0, -4, -4, true)
        );
  }
  
  @Test
  void assertThatNumberSquaredIsCorrect() { // squared number test 
    TestDemo mockDemo = spy(testDemo);
    int a = 5;
    
    
    doReturn(a).when(mockDemo).getRandomInt();
    
    int fiveSquared = mockDemo.randomNumberSquared();
    
    assertThat(fiveSquared).isEqualTo(25);
    
  }

}
