public static int getYear(int turn) {
    int year = turn - 1 + getStartingYear(), seasonYear = getSeasonYear();
    return (year < seasonYear) ? year : seasonYear + (year - seasonYear) / getSeasonNumber();
}