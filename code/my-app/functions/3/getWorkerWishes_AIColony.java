public List<WorkerWish> getWorkerWishes() {
    return transform(wishes, w -> w instanceof WorkerWish, w -> (WorkerWish) w);
}