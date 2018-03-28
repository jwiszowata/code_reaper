public void add(Option option) {
    String id = option.getId();
    if (optionMap.containsKey(id)) {
        for (int index = 0; index < options.size(); index++) {
            if (id.equals(options.get(index).getId())) {
                options.remove(index);
                options.add(index, option);
                break;
            }
        }
    } else {
        options.add(option);
    }
    optionMap.put(id, option);
    if (option instanceof OptionGroup) {
        OptionGroup group = (OptionGroup) option;
        group.setEditable(editable && group.isEditable());
        addOptionGroup(group);
    }
}