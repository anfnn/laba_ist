//  класс, реализующий структуру данных двусвязного списка.
//В двусвязном списке каждый элемент хранит ссылки как на предыдущий, 
//так и на следующий элемент списка, что позволяет эффективно производить операции вставки,
// удаления и обхода элементов как вперед, так и назад.

using System;
using System.Collections.Generic;

namespace ТП1
{
    public class DoublyLinkedList
    {
        // Класс узла двусвязного списка
        public class Node
        {
            public int Data { get; set; }
            public Node Previous { get; set; }
            public Node Next { get; set; }

            public Node(int data)
            {
                Data = data;
                Previous = null;
                Next = null;
            }
        }

        private Node head = null;
        private int count = 0;

        private IndexList lst = new IndexList();

        // Константа определяющая интервал для индексного списка
        public const int Interval = 50;

        // Поиск узла по индексу
        public Node Find(int index)
        {
            if (index >= count || head == null) return null;
            else if (index == 0 && count != 0) return head;
            else
            {
                int intervalIndex = index / Interval;
                int leftEnd = lst.GetIndex(intervalIndex);
                int rightEnd = lst.GetIndex(intervalIndex + 1);
                Node target = lst.GetNode(leftEnd);

                if (intervalIndex + 1 < lst.Count)
                {
                    int mid = (leftEnd + (leftEnd + Interval)) / 2;

                    if (intervalIndex == 0) 
                        mid = Interval - 1 / 2;

                    if (index > mid)
                    {
                        target = lst.GetNode(rightEnd);
                        for (int i = rightEnd; i > index; i--)
                        {
                            target = target.Previous;
                        }
                        return target;
                    }
                }

                for (int i = leftEnd; i < index; i++)
                {
                    target = target.Next;
                }
                return target;
            }
        }

        // Добавление нового узла в конец списка
        public void Add(int data)
        {
            Node newNode = new Node(data);

            if (head == null)
            {
                head = newNode;
                lst.Append(head, count);
                count++;
            }
            else
            {
                Node last = Find(count - 1);
                Node current = newNode;
                last.Next = current;
                current.Previous = last;
                count++;

                if (count % Interval == 0)
                {
                    lst.Append(current, count - 1);
                }
                if ((count - 1) % Interval == 0)
                {
                    lst.SetNode(current.Previous, count - 2);
                }
            }
        }

        // Вставка нового узла по индексу
        public void Insert(int data, int index)
        {
            if (index < 0 || index > count) { return; }

            if (index == count) { Add(data); }

            else
            {
                Node newNode = new Node(data);

                if (index == 0)
                {
                    newNode.Next = head;
                    head.Previous = newNode;
                    head = newNode;
                    lst[0] = head;
                    UpdateIndexNodesAfterInsert(index);
                    count++;
                }
                else
                {
                    Node previous = Find(index - 1);
                    Node current = Find(index);
                    newNode.Next = current;
                    newNode.Previous = previous;
                    previous.Next = newNode;
                    current.Previous = newNode;

                    // Если вставка на 48 то обновляется узел на 49  
                    if ((index + 2) % Interval == 0 && count >= index + 2)
                    {
                        lst.SetNode(current.Next, index + 1);
                    }
                    // Если вставка на 50 то обновляется узел на 49
                    if (index % Interval == 0)
                    {
                        lst.SetNode(previous, index - 1);
                    }
                    // Если вставка на 49 (и если это последнее), новый узел на 50 добавляется в индексный список
                    if ((index + 1) % Interval == 0)
                    {
                        if (count == (index + 1))
                        {
                            lst.SetNode(newNode, index);
                            count++;
                            return;
                        }
                        lst.SetNode(current, index);
                    }
                    UpdateIndexNodesAfterInsert(index);
                    count++;
                }
            }
        }

        // Удаление узла по индексу
        public void RemoveAt(int index)
        {
            if (index < 0 || index >= count)
            {
                return;
            }

            if (index == 0)
            {
                if (count == 1)
                {
                    head = null;
                    lst.Delete(0);
                    count--;
                }
                else
                {
                    head = head.Next;
                    head.Previous = null;
                    lst[0] = head;
                    UpdateIndexNodesAfterRemove(index);
                    count--;
                }
            }
            else
            {
                Node target = Find(index);
                Node previous = target.Previous;
                previous.Next = target.Next;

                if (previous.Next != null)
                {
                    Node newCurrent = previous.Next;
                    newCurrent.Previous = previous;

                    if ((index + 2) % Interval == 0 && count >= index + 2)
                    {
                        lst.SetNode(newCurrent, index + 1);
                    }

                    if ((index + 1) % Interval == 0)
                    {
                        lst.SetNode(previous, index);
                    }
                }

                if (index % Interval == 0)
                {
                    lst.SetNode(previous, index - 1);
                }

                if ((index + 1) % Interval == 0 && count == (index + 1))
                {
                    lst.Delete(lst.Find(index));
                    count--;
                    return;
                }
                UpdateIndexNodesAfterRemove(index);
                count--;
            }
        }

        // Обновление индексов после удаления узла
        private void UpdateIndexNodesAfterRemove(int index)
        {
            int shiftIndex = (index / Interval) + 1;

            if (count % Interval == 0)
            {
                lst.Delete(lst.Count - 1);
            }

            for (int i = shiftIndex; i < lst.Count; i++)
            {
                lst[i] = lst[i].Next;
            }
        }

        // Обновление индексов после вставки узла
        private void UpdateIndexNodesAfterInsert(int index)
        {
            int shiftIndex = (index / Interval) + 1;

            if ((count + 1) % Interval == 0)
            {
                lst.Append(Find(count), count);
            }

            for (int i = shiftIndex; i < lst.Count; i++)
            {
                lst[i] = lst[i].Previous;
            }
        }

        // Получение количества узлов в списке
        public int Count { get { return count; } }

        // Индексатор для доступа к узлам по индексу
        public int this[int index]
        {
            get
            {
                if (index >= count || index < 0) return 0;
                Node findNode = Find(index);
                return findNode.Data;
            }
            set
            {
                if (index >= count || index < 0) return;
                Node findNode = Find(index);
                findNode.Data = value;
            }
        }

        // Очистка списка
        public void Clear()
        {
            head = null;
            lst.Clear();
            count = 0;
        }

        // Вывод списка на экран
        public void Print()
        {
            Node current = head;

            while (current != null)
            {
                Console.Write($"{current.Data} ");
                current = current.Next;
            }
            Console.WriteLine();
        }
    }
}