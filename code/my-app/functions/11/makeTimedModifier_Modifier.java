public static Modifier makeTimedModifier(String id, Modifier template, Turn start) {
    Modifier modifier = new Modifier(id, template);
    float inc = template.getIncrement();
    int duration = template.getDuration();
    modifier.setTemporary(template.isTemporary());
    if (duration == 0) {
        duration = (int) (template.getValue() / -inc);
    }
    modifier.setIncrement(template.getIncrementType(), inc, start, new Turn(start.getNumber() + duration));
    return modifier;
}