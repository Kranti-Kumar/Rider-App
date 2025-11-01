package com.RidderApp.uberApp.strategies;


import com.RidderApp.uberApp.strategies.Impl.DriverMatchingHighestRatedDriverStrategy;
import com.RidderApp.uberApp.strategies.Impl.DriverMatchingNearestDriverStrategy;
import com.RidderApp.uberApp.strategies.Impl.RideFareDefaultFareCalculationStrategy;
import com.RidderApp.uberApp.strategies.Impl.RideFareSurgePricingFareCalculationStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


import java.time.LocalTime;

@Component
@RequiredArgsConstructor
public class RideStrategyManger {

    private final DriverMatchingNearestDriverStrategy nearestDriverStrategy;
    private final DriverMatchingHighestRatedDriverStrategy highestRatedDriverStrategy;
    private final RideFareSurgePricingFareCalculationStrategy surgePricingFareCalculationStrategy;
    private final RideFareDefaultFareCalculationStrategy defaultFareCalculationStrategy;

//    add more condition depend on time weather
    public DriverMatchingStrategy driverMatchingStrategy(double riderRating){
       if (riderRating>=4.8){
             return highestRatedDriverStrategy;
       }
       return nearestDriverStrategy;
    }
    public RideFareCalculationStrategy rideFareCalculationStrategy(){
        LocalTime surgeStartTime = LocalTime.of(18,0);
        LocalTime surgeEndTime = LocalTime.of(21,0);
        LocalTime currentTime = LocalTime.now();
        boolean isSurgeTime = currentTime.isAfter(surgeStartTime) && currentTime.isBefore(surgeEndTime);
        if(isSurgeTime)
            return surgePricingFareCalculationStrategy;
        return defaultFareCalculationStrategy;
    }

}
