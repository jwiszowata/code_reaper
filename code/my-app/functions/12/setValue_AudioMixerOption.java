protected void setValue(String valueString, String defaultValueString) {
    MixerWrapper mw = null;
    if (mw == null && valueString != null) {
        mw = getMixerWrapperByName(valueString);
    }
    if (mw == null && defaultValueString != null) {
        mw = getMixerWrapperByName(defaultValueString);
    }
    if (mw == null)
        mw = DEFAULT_MIXER_WRAPPER;
    setValue(mw);
}