private static int requireSeasonNames() {
    synchronized (seasonNamesLock) {
        if (seasonNames == null) {
            seasonNames = new ArrayList<>();
            collectNames("nameCache.season.", seasonNames);
            seasonNumber = seasonNames.size();
            if (seasonNumber < 2) {
                seasonNames.clear();
                for (String s : DEFAULT_SEASON_IDS) {
                    seasonNames.add(Messages.message(s));
                }
                seasonNumber = seasonNames.size();
            }
        }
        return seasonNumber;
    }
}