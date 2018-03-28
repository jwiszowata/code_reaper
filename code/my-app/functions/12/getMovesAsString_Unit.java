public String getMovesAsString() {
    StringBuilder sb = new StringBuilder(16);
    int quotient = getMovesLeft() / 3;
    int remainder = getMovesLeft() % 3;
    if (quotient > 0 || remainder == 0)
        sb.append(quotient);
    if (remainder > 0) {
        sb.append('(').append(remainder).append("/3) ");
    }
    sb.append('/').append(getInitialMovesLeft() / 3);
    return sb.toString();
}