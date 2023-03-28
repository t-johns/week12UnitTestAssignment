import java.util.Random;

public class TestDemo {


  public int addPositive(int a, int b) {
    if (a <= 0 || b <= 0) { // if 0 or less
       throw new IllegalArgumentException("Both parameters must be positive!"); // throw exception
    }
    return (a + b); // intended operation and result

  }
  
  
  public int randomNumberSquared() { // randomly generate number and square it
    int number = getRandomInt(); // commit number to variable
    int squared = number * number; // square
    return squared; // return
  }
  
  
  public int getRandomInt() { // supporting method for random Int generation
    
    Random random = new Random(); // new Random object
    
    return random.nextInt(10) + 1; // nextInt to generate number from index(0) to provided int
                                   // +1 to offset index
  }
}
