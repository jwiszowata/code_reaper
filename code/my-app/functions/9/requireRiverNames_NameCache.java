private static void requireRiverNames() {
    synchronized (riverNameLock) {
        if (riverNames == null) {
            riverNames = new ArrayList<>();
            collectNames("model.other.region.river.", riverNames);
            Collections.shuffle(riverNames);
        }
    }
}