public String toString() {
    StringBuilder sb = new StringBuilder(64);
    sb.append(leftHandSide).append(' ').append(operator).append(' ').append(rightHandSide);
    return sb.toString();
}