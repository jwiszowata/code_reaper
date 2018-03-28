public static File getAudio(final String key) {
    final AudioResource r = getAudioResource(key);
    return (r == null) ? null : r.getAudio();
}