public FoundingFather selectFoundingFather(List<FoundingFather> ffs) {
    final int age = getGame().getAge();
    FoundingFather bestFather = null;
    int bestWeight = Integer.MIN_VALUE;
    for (FoundingFather father : ffs) {
        if (father == null)
            continue;
        if (father.hasAbility(Ability.BUILD_CUSTOM_HOUSE)) {
            bestFather = father;
            break;
        }
        int weight = father.getWeight(age);
        if (weight > bestWeight) {
            bestWeight = weight;
            bestFather = father;
        }
    }
    return bestFather;
}