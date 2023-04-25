import io.smallrye.mutiny.Multi;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import javax.enterprise.context.ApplicationScoped;
import java.time.Duration;

@ApplicationScoped
public class HelloProducer {

    @Outgoing("hello")
    public Multi<String> hellos() {
        return Multi.createFrom().ticks().every(Duration.ofMillis(1000))
                .map(l -> "hello " + l)
                .onOverflow().drop();
    }

}
