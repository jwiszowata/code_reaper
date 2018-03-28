public Direction[] getClosestDirections(String logMe, Logger logger, Random random) {
    final int nbits = (NUMBER_OF_DIRECTIONS - 2) / 2;
    final int r = randomInt(logger, logMe, random, 1 << nbits);
    Direction[] ret = new Direction[NUMBER_OF_DIRECTIONS];
    ret[0] = this;
    int step = 1, mask = 1;
    for (int i = 1; i < NUMBER_OF_DIRECTIONS - 1; i += 2) {
        Direction dr = this.rotate(step);
        Direction dl = this.rotate(NUMBER_OF_DIRECTIONS - step);
        ret[i] = ((r & mask) == 0) ? dr : dl;
        ret[i + 1] = ((r & mask) == 0) ? dl : dr;
        step += 1;
        mask *= 2;
    }
    ret[NUMBER_OF_DIRECTIONS - 1] = this.getReverseDirection();
    return ret;
}