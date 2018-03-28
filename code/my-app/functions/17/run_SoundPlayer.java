public void run() {
    for (; ; ) {
        if (playList.isEmpty()) {
            try {
                goToSleep();
            } catch (InterruptedException e) {
                continue;
            }
        } else {
            try (AudioInputStream in = playList.remove(0)) {
                playSound(in);
            } catch (IOException e) {
                logger.log(Level.WARNING, "Failure playing audio.", e);
            }
        }
    }
}