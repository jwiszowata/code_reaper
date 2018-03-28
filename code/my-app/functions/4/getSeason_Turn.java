public static int getSeason(int turn) {
    int year = turn - 1 + getStartingYear();
    return (year < getSeasonYear()) ? -1 : (year - seasonYear) % getSeasonNumber();
}