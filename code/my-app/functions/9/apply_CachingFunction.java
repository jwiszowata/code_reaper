public R apply(T t) {
    R result;
    if (this.cache.containsKey(t)) {
        result = this.cache.get(t);
    } else {
        this.cache.put(t, result = this.wrapped.apply(t));
    }
    return result;
}