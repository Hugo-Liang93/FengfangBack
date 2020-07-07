package com.anteater.fengfang.service;

import com.anteater.fengfang.domains.Clockin;
import com.anteater.fengfang.domains.response.ResBody;

import java.util.List;

public interface ClockInService {
    ResBody clockIn(Clockin clockin);
    List<Clockin> getTodayClockIn(String user_id);
    List<Clockin> getThisMonthClockInListByUid(String user_id);
}
