public static OptionUI getOptionUI(GUI gui, Option option, boolean editable) {
    if (option instanceof BooleanOption) {
        return new BooleanOptionUI((BooleanOption) option, editable);
    } else if (option instanceof FileOption) {
        return new FileOptionUI(gui, (FileOption) option, editable);
    } else if (option instanceof PercentageOption) {
        return new PercentageOptionUI((PercentageOption) option, editable);
    } else if (option instanceof RangeOption) {
        return new RangeOptionUI((RangeOption) option, editable);
    } else if (option instanceof SelectOption) {
        return new SelectOptionUI((SelectOption) option, editable);
    } else if (option instanceof IntegerOption) {
        return new IntegerOptionUI((IntegerOption) option, editable);
    } else if (option instanceof StringOption) {
        return new StringOptionUI((StringOption) option, editable);
    } else if (option instanceof LanguageOption) {
        return new LanguageOptionUI((LanguageOption) option, editable);
    } else if (option instanceof AudioMixerOption) {
        return new AudioMixerOptionUI(gui, (AudioMixerOption) option, editable);
    } else if (option instanceof FreeColAction) {
        return new FreeColActionUI((FreeColAction) option, editable);
    } else if (option instanceof AbstractUnitOption) {
        return new AbstractUnitOptionUI((AbstractUnitOption) option, editable);
    } else if (option instanceof ModOption) {
        return new ModOptionUI((ModOption) option, editable);
    } else if (option instanceof UnitListOption) {
        return new ListOptionUI<>(gui, (UnitListOption) option, editable);
    } else if (option instanceof ModListOption) {
        return new ListOptionUI<>(gui, (ModListOption) option, editable);
    } else if (option instanceof TextOption) {
        return new TextOptionUI((TextOption) option, editable);
    } else {
        return null;
    }
}