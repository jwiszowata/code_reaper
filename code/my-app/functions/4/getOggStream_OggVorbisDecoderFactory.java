public AudioInputStream getOggStream(File file) throws IOException {
    FileInputStream fis = new FileInputStream(file);
    return new OggVorbisAudioInputStream(new OggStream(fis));
}