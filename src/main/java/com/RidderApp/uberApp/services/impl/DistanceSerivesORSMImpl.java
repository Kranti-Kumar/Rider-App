package com.RidderApp.uberApp.services.impl;

import com.RidderApp.uberApp.services.DistanceService;
import org.locationtech.jts.geom.Point;
import org.springframework.stereotype.Service;

@Service
public class DistanceSerivesORSMImpl implements DistanceService {
    @Override
    public Double calculateDistance(Point src, Point dest) {
        // call the api  todo
        return 0.0;
    }
}
