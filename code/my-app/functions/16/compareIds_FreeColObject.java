public static int compareIds(FreeColObject fco1, FreeColObject fco2) {
    if (fco1 == null) {
        return (fco2 == null) ? 0 : -1;
    } else if (fco2 == null) {
        return 1;
    }
    String id1 = fco1.getId();
    String id2 = fco2.getId();
    if (id1 == null) {
        return (id2 == null) ? 0 : -1;
    } else if (id2 == null) {
        return 1;
    }
    int cmp = fco1.getIdType().compareTo(fco2.getIdType());
    return (cmp > 0) ? 1 : (cmp < 0) ? -1 : Utils.compareTo(fco1.getIdNumber(), fco2.getIdNumber());
}