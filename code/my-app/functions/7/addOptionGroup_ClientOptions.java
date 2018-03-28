private void addOptionGroup(String id, String gr) {
    if (getOption(id) == null) {
        OptionGroup og = new OptionGroup(id);
        og.setGroup(gr);
        add(og);
    }
}