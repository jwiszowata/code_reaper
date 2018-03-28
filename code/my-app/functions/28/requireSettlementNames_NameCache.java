private static void requireSettlementNames(Player player, Random random) {
    synchronized (settlementNameLock) {
        if (settlementNames.get(player) == null) {
            List<String> names = new ArrayList<>();
            if (player.isEuropean()) {
                String specId = player.getSpecification().getId();
                String cacheId = player.getNationId() + ".settlementName." + specId + ".";
                collectNames(cacheId, names);
                cacheId = player.getNationId() + ".settlementName.";
                collectNames(cacheId, names);
                if (names.isEmpty() && !"freecol".equals(specId)) {
                    cacheId = player.getNationId() + ".settlementName.freecol.";
                    collectNames(cacheId, names);
                }
            } else {
                collectNames(player.getNationId() + ".settlementName.", names);
                if (!names.isEmpty()) {
                    capitalNames.put(player, names.remove(0));
                    if (random != null) {
                        randomShuffle(logger, "Native settlement names", names, random);
                    }
                }
            }
            settlementNames.put(player, names);
            logger.fine("Loaded " + names.size() + " settlement names for " + player.getId());
        }
    }
}