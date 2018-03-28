private static String makeRegionKey(Player player, RegionType type) {
    return player.getNationId() + ".region." + lastPart(type.getKey(), ".") + ".";
}