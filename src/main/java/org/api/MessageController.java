package org.api;

import java.util.Map;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    private final AtomicLong counter = new AtomicLong();
    private final Map<Long,Message> messageMap = new HashMap<Long,Message>();

    @RequestMapping(value="/message/:id", method=RequestMethod.GET)
    public Message getGreeting(long id) {
      Message rval = this.messageMap.get(id);
      return (rval == null ? Message.EMPTY : rval );
    }

    @RequestMapping(value="/message", method=RequestMethod.PUT)
    public Message putGreeting(String contents) {
      Message message = new Message(counter.incrementAndGet(),contents);
      this.messageMap.put(message.getId(),message);
      return message;
    }
}
