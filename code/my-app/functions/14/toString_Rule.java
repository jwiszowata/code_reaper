public String toString() {
    final String andString = " and ";
    final String orString = " or ";
    StringBuilder sb = new StringBuilder(32);
    for (List<Relation> andCondition : conditions) {
        for (Relation relation : andCondition) {
            sb.append(relation).append(andString);
        }
        sb.setLength(sb.length() - andString.length());
        sb.insert(0, orString);
    }
    sb.delete(0, orString.length());
    return sb.toString();
}