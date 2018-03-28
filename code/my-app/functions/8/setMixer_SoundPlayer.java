private void setMixer(MixerWrapper mw) {
    try {
        mixer = AudioSystem.getMixer(mw.getMixerInfo());
    } catch (Exception e) {
        logger.log(Level.WARNING, "Could not set mixer", e);
        mixer = null;
    }
}