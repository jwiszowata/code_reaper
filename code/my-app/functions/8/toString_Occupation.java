public String toString() {
    StringBuilder sb = new StringBuilder(32);
    sb.append("[Occupation ").append(workLocation);
    if (workType != null)
        sb.append(' ').append(workType.getSuffix());
    sb.append(']');
    return sb.toString();
}