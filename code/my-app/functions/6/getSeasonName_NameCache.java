public static String getSeasonName(int index) {
    requireSeasonNames();
    if (index >= 0 && index < seasonNumber)
        return seasonNames.get(index);
    return Messages.message(StringTemplate.template("nameCache.season.default").addAmount("%number%", index + 1));
}