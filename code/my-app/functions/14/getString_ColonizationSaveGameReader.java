public static String getString(byte[] data, int start, int length) {
    byte[] bytes = Arrays.copyOfRange(data, start, start + length);
    try {
        String value = new String(bytes, "UTF-8");
        int index = value.indexOf(0);
        if (index < 0) {
            return value;
        } else {
            return value.substring(0, index);
        }
    } catch (UnsupportedEncodingException uee) {
        return null;
    }
}