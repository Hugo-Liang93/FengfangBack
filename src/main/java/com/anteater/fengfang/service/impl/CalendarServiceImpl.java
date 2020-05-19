package com.anteater.fengfang.service.impl;

import com.anteater.fengfang.controller.EventController;
import com.anteater.fengfang.domains.calendar.EventLabel;
import com.anteater.fengfang.domains.calendar.Events;
import com.anteater.fengfang.domains.response.ResBody;
import com.anteater.fengfang.mapper.CalendarMapper;
import com.anteater.fengfang.service.CalendarService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalendarServiceImpl implements CalendarService {
    private static Logger logger= Logger.getLogger(CalendarServiceImpl.class);
    @Autowired
    CalendarMapper calendarMapper;
    @Autowired
    ResBody resBody;
    @Override
    public List<Events> getUserEvent(String user_id) {
        return calendarMapper.getEvemtsByUser(user_id);
    }

    @Override
    public List<EventLabel> getLabel() {
        return calendarMapper.getLabel();
    }

    @Override
    public ResBody updateEvents(Events events) {
        Boolean success = calendarMapper.updateEvent(events);
        resBody.setStatus(success);
        if (!success) {
            resBody.setErrorMsg("更新不成功");
        }
        return resBody;
    }

    @Override
    public void insertEvents(Events events) {
        calendarMapper.insertEvent(events);
    }

    @Override
    public ResBody delEvents(String event_id) {
        resBody.setStatus(calendarMapper.delEvent(event_id));
        return resBody;
    }


}
