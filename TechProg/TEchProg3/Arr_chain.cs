using System;
using System.Reflection;
namespace ТП3
{
    // Класс Arr_chain_list, расширяющий функциональность абстрактного класса Base_list
    public class Arr_chain <T> : Base_list<T> where T : IComparable<T>
    {
        private Node head = null; // Ссылка на головной узел

        // Внутренний класс Node для представления элемента списка
        public class Node
        {
            public T Data { get; set; } // Данные узла
            public Node Next { get; set; } // Ссылка на следующий узел

            // Конструктор узла, принимающий данные и ссылку на следующий узел
            public Node(T data, Node next)
            {
                Data = data;
                Next = next;
            }
        }

        // Метод поиска узла по индексу в списке
        private Node NodeFinder(int pos)
        {
            if (pos >= count) { return null; } // Если индекс выходит за границы списка, вернуть null
            int i = 0;
            Node Check = head;
            while (Check != null && i < pos)
            {
                Check = Check.Next;
                i++;
            }
            if (i == pos) { return Check; }
            else { return null; }
        }

        // Переопределение метода добавления элемента в конец списка
        public override void Add(T data)
        {
            if (head == null)
            {
                head = new Node(data, null);
            }
            else
            {
                Node lastNode = NodeFinder(count - 1);
                lastNode.Next = new Node(data, null);
            }
            count++;
            OnItemChanged();
        }

        // Переопределение метода вставки элемента по указанной позиции
        public override void Insert(int pos, T data)
        {
              if (pos < 0 || pos > count)
                {
                    throw new BadIndexException();
                }
                if (pos == 0)
                {
                    head = new Node(data, head);
                }
                else
                {
                    Node prevNode = NodeFinder(pos - 1);
                    prevNode.Next = new Node(data, prevNode.Next);
                }
                count++;
                OnItemChanged();
        }

        // Переопределение метода удаления элемента по указанной позиции
        public override void Delete(int pos)
        {
            if (pos < 0 || pos >= count)
            {
                throw new BadIndexException();
            }

            if (pos == 0)
            {
                head = head.Next;
            }
            else
            {
                Node prevNode = NodeFinder(pos - 1);
                prevNode.Next = prevNode.Next.Next;
            }
            count--;
            OnItemChanged();
        }

        // Переопределение метода очистки списка
        public override void Clear()
        {
            head = null;
            count = 0;
            OnItemChanged();
        }

        // Переопределение индексатора для доступа к элементам списка
        public override T this[int index]
        {
            get{
            if (index < 0 || index >= count)
                    {
                        throw new BadIndexException();
                    }
                    Node node = NodeFinder(index);
                    return node.Data;
            }
            set
            {
                    if (index < 0 || index >= count)
                    {
                        throw new BadIndexException();
                    }
                    Node current = NodeFinder(index);
                    current.Data = value;
            }
        }


        // Переопределение метода для создания пустой копии списка
        protected override Base_list <T> EmptyClone()
        {
            return new Arr_chain <T> ();        }

        // Переопределение метода сортировки списка
        public override void Sort()
        {
            if (count <= 1)
            {
                return;
            }

            T temp;

             while (true)
            {
                bool t = true;
                Node current = head;

                while (current != null && current.Next != null)
                {
                    if (current.Data.CompareTo(current.Next.Data) > 0)
                    {
                        temp = current.Data;
                        current.Data = current.Next.Data;
                        current.Next.Data = temp;
                        t = false;
                    }
                    current = current.Next;
                }
                if (t)
                {
                    break;
                }
            }
            
        }
        public override string ToString()
        {
            string str = "";
            Node current = head;
            while (current != null)
            {
                str += current.Data.ToString() + " ";
                current = current.Next;
            }
            return str.Trim();
        }
    }
}