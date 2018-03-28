public static <T> boolean listEquals(List<T> one, List<T> two) {
    if (one == null)
        return two == null;
    if (two == null)
        return false;
    Iterator<T> oneI = one.iterator();
    Iterator<T> twoI = two.iterator();
    for (; ; ) {
        if (oneI.hasNext()) {
            if (twoI.hasNext()) {
                if (!Utils.equals(oneI.next(), twoI.next()))
                    break;
            } else {
                break;
            }
        } else {
            return !twoI.hasNext();
        }
    }
    return false;
}