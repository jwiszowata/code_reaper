public static int getRank(Location loc) {
    return (loc == null) ? Location.LOCATION_RANK_NOWHERE : loc.getRank();
}