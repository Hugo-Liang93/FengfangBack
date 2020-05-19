package com.anteater.fengfang.mapper;

import com.anteater.fengfang.domains.Permission;
import com.anteater.fengfang.domains.calendar.EventLabel;
import com.anteater.fengfang.domains.calendar.Events;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CalendarMapper {
    List<EventLabel> getLabel();
    List<Events> getEvemtsByUser(String user_id);
    Boolean updateEvent(Events events);
    Boolean insertEvent(Events events);
    Boolean delEvent(String event_id);
}
