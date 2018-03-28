public static List<String> splitText(String text, String delim, FontMetrics fontMetrics, int width) {
    List<String> result = new ArrayList<>();
    final int len = text.length();
    int i = 0, start;
    String top = "";
    Character d = null;
    for (; ; ) {
        for (; i < len; i++) {
            if (delim.indexOf(text.charAt(i)) < 0)
                break;
        }
        if (i >= len)
            break;
        start = i;
        for (; i < len; i++) {
            if (delim.indexOf(text.charAt(i)) >= 0)
                break;
        }
        String s = text.substring(start, i);
        String t = (top.isEmpty()) ? s : top + d + s;
        if (fontMetrics.stringWidth(t) > width) {
            if (top.isEmpty()) {
                result.add(s);
            } else {
                result.add(top);
                top = s;
            }
        } else {
            top = t;
        }
        if (i >= len) {
            if (!top.isEmpty())
                result.add(top);
            break;
        }
        d = text.charAt(i);
    }
    return result;
}