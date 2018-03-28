private List<AIUnit> requireTransports(int nt, List<AIUnit> transports, List<AIUnit> privateers, LogBuilder lb) {
    Mission m;
    List<AIUnit> naval = new ArrayList<>();
    List<AIUnit> result = new ArrayList<>();
    if (transports.size() < nt) {
        for (AIUnit aiu : privateers) {
            Location target = aiu.getMission().getTarget();
            if (target instanceof Unit && aiu.getUnit().hasTile()) {
                naval.add(aiu);
            } else if ((m = getTransportMission(aiu)) != null) {
                lb.add(" notarget ", m);
                result.add(aiu);
            }
        }
    }
    if (transports.size() < nt) {
        final ToIntFunction<AIUnit> targetDistance = cacheInt(aiu -> {
            Unit target = (Unit) aiu.getMission().getTarget();
            Tile tile = aiu.getUnit().getTile();
            return tile.getDistanceTo(target.getTile());
        });
        for (AIUnit aiu : sort(naval, Comparator.comparingInt(targetDistance))) {
            int distance = targetDistance.applyAsInt(aiu);
            if ((m = getTransportMission(aiu)) != null) {
                lb.add(" REQUIRED ", distance, " ", m);
                result.add(aiu);
                if (result.size() + transports.size() >= nt)
                    break;
            }
        }
    }
    privateers.removeAll(result);
    transports.addAll(result);
    return result;
}