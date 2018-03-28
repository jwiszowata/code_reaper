private static void requireShipNames(Player player, Random random) {
    synchronized (shipNameLock) {
        List<String> names = shipNames.get(player);
        if (names == null) {
            final String prefix = player.getNationId() + ".ship.";
            names = new ArrayList<String>();
            collectNames(prefix, names);
            if (random != null) {
                randomShuffle(logger, "Ship names", names, random);
            }
            shipNames.put(player, names);
        }
    }
}