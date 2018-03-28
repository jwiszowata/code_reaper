private SourceDataLine openLine(AudioFormat audioFormat) {
    SourceDataLine line = null;
    DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat);
    if (!mixer.isLineSupported(info)) {
        logger.log(Level.WARNING, "Mixer does not support " + info);
        return null;
    }
    try {
        line = (SourceDataLine) mixer.getLine(info);
        line.open(audioFormat, BUFSIZ);
        line.start();
        setVolume(line, volume);
    } catch (Exception e) {
        logger.log(Level.WARNING, "Can not open SourceDataLine", e);
        return null;
    }
    return line;
}