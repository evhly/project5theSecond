import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class CharacterTest {
    @Test
    public void takeDamageTest(){
        Hero h = new Hero(10,"testChar", 5);
        h.takeDamage(4);
        Assertions.assertEquals(6,h.health);
    }
    @Test
    public void isDeadTest(){
        Hero h = new Hero(10,"testChar", 5);
        h.takeDamage(10);
        Assertions.assertEquals(0,h.health);
    }

}
//restore health method