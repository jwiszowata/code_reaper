public void reset() {
    for (OptionUpdater optionUpdater : optionUpdaters) {
        optionUpdater.reset();
    }
}