public static void fatal(String err) {
    logger.log(Level.SEVERE, err);
    FreeCol.fatal(err);
}