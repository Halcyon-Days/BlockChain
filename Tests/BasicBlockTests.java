import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Test;

import io.github.halcyon_daze.blockchain.Block;
import io.github.halcyon_daze.blockchain.Transaction;

public class BasicBlockTests {

    @Test
    public void testBlock() {
        Block testBlock = new Block(1, new LinkedList<Transaction>(), "5000", "123456789");
        
        System.out.println(testBlock.toString());
    }

}
