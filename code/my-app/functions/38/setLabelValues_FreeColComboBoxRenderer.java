public void setLabelValues(JLabel c, T value) {
    if (value == null) {
        c.setText(null);
    } else if (value instanceof Integer) {
        c.setText(value.toString());
    } else if (value instanceof Language) {
        c.setText(value.toString());
    } else if (value instanceof String) {
        String string = (String) value;
        if (localize) {
            String[] nd = Messages.getBestNameAndDescription(string);
            c.setText(nd[0]);
            if (nd[1] != null)
                c.setToolTipText(nd[1]);
        } else {
            c.setText(string);
        }
    } else if (value instanceof Named) {
        Named named = (Named) value;
        String[] nad = Messages.getBestNameAndDescription(named);
        c.setText(nad[0]);
        if (nad[1] != null)
            c.setToolTipText(nad[1]);
    } else if (value instanceof ObjectWithId) {
        String id = ((prefix == null) ? "" : prefix) + ((ObjectWithId) value).getId();
        String[] nd = Messages.getBestNameAndDescription(id);
        if (value instanceof Nameable) {
            String realname = ((Nameable) value).getName();
            if (realname != null)
                nd[0] = realname;
        }
        c.setText(nd[0]);
        if (nd[1] != null)
            c.setToolTipText(nd[1]);
    } else {
        logger.warning("What is this?: " + value + " (" + value.getClass() + ")");
    }
}