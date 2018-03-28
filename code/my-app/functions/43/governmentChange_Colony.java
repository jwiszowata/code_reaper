public int governmentChange(int unitCount) {
    final Specification spec = getSpecification();
    final int veryBadGovernment = spec.getInteger(GameOptions.VERY_BAD_GOVERNMENT_LIMIT);
    final int badGovernment = spec.getInteger(GameOptions.BAD_GOVERNMENT_LIMIT);
    final int veryGoodGovernment = spec.getInteger(GameOptions.VERY_GOOD_GOVERNMENT_LIMIT);
    final int goodGovernment = spec.getInteger(GameOptions.GOOD_GOVERNMENT_LIMIT);
    int rebelPercent = calculateSoLPercentage(unitCount, getLiberty());
    int rebelCount = calculateRebels(unitCount, rebelPercent);
    int loyalistCount = unitCount - rebelCount;
    int result = 0;
    if (rebelPercent >= veryGoodGovernment) {
        if (sonsOfLiberty < veryGoodGovernment) {
            result = 1;
        }
    } else if (rebelPercent >= goodGovernment) {
        if (sonsOfLiberty >= veryGoodGovernment) {
            result = -1;
        } else if (sonsOfLiberty < goodGovernment) {
            result = 1;
        }
    } else {
        if (sonsOfLiberty >= goodGovernment) {
            result = -1;
        } else {
            if (loyalistCount > veryBadGovernment) {
                if (tories <= veryBadGovernment) {
                    result = -1;
                }
            } else if (loyalistCount > badGovernment) {
                if (tories <= badGovernment) {
                    result = -1;
                } else if (tories > veryBadGovernment) {
                    result = 1;
                }
            } else {
                if (tories > badGovernment) {
                    result = 1;
                }
            }
        }
    }
    return result;
}