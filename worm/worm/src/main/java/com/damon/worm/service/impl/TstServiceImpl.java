package com.damon.worm.service.impl;

import com.damon.worm.dao.TstDao;
import com.damon.worm.service.TstService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TstServiceImpl implements TstService {
    @Autowired
    private TstDao tstDao;
    @Override
    public String getUser(String userName) {
        return tstDao.getUser(userName);
    }
}
