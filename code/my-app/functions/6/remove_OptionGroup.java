public Option remove(String id) {
    Option op = optionMap.remove(id);
    if (op != null)
        options.remove(op);
    return op;
}