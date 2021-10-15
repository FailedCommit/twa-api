import com.intuit.karate.junit5.Karate;
import com.twa.flights.api.itineraries.search.ItenerariesSearchApp;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import java.util.Objects;

class ItinerariesSearchAppIT {
    private static ConfigurableApplicationContext context;

    @AfterAll
    static void afterClass() {
        context.close();
    }

    @Karate.Test
    Karate runAllTests() {
        return Karate.run().tags("~@ignore").relativeTo(getClass());
    }

    @BeforeAll
    static void beforeClass() {
        if (context == null) {
            context = ItenerariesSearchApp.run(new String[] { "--server.port=0" });
            Environment env = context.getBean(Environment.class);
            System.setProperty("ItinerariesSearchAppIT.server.port", Objects.requireNonNull(env.getProperty("local.server.port")));
        }
    }
}
