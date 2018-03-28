public static AudioInputStream getAudioInputStream(File file) throws Exception {
    AudioInputStream in;
    if (file.getName().endsWith(".ogg")) {
        in = new OggVorbisDecoderFactory().getOggStream(file);
    } else {
        in = AudioSystem.getAudioInputStream(file);
    }
    return in;
}