private void alertSound() {
    if (getClientOptions().getBoolean(ClientOptions.AUDIO_ALERTS)) {
        playSound("sound.event.alertSound");
    }
}