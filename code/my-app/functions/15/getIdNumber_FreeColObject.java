public int getIdNumber() {
    if (id != null) {
        int col = id.lastIndexOf(':');
        if (col >= 0) {
            String s = id.substring(col + 1);
            if (s.startsWith("am"))
                s = s.substring(2);
            try {
                return Integer.parseInt(s);
            } catch (NumberFormatException nfe) {
            }
        }
    }
    return -1;
}