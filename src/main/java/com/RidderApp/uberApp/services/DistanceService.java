package com.RidderApp.uberApp.services;

import org.locationtech.jts.geom.Point;
import org.springframework.stereotype.Service;


public interface DistanceService {
    Double calculateDistance(Point src , Point dest);

}
