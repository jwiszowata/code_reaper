public static OptionGroup load(File file, String optionId, Specification spec) {
    OptionGroup ret = new OptionGroup(spec);
    if (ret.load(file)) {
        if (!optionId.equals(ret.getId())) {
            Option op = ret.getOption(optionId);
            ret = (op instanceof OptionGroup) ? (OptionGroup) op : null;
        }
    } else {
        ret = null;
    }
    return ret;
}