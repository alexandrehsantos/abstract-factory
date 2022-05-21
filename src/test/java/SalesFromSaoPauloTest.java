import com.bulvee.abstractfactory.sales.Sales;
import com.bulvee.abstractfactory.sales.SalesModuleFactory;
import com.bulvee.abstractfactory.sales.impl.StoreFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class SalesFromSaoPauloTest {

    private SalesModuleFactory salesModuleFactory;
    private Sales sales;
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();


    @BeforeEach
    void setup() {
        this.salesModuleFactory = new StoreFactory("/config_sp.properties");
        this.sales = new Sales(salesModuleFactory);
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void givenConfigSaoPaulo_whenMakeSale_valid() {
        sales.make();
        Assertions.assertTrue(outputStreamCaptor.toString().contains("São Paulo"));
        Assertions.assertTrue(outputStreamCaptor.toString().contains("tax"));
        Assertions.assertTrue(outputStreamCaptor.toString().contains("ticket"));

    }


}
