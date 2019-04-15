package org.api;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    private final AtomicLong counter = new AtomicLong();
    private final Map<Long,Message> messageMap = new HashMap<Long,Message>();

    @RequestMapping(value="/message/:id", method=RequestMethod.GET)
    public Message getGreeting(@PathVariable("id") long id) {
      Message rval = this.messageMap.get(id);
      return (rval == null ? Message.EMPTY : rval );
    }

    @RequestMapping(value="/message", method=RequestMethod.PUT)
    public Message putGreeting(@RequestBody String content) {
      Message message = new Message(counter.incrementAndGet(),content);
      this.messageMap.put(message.getId(),message);
      return message;
    }
}
