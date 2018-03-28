private static void add(StringBuilder sb, Object... objects) {
    for (Object o : objects) {
        if (o instanceof Object[]) {
            for (Object o2 : (Object[]) o) {
                sb.append(o2s(o2));
            }
        } else {
            sb.append(o2s(o));
        }
    }
}