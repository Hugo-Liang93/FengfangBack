package com.anteater.fengfang.controller;

import com.anteater.fengfang.domains.calendar.EventLabel;
import com.anteater.fengfang.domains.calendar.Events;
import com.anteater.fengfang.domains.response.ResBody;
import com.anteater.fengfang.service.CalendarService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EventController {
    private static Logger logger= Logger.getLogger(EventController.class);
    @Autowired
    CalendarService calendarService;

    @RequestMapping(value = "/api/apps/calendar/labels",method = RequestMethod.GET)
    @ResponseBody
    public List<EventLabel> getLabels(){
        List<EventLabel> labels = calendarService.getLabel();
        return labels;
    }

    @RequestMapping(value = "/api/apps/calendar/events/{user_id}",method = RequestMethod.GET)
    @ResponseBody
    public List<Events> getEvents(@PathVariable String user_id){
        List<Events> labels = calendarService.getUserEvent(user_id);
        return labels;
    }

    @RequestMapping(value = "/api/apps/calendar/event/",method = RequestMethod.POST)
    @ResponseBody
    public ResBody editEvents(@RequestBody Events events){
        return calendarService.updateEvents(events);
    }

    @RequestMapping(value = "/api/apps/calendar/events/",method = RequestMethod.POST)
    @ResponseBody
    public Events addEvents(@RequestBody Events events){
        calendarService.insertEvents(events);
        return events;
    }

    @RequestMapping(value = "/api/apps/calendar/event/{event_id}",method = RequestMethod.DELETE)
    @ResponseBody
    public ResBody delEvents(@PathVariable String event_id){
        return calendarService.delEvents(event_id);
    }



}
