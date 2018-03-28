public void stop() {
    soundPlayerThread.stopPlaying();
    soundPlayerThread.awaken();
}