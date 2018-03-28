public static int yearToTurn(int year, int season) {
    int ret = 1, startingYear = getStartingYear();
    if (year >= startingYear) {
        ret += year - startingYear;
        int seasonYear = getSeasonYear();
        if (year >= seasonYear) {
            ret += (year - seasonYear) * (getSeasonNumber() - 1) + season;
        }
    }
    return ret;
}