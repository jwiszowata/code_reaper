private void addEffect(Effect effect) {
    if (effects == null)
        effects = new ArrayList<>();
    effects.add(new RandomChoice<>(effect, effect.getProbability()));
}