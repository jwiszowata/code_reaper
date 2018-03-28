private boolean playSound(AudioInputStream in) throws IOException {
    boolean ret = false;
    SourceDataLine line = openLine(in.getFormat());
    if (line == null)
        return false;
    try {
        startPlaying();
        int rd;
        while (keepPlaying() && (rd = in.read(data)) > 0) {
            line.write(data, 0, rd);
        }
        ret = true;
    } finally {
        stopPlaying();
        line.drain();
        line.stop();
        line.close();
    }
    return ret;
}