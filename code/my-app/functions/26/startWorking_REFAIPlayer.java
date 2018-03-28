public void startWorking() {
    final Player player = getPlayer();
    if (!player.isWorkForREF()) {
        logger.warning("No work for REF: " + player);
        return;
    }
    super.startWorking();
    List<TransportMission> transport = new ArrayList<>();
    List<TransportableAIObject> land = new ArrayList<>();
    for (AIUnit aiu : getAIUnits()) {
        final Unit u = aiu.getUnit();
        if (u.isNaval()) {
            if (aiu.hasMission(TransportMission.class)) {
                transport.add(aiu.getMission(TransportMission.class));
            }
        } else {
            if (u.isInEurope())
                land.add(aiu);
        }
    }
    if (!land.isEmpty() && !transport.isEmpty()) {
        LogBuilder lb = new LogBuilder(256);
        allocateTransportables(land, transport, lb);
        lb.log(logger, Level.FINE);
    }
}