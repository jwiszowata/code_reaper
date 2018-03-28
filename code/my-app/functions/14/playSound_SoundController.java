public void playSound(String sound) {
    if (!canPlaySound()) {
        return;
    }
    if (sound == null) {
        soundPlayer.stop();
    } else {
        File file = ResourceManager.getAudio(sound);
        if (file != null) {
            soundPlayer.playOnce(file);
        }
        logger.finest(((file == null) ? "Could not load" : "Playing") + " sound: " + sound);
    }
}