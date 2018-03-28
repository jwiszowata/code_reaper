public void updateOption() {
    for (OptionUpdater optionUpdater : optionUpdaters) {
        optionUpdater.updateOption();
    }
}