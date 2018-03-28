public void playOnce(File file) {
    if (getMixer() == null)
        return;
    try {
        soundPlayerThread.add(getAudioInputStream(file));
        soundPlayerThread.awaken();
    } catch (Exception e) {
        logger.log(Level.WARNING, "Unable to play: " + file.getName(), e);
    }
}