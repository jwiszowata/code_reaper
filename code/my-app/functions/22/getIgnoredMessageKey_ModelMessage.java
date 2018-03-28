public String getIgnoredMessageKey() {
    switch(getMessageType()) {
        case WAREHOUSE_CAPACITY:
            StringBuilder sb = new StringBuilder(64);
            sb.append(getSourceId());
            switch(getTemplateType()) {
                case TEMPLATE:
                    for (String k : getKeys()) {
                        if ("%goods%".equals(k)) {
                            sb.append('-').append(getReplacement(k).getId());
                        }
                    }
                    break;
                default:
                    break;
            }
            return sb.toString();
        default:
            break;
    }
    return null;
}