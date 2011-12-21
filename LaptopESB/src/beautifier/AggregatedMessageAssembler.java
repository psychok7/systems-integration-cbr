package beautifier;

import org.jboss.soa.esb.actions.AbstractActionPipelineProcessor;
import org.jboss.soa.esb.actions.ActionProcessingException;
import org.jboss.soa.esb.helpers.ConfigTree;
import org.jboss.soa.esb.message.Attachment;
import org.jboss.soa.esb.message.Message;
import org.jboss.soa.esb.util.Util;

import java.io.File;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Assemble an aggregated message.
 * <p/>
 * This is just an example.  Of course a real worl example would do something more
 * useful than just append the messages together in a StringBuffer!
 *
 * @author <a href="mailto:tom.fennelly@jboss.com">tom.fennelly@jboss.com</a>
 */
public class AggregatedMessageAssembler extends AbstractActionPipelineProcessor {

    public AggregatedMessageAssembler(ConfigTree config) {
    }

    public Message process(Message message) throws ActionProcessingException {
        Attachment attachments = message.getAttachment();
        int attachmentCount = attachments.getUnnamedCount();
        Map<String, String> assemblyBuffer = new HashMap<String, String>();

        for (int i = 0; i < attachmentCount; i++) {
            try {
                Message aggrMessage = Util.deserialize((Serializable) attachments.itemAt(i));
                @SuppressWarnings("unchecked")
				Map<String, String> payload = (Map<String, String>) aggrMessage.getBody().get();
                for(String s: payload.keySet())                
                	assemblyBuffer.put(s,payload.get(s));
                
            } catch (Exception e) {
                // Not an aggregated message attachment... continue...
            }
        }

        message.getBody().add(assemblyBuffer);

        return message;
    }
}
