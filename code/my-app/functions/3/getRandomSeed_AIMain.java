public int getRandomSeed(String logMe) {
    return randomInt(logger, logMe, freeColServer.getServerRandom(), Integer.MAX_VALUE);
}