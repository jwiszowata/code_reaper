public final void parse(String input) {
    StringTokenizer st = new StringTokenizer(input.toLowerCase(Locale.US), " .");
    List<String> tokens = new ArrayList<>();
    while (st.hasMoreTokens()) {
        String token = st.nextToken();
        if ("or".equals(token)) {
            conditions.add(parseCondition(tokens));
            tokens.clear();
        } else {
            tokens.add(token);
        }
    }
    conditions.add(parseCondition(tokens));
}