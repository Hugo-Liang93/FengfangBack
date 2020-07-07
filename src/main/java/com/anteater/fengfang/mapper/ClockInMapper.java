package com.anteater.fengfang.mapper;

import com.anteater.fengfang.domains.Clockin;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClockInMapper {
    Integer insertClockIn(Clockin clockin,String clockinType);
    List<Clockin> getTodayClockIn(String user_id);
    List<Clockin> getThisMonthClockInListByUid(String user_id);
}
