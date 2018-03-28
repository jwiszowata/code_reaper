protected AbstractOption readOption(FreeColXMLReader xr) throws XMLStreamException {
    final Specification spec = getSpecification();
    final String tag = xr.getLocalName();
    AbstractOption option = null;
    if (ACTION_TAG.equals(tag)) {
        logger.finest("Skipping action " + xr.readId());
        xr.nextTag();
    } else if (AbstractUnitOption.TAG.equals(tag)) {
        option = new AbstractUnitOption(spec);
    } else if (AudioMixerOption.TAG.equals(tag)) {
        option = new AudioMixerOption(spec);
    } else if (BooleanOption.TAG.equals(tag)) {
        option = new BooleanOption(spec);
    } else if (FileOption.TAG.equals(tag)) {
        option = new FileOption(spec);
    } else if (IntegerOption.TAG.equals(tag)) {
        option = new IntegerOption(spec);
    } else if (LanguageOption.TAG.equals(tag)) {
        option = new LanguageOption(spec);
    } else if (ModListOption.TAG.equals(tag)) {
        option = new ModListOption(spec);
    } else if (ModOption.TAG.equals(tag)) {
        option = new ModOption(spec);
    } else if (OptionGroup.TAG.equals(tag)) {
        option = new OptionGroup(spec);
    } else if (PercentageOption.TAG.equals(tag)) {
        option = new PercentageOption(spec);
    } else if (RangeOption.TAG.equals(tag)) {
        option = new RangeOption(spec);
    } else if (SelectOption.TAG.equals(tag)) {
        option = new SelectOption(spec);
    } else if (StringOption.TAG.equals(tag)) {
        option = new StringOption(spec);
    } else if (UnitListOption.TAG.equals(tag)) {
        option = new UnitListOption(spec);
    } else if (UnitTypeOption.TAG.equals(tag)) {
        option = new UnitTypeOption(spec);
    } else if (TextOption.TAG.equals(tag)) {
        option = new TextOption(spec);
    } else {
        logger.warning("Not an option type: " + tag);
        xr.nextTag();
    }
    if (option != null)
        option.readFromXML(xr);
    return option;
}