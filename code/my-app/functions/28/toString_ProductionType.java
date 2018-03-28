public String toString() {
    StringBuilder result = new StringBuilder(64);
    result.append('[').append(getId()).append(':');
    if (productionLevel != null) {
        result.append(' ').append(productionLevel);
    }
    if (unattended) {
        result.append(" unattended");
    }
    if (!(inputs == null || inputs.isEmpty())) {
        result.append(" [inputs: ");
        for (AbstractGoods input : inputs) {
            result.append(input).append(", ");
        }
        int length = result.length();
        result.replace(length - 2, length, "]");
    }
    if (!(outputs == null || outputs.isEmpty())) {
        result.append(" [outputs: ");
        for (AbstractGoods output : outputs) {
            result.append(output).append(", ");
        }
        int length = result.length();
        result.replace(length - 2, length, "]");
    }
    result.append(']');
    return result.toString();
}