private int addLabels(JPanel panel, JLabel[] labels, boolean newline, int skip) {
    int len = labels.length;
    for (int i = 0; i < len; i++) if (labels[i] == null)
        len = i;
    String constraint = (newline) ? "newline" : null;
    if (skip > 0) {
        if (constraint == null) {
            constraint = "skip " + skip;
        } else {
            constraint += ", skip " + skip;
        }
    }
    for (int i = 0; i < len; i++) {
        if (constraint != null) {
            panel.add(labels[i], constraint);
            constraint = null;
        } else {
            panel.add(labels[i]);
        }
    }
    return 3 - len;
}