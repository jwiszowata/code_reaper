public boolean equals(Object o) {
    if (this == o)
        return true;
    if (o instanceof MixerWrapper) {
        return ((MixerWrapper) o).getKey().equals(getKey());
    }
    return false;
}