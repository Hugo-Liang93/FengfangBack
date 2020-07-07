package com.anteater.fengfang.controller;

import com.anteater.fengfang.domains.Clockin;
import com.anteater.fengfang.domains.response.ResBody;
import com.anteater.fengfang.service.ClockInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ClockInController {
    @Autowired
    ClockInService clockInService;

    @RequestMapping(value = "/api/user/clockin",method = RequestMethod.POST)
    @ResponseBody
    public ResBody clockIn(@RequestBody Clockin clockin){
        return clockInService.clockIn(clockin);
    }

    @RequestMapping(value = "/api/clockin/getTodayClockin/{user_id}",method = RequestMethod.GET)
    @ResponseBody
    public List<Clockin> getTodayclockIn(@PathVariable String user_id){
        return clockInService.getTodayClockIn(user_id);
    }

    @RequestMapping(value = "/api/user/clockin/{user_id}",method = RequestMethod.GET)
    @ResponseBody
    public List<Clockin> getClockInList(@PathVariable String user_id){
        return clockInService.getThisMonthClockInListByUid(user_id);
    }
}
