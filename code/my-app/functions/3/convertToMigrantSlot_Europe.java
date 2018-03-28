public static int convertToMigrantSlot(Integer i) {
    return (i == null || !validMigrantSlot(i)) ? CHOOSE_MIGRANT_SLOT : i;
}