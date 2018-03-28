public final String getDateString() {
    DateFormat format = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.SHORT);
    return format.format(date);
}