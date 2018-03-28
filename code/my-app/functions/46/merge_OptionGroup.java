public boolean merge(Option option) {
    final String id = option.getId();
    OptionGroup etc = null;
    if (option instanceof OptionGroup) {
        OptionGroup optionGroup = (OptionGroup) option;
        boolean result = true;
        for (Option o : optionGroup.getOptions()) {
            if (o.getId().startsWith("net.sf.freecol.client.gui.panel.")) {
                if (etc == null)
                    etc = getOptionGroup(ClientOptions.ETC);
                etc.add(o);
                logger.log(Level.INFO, "Moved " + o.getId() + " to " + ClientOptions.ETC);
                continue;
            }
            result = result && this.merge(o);
        }
        if (result) {
            optionGroup.setEditable(editable && optionGroup.isEditable());
        }
        logger.finest("Merged option group " + id + " contents into " + this.getId());
        return result;
    }
    if (!optionMap.containsKey(id)) {
        logger.warning("Ignoring unknown option " + id);
        return false;
    }
    for (int index = 0; index < options.size(); index++) {
        Option o = options.get(index);
        if (id.equals(o.getId())) {
            options.remove(index);
            options.add(index, option);
            optionMap.put(id, option);
            logger.finest("Merged option " + id + " into " + this.getId() + ": " + option.toString() + "/");
            return true;
        }
        if (o instanceof OptionGroup) {
            OptionGroup og = (OptionGroup) o;
            if (og.optionMap.containsKey(id) && og.merge(option)) {
                optionMap.put(id, option);
                return true;
            }
        }
    }
    logger.warning("Option " + id + " registered but not found!");
    return false;
}