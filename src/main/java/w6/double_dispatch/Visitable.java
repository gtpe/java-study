package w6.double_dispatch;

public interface Visitable<V> {

    void accept(V visitor);

}
