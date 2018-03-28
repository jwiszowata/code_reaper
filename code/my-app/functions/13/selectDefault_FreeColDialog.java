private int selectDefault(List<ChoiceItem<T>> options) {
    int def = -1, can = -1, ok = -1, i = 0;
    for (ChoiceItem<T> ci : options) {
        if (ci.isDefault())
            def = i;
        else if (ci.isCancel())
            can = i;
        else if (ci.isOK())
            ok = i;
        i++;
    }
    return (def >= 0) ? def : (can >= 0) ? can : (ok >= 0) ? ok : options.size() - 1;
}