private MixerWrapper getMixerWrapperByName(String name) {
    return find(audioMixers, mw -> mw.getKey().equals(name));
}