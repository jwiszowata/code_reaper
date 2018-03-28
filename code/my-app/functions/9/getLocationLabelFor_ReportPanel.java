protected String getLocationLabelFor(Unit unit) {
    if (unit.getDestination() instanceof Map) {
        return Messages.message("sailingToAmerica");
    } else if (unit.getDestination() instanceof Europe) {
        return Messages.message("sailingToEurope");
    } else {
        return Messages.message(unit.getLocation().getLocationLabelFor(unit.getOwner()));
    }
}