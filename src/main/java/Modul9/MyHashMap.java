package Modul9;

public class MyHashMap<K, V> {
    private Node<K, V> head;
    private int size;

    public MyHashMap() {
        head = null;
        size = 0;
    }

    public void put(K key, V value) {
        Node<K, V> node = head;
        while (node != null) {
            if (node.key.equals(key)) {
                node.value = value;
                return;
            }
            node = node.next;
        }
        head = new Node<>(key, value, head);
        size++;
    }

    public void remove(K key) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }
        if (head.key.equals(key)) {
            head = head.next;
            size--;
            return;
        }
        Node<K, V> node = head;
        while (node.next != null) {
            if (node.next.key.equals(key)) {
                node.next = node.next.next;
                size--;
                return;
            }
            node = node.next;
        }
    }

    public void clear() {
        head = null;
        size = 0;
    }

    public V get(K key) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }
        Node<K, V> node = head;
        while (node != null) {
            if (node.key.equals(key)) {
                return node.value;
            }
            node = node.next;
        }
        return null;
    }

    public int size() {
        return size;
    }

    private static class Node<K, V> {
        private K key;
        private V value;
        private Node<K, V> next;

        public Node(K key, V value, Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
}
