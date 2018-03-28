public static Direction[] getRandomDirections(String logMe, Logger logger, Random random) {
    List<Direction> directions = new ArrayList<>(allDirections);
    randomShuffle(logger, logMe, directions, random);
    return directions.toArray(new Direction[0]);
}