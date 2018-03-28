private static void requireRegionNames(Player player, RegionType type) {
    synchronized (regionNameLock) {
        final String prefix = makeRegionKey(player, type);
        List<String> names = regionNames.get(prefix);
        if (names == null) {
            names = new ArrayList<String>();
            collectNames(prefix, names);
            regionNames.put(prefix, names);
        }
        Integer index = regionIndex.get(prefix);
        if (index == null)
            regionIndex.put(prefix, names.size() + 1);
    }
}