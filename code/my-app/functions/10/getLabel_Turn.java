public static StringTemplate getLabel(int turn) {
    int season = getSeason(turn);
    StringTemplate t = StringTemplate.label("");
    if (season >= 0) {
        t.addName(NameCache.getSeasonName(season));
        t.addName(" ");
    }
    t.addName(Integer.toString(getYear(turn)));
    return t;
}