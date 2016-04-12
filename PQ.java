public class PQ<T extends Comparable> {
  T[] pq;
  int n;

  public PQ(int initialSize) {
    pq =(T[]) new Object[initialSize];
  }

  public PQ() {
    pq = (T[]) new Object[10];
  }

  public void insert(T t) {
    n += 1;
    pq[n] = t;
    swim(n);
  }

  public void swim(int n) {
    if (n/2 > 0 && pq[n].compareTo(pq[n/2]) > 0) {
      swap(n, n/2);
      swim(n/2);
    } else {
      return;
    }
  }

  public void sink(int k) {
    if (2*k <= pq.length) {
      int left = 2 * k;
      int right = 2 * k + 1;
      
        if (pq[left].compareTo(pq[right]) > 0) {
          if (pq[left].compareTo(pq[k]) > 0) {
             swap(left, k);
             sink(left);
          } else {
            return;
          }
        } else {
          if (right < pq.length && pq[right].compareTo(pq[k]) > 0) {
            swap(right, k);
            sink(right);
          } else {
            return;
          }
        }

    } else {
      return;
    }
  }

  public void swap(int apos, int bpos) {
    T a = pq[apos];
    pq[apos] = pq[bpos];
    pq[bpos] = a  ;
  }


}
