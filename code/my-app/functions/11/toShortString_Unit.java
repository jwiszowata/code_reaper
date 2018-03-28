public String toShortString() {
    StringBuilder sb = new StringBuilder(32);
    sb.append(getId()).append('-').append(getType().getSuffix());
    if (!hasDefaultRole()) {
        sb.append('-').append(getRoleSuffix());
        int count = getRoleCount();
        if (count > 1)
            sb.append('.').append(count);
    }
    return sb.toString();
}