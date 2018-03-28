private List<Relation> parseCondition(List<String> input) {
    List<String> tokens = new ArrayList<>();
    List<Relation> result = new ArrayList<>();
    for (String token : input) {
        if ("and".equals(token)) {
            result.add(new Relation(tokens));
            tokens.clear();
        } else {
            tokens.add(token);
        }
    }
    result.add(new Relation(tokens));
    return result;
}