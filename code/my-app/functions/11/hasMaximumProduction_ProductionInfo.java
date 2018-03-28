public boolean hasMaximumProduction() {
    if (maximumProduction.isEmpty())
        return true;
    for (int index = 0; index < production.size(); index++) {
        if (maximumProduction.size() < index)
            return true;
        if (maximumProduction.get(index).getAmount() > production.get(index).getAmount())
            return false;
    }
    return true;
}