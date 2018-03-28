public Location getResponse() {
    Object value = getValue();
    if (options.get(0).equals(value)) {
        Destination d = this.destinationList.getSelectedValue();
        if (d != null)
            return d.location;
    }
    return null;
}