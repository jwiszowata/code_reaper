public void setValue(OptionGroup value) {
    if (value != null) {
        for (Option other : value.getOptions()) {
            Option mine = getOption(other.getId());
            if (mine != null) {
                mine.setValue(other.getValue());
            }
        }
    }
}