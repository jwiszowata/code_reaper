private void setCanvas() {
    try {
        getContentPane().add(canvas);
    } catch (Exception e) {
        logger.log(Level.WARNING, "Java crash", e);
    }
}