public class ListForPeople {

    public class Node{
        public Node(Person value) {
            this.setValue(value);
        }

        private Person value;

        public Person getValue() {
            return value;
        }

        public void setValue(Person value) {
            this.value = value;
        }

        public Node Next;
    }

    private Node head;
    private Node tail;

    private int count = 0;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void Add(Person item) {
        Node newNode = new Node(item);

        if(head == null){
            head = newNode;
            tail = newNode;
        }
        else {
            tail.Next = newNode;
            tail = newNode;
        }

        setCount(getCount() + 1);
    }

    public void Clear() {
        head = null;
        tail = null;
        setCount(0);
    }

    public Person Search(int id) {
        Node current = head;
        while (current != null) {
            if (current.getValue().id == id) {
                return current.getValue();
            }

            current = current.Next;
        }

        return null;
    }

    public boolean Remove(int id) {
        Node previous = null;
        Node current = head;

        // 1: Пустой список: ничего не делать.
        // 2: Один элемент: установить Previous = null.
        // 3: Несколько элементов:
        //    a: Удаляемый элемент первый.
        //    b: Удаляемый элемент в середине или конце.

        while (current != null)
        {
            if (current.getValue().id == id)
            {
                // Узел в середине или в конце.
                if (previous != null)
                {
                    // Случай 3b.

                    previous.Next = current.Next;

                    // Если в конце, то меняем _tail.
                    if (current.Next == null)
                    {
                        tail = previous;
                    }
                }
                else
                {
                    // Случай 2 или 3a.
                    head = head.Next;

                    // Список теперь пустой?
                    if (head == null) {
                        tail = null;
                    }
                }

                setCount(getCount()-1);
                return true;
            }
            previous = current;
            current = current.Next;
        }

        return false;
    }
}
