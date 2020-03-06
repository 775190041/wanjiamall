package com.nf.wanjiamall.service;

import com.nf.wanjiamall.entity.FootprintEntity;

/**
 * @author 南八
 */
public interface FootprintService {
   Object getFootprintList(Integer pageNum, Integer pageSize, FootprintEntity footprintEntity);
}
