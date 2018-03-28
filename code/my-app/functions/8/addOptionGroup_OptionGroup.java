private void addOptionGroup(OptionGroup group) {
    for (Option option : group.getOptions()) {
        optionMap.put(option.getId(), option);
        if (option instanceof OptionGroup) {
            addOptionGroup((OptionGroup) option);
        }
    }
}