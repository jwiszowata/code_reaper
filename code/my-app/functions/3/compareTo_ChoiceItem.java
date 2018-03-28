public int compareTo(ChoiceItem<T> other) {
    return (this.text == null) ? -1 : (other.text == null) ? 1 : this.text.compareTo(other.text);
}