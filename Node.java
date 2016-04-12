public class Node<T> implements Comparable<Integer> {
  private T data;
  private int priority;
  public T getData() {
    return this.data;
  }
  public void setData(T data) {
    this.data = data;
  }
  public int getPriority() {
    return this.priority;
  }
  public void setPriority(int priority) {
    this.priority = priority;
  }
  public int compareTo(Integer other) {
    return this.priority - other;
  }
}
