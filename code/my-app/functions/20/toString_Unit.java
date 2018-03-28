public String toString(String prefix) {
    StringBuilder sb = new StringBuilder(64);
    sb.append('[').append(prefix).append(getId());
    if (!isInitialized()) {
        sb.append(" uninitialized");
    } else if (isDisposed()) {
        sb.append(" disposed");
    } else {
        sb.append(' ').append(lastPart(owner.getNationId(), ".")).append(' ').append(getType().getSuffix());
        if (!hasDefaultRole()) {
            sb.append('-').append(getRoleSuffix());
            int count = getRoleCount();
            if (count > 1)
                sb.append('.').append(count);
        }
        sb.append(' ').append(getMovesAsString());
    }
    sb.append(']');
    return sb.toString();
}