private void parse(List<String> input) {
    String token = input.remove(0);
    if ("n".equals(token)) {
        token = input.remove(0);
    } else {
        throw new IllegalArgumentException("Relation must start with 'n'.");
    }
    if ("mod".equals(token)) {
        mod = Integer.parseInt(input.remove(0));
        token = input.remove(0);
    }
    if ("not".equals(token)) {
        negated = true;
        token = input.remove(0);
    }
    if ("is".equals(token)) {
        token = input.remove(0);
        if ("not".equals(token)) {
            negated = true;
            token = input.remove(0);
        }
        low = high = Integer.parseInt(token);
    } else {
        if ("within".equals(token)) {
            integer = false;
        }
        low = Integer.parseInt(input.remove(0));
        high = Integer.parseInt(input.remove(0));
    }
}