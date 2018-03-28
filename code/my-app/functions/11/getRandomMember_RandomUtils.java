public static <T> T getRandomMember(Logger logger, String logMe, List<T> list, Random random) {
    switch(list.size()) {
        case 0:
            return null;
        case 1:
            return list.get(0);
        default:
            break;
    }
    return list.get(randomInt(logger, logMe, random, list.size()));
}