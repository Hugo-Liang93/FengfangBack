package com.anteater.fengfang.service;

import com.anteater.fengfang.domains.calendar.EventLabel;
import com.anteater.fengfang.domains.calendar.Events;
import com.anteater.fengfang.domains.response.ResBody;

import java.util.List;

public interface CalendarService {
    List<Events> getUserEvent(String user_id);
    List<EventLabel> getLabel();
    ResBody updateEvents(Events events);
    void insertEvents(Events events);
    ResBody delEvents(String event_id);
}
