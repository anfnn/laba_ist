using System;
using System.Reflection;
namespace ТП3
{
    public class Dbl_list<T> : Base_list<T> where T : IComparable<T>
    {
        private class Node
        {
            public T data;
            public Node prev;
            public Node next;

            public Node(T value)
            {
                data = value;
                prev = null;
                next = null;
            }
        }

        private Node head; // Указатель на начало списка
        private Node tail; // Указатель на конец списка

        public Dbl_list()
        {
            head = null;
            tail = null;
            count = 0;
        }

        private void AddFirst(T item)
        {
            Node newNode = new Node(item);
            if (head == null)
            {
                head = newNode;
                tail = newNode;
            }
            else
            {
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
            }
            count++;
        }

        public override void Add(T item)
        {
            if (head == null)
            {
                AddFirst(item);
            }
            else
            {
                Node newNode = new Node(item);
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
                count++;
            }

            OnItemChanged();
        }

        public override void Insert(int pos, T item)
        {
            if (pos < 0 || pos > count)
            {
                throw new BadIndexException();
            }

            if (pos == 0)
            {
                AddFirst(item);
            }
            else if (pos == count)
            {
                Add(item);
            }
            else
            {
                Node current = head;
                for (int i = 0; i < pos - 1; i++)
                {
                    current = current.next;
                }

                Node newNode = new Node(item);
                newNode.next = current.next;
                current.next.prev = newNode;
                current.next = newNode;
                newNode.prev = current;

                count++;

                OnItemChanged();
            }
        }

        public override void Delete(int pos)
        {
            if(pos < 0 || pos >= count)
            {
                throw new BadIndexException();
            }

            if(pos == 0)
            {
                if(count == 1)
                {
                    head = null;
                    tail = null;
                }
                else
                {
                    head = head.next;
                    head.prev = null;
                }
            }
            else if(pos == count - 1)
            {
                tail = tail.prev;
                tail.next = null;
            }
            else
            {
                Node current = head;
                for(int i = 0; i < pos; i++)
                {
                    current = current.next;
                }

                current.prev.next = current.next;
                current.next.prev = current.prev;
            }

            count--;
            OnItemChanged();
        }

        public override void Clear()
        {
            head = null;
            tail = null;
            count = 0;
            OnItemChanged();
        }

        public override T this[int index]
        {
            get
            {
                if (index < 0 || index >= count)
                {
                    throw new BadIndexException();
                }

                Node current = head;
                for (int i = 0; i < index; i++)
                {
                    current = current.next;
                }

                return current.data;
            }
            set
            {
                if (index < 0 || index >= count)
                {
                    throw new BadIndexException();
                }

                Node current = head;
                for (int i = 0; i < index; i++)
                {
                    current = current.next;
                }

                current.data = value;
            }
        }

        protected override Base_list<T> EmptyClone()
        {
            return new Dbl_list<T>();
        }


        public override string ToString()
        {
            List<T> list = new List<T>();
            Node current = head;
            while (current != null)
            {
                list.Add(current.data);
                current = current.next;
            }

            return string.Join(" ", list);
        }
    }
}