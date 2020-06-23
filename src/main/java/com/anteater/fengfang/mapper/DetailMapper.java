package com.anteater.fengfang.mapper;

import com.anteater.fengfang.domains.Detail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DetailMapper {
    Boolean saveDetail(Detail detail);
    List<Detail> getDetail();

    Boolean removeDetailById(String detailId);

    Boolean updateDetail(Detail detail);
}
