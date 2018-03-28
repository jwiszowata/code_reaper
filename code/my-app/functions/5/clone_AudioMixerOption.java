public AudioMixerOption clone() {
    AudioMixerOption result = new AudioMixerOption(getSpecification());
    result.setValues(this);
    return result;
}