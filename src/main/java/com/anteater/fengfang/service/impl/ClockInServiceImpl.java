package com.anteater.fengfang.service.impl;

import com.anteater.fengfang.controller.UserController;
import com.anteater.fengfang.domains.Clockin;
import com.anteater.fengfang.domains.response.ResBody;
import com.anteater.fengfang.mapper.ClockInMapper;
import com.anteater.fengfang.service.ClockInService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

@Service
public class ClockInServiceImpl implements ClockInService {
    private static Logger logger= Logger.getLogger(ClockInServiceImpl.class);

    final static String Fail_MSG = "非打卡时间";
    @Autowired
    ClockInMapper clockInMapper;
    @Override
    public ResBody clockIn(Clockin clockin) {
        ResBody resBody = new ResBody();
        Calendar calendar =Calendar.getInstance();
        int curHour24 = calendar.get(calendar.HOUR_OF_DAY);
        if(curHour24>=9 && curHour24 <12){
            clockInMapper.insertClockIn(clockin,"morning");
            resBody.setStatus(true);
        }else if(curHour24>=16 && curHour24<20) {
            clockInMapper.insertClockIn(clockin,"night");
            resBody.setStatus(true);
        } else {
            resBody.setStatus(false);
            resBody.setErrorMsg(Fail_MSG);
        }
        return resBody;
    }

    @Override
    public List<Clockin> getTodayClockIn(String user_id) {
        return clockInMapper.getTodayClockIn(user_id);
    }

    @Override
    public List<Clockin> getThisMonthClockInListByUid(String user_id) {
        return clockInMapper.getThisMonthClockInListByUid(user_id);
    }


}
