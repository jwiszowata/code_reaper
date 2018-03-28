public String toString() {
    StringBuilder sb = new StringBuilder(32);
    sb.append("n ");
    if (mod != 1) {
        sb.append("mod ").append(mod).append(' ');
    }
    if (low == high) {
        sb.append("is ");
        if (negated)
            sb.append("not ");
        sb.append(low);
    } else {
        if (negated)
            sb.append("not ");
        if (!integer)
            sb.append("with");
        sb.append("in ").append(low).append("..").append(high);
    }
    return sb.toString();
}