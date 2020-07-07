package com.anteater.fengfang.mapper;

import com.anteater.fengfang.domains.Clockin;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClockInMapper {
    Integer insertClockIn(Clockin clockin);
    Clockin getTodayClockIn(String user_id,String clockinType);
    List<Clockin> getThisMonthClockInListByUid(String user_id);
}
