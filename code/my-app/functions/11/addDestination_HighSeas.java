public void addDestination(Location destination) {
    if (destination != null) {
        if (!destinations.contains(destination)) {
            destinations.add(destination);
        } else {
            logger.warning(getId() + " already included destination " + destination.getId());
        }
    } else {
        logger.warning("Tried to add null destination to " + getId());
    }
}