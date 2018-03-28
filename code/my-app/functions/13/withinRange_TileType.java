public boolean withinRange(RangeType rangeType, int value) {
    switch(rangeType) {
        case HUMIDITY:
            return humidity[0] <= value && value <= humidity[1];
        case TEMPERATURE:
            return temperature[0] <= value && value <= temperature[1];
        case ALTITUDE:
            return altitude[0] <= value && value <= altitude[1];
        default:
            break;
    }
    return false;
}