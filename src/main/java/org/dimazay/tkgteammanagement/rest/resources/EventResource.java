package org.dimazay.tkgteammanagement.rest.resources;

import org.dimazay.tkgteammanagement.model.events.Event;
import org.dimazay.tkgteammanagement.persistence.interfaces.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.List;
import java.util.Properties;

/**
 * Created by Asterium on 13.06.2017.
 */
@RestController
@RequestMapping(ResourceConstants.EVENT_RESOURSE_PATH)
public class EventResource {

    @Autowired
    private EventRepository eventRepository;

    @Value("${rest.defaultPage}")
    private int defaultPage;

    @Value("${rest.defaultPageSize}")
    private int defaultPageSize;

    @RequestMapping(path = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Event> save(@RequestBody Event event) {
        eventRepository.save(event);
        return new ResponseEntity<Event>(event, HttpStatus.OK);
    }

    @RequestMapping(path = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Event>> listAllEvents(@Param("page") Integer page, @Param("size") Integer size) {

        int pageNumberToGet = page == null ? defaultPage : page;
        int pageSizeToGet = size == null ? defaultPageSize : size;

        Page<Event> domainPage = eventRepository.findAll(new PageRequest(pageNumberToGet, pageSizeToGet, Sort.Direction.DESC, "startDate"));
        List<Event> events = domainPage.getContent();
        return new ResponseEntity<List<Event>>(events, HttpStatus.OK);
    }

    @RequestMapping(path = "/{title}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Event> getEventByTitle(@PathVariable("title") String title) {
        Event response = eventRepository.findByTitle(title);
        return new ResponseEntity<Event>(response, HttpStatus.OK);
    }
}
