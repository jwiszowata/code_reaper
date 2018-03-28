private void addIntegerOption(String id, String gr, int val) {
    if (getOption(id) == null) {
        IntegerOption op = new IntegerOption(id, null);
        op.setGroup(gr);
        op.setValue(val);
        add(op);
    }
}