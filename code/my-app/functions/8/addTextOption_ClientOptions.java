private void addTextOption(String id, String gr, String val) {
    if (getOption(id) == null) {
        TextOption op = new TextOption(id, null);
        op.setGroup(gr);
        op.setValue(val);
        add(op);
    }
}