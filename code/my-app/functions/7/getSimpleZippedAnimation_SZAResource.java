public SimpleZippedAnimation getSimpleZippedAnimation() {
    if (szAnimation == null) {
        logger.finest("Preload not ready for " + getResourceLocator());
        preload();
    }
    return szAnimation;
}