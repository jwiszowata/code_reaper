public static String getEnumKey(Enum<?> value) {
    final String base = value.toString().toLowerCase(Locale.US);
    final int len = base.length();
    StringBuilder sb = new StringBuilder(len);
    int idx, from = 0;
    for (; ; ) {
        if ((idx = base.indexOf('_', from)) < 0) {
            sb.append(base.substring(from));
            break;
        }
        sb.append(base.substring(from, idx));
        from = idx + 1;
        if (from >= len)
            break;
        char ch = base.charAt(from);
        if (Character.isLetter(ch)) {
            sb.append(Character.toUpperCase(ch));
            from++;
        }
    }
    return sb.toString();
}