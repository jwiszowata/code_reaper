public final boolean getOption() {
    ClientOptions co = freeColClient.getClientOptions();
    if (co != null && optionId != null) {
        try {
            return co.getBoolean(optionId);
        } catch (Exception e) {
            logger.log(Level.WARNING, "Failure with option: " + optionId, e);
        }
    }
    return false;
}