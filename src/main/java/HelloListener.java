import io.quarkus.logging.Log;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Message;

import javax.enterprise.context.ApplicationScoped;
import java.util.concurrent.CompletionStage;

@ApplicationScoped
public class HelloListener {

    @Incoming("hello")
    public CompletionStage<Void> process(Message<String> msg) {
        Log.info("Received: " + msg.getPayload());
        return msg.ack();
    }

}
