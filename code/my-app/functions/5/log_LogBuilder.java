public void log(Logger logger, Level level) {
    if (sb != null && logger != null && level != null && logger.isLoggable(level)) {
        logger.log(level, toString());
    }
}