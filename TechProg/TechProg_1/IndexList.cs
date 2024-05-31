//Данный класс IndexList представляет структуру данных, которая служит для ускорения доступа к узлам двусвязного списка, 
//храня ссылки на узлы списка и их индексы.
// Использование пространства имен System
using System;

namespace ТП1
{
    // Объявление класса IndexList
    public class IndexList
    {
        // Объявление структуры Element
        public struct Element
        {
            // Свойство node типа Node из класса DoublyLinkedList
            public DoublyLinkedList.Node node { get; set; }
            // Свойство index типа int
            public int index { get; set; }
            // Конструктор структуры Element
            public Element(DoublyLinkedList.Node node, int index)
            {
                this.node = node;
                this.index = index;
            }
        }

        // Приватные переменные count и capacity
        private int count;
        private int capacity;
        // Массив buffer типа Element, инициализированный как null
        Element[] buffer = null;

        // Конструктор класса IndexList
        public IndexList()
        {
            capacity = 5;
            count = 0;
            buffer = new Element[capacity];
        }

        // Метод для изменения размера массива buffer
        private void ResizeArray()
        {
            Array.Resize(ref buffer, capacity * 2);
        }

        // Метод для добавления элемента в IndexList
        public void Append(DoublyLinkedList.Node data, int index)
        {
            if (index >= count) { ResizeArray(); }
            buffer[count++] = new Element(data, index);
        }

        // Метод для удаления элемента из IndexList
        public void Delete(int index)
        {
            if (index < 0 || index >= count) { throw new IndexOutOfRangeException(); }
            for (int i = index; i < count - 1; i++)
            {
                buffer[i] = buffer[i + 1];
            }
            count--;
        }

        // Метод для очистки элементов IndexList
        public void Clear()
        {
            buffer = null;
            capacity = 5;
            count = 0;
        }

        // Свойство Count, возвращающее значение count
        public int Count { get { return count; } }

        // Метод для поиска индекса в IndexList
       public int Find(int index)
{
        for (int i = 0; i < count; i++)
        {
            int a = index/2 - buffer[i].index;
            int b = buffer[i].index-0;
            if ((a) > (b))
            {
                buffer[i].index = index;
                return i; // Если значение найдено, возвращаем индекс
            }
            else{
                buffer[i].index = b;
                return i;
            }
        }

        throw new IndexOutOfRangeException(); // Если значение не найдено, выбрасываем исключение
}

        // Индексатор для доступа к элементам по индексу
        public DoublyLinkedList.Node this[int index]
        {
            get
            {
                if (index < 0 || index >= count) { throw new IndexOutOfRangeException(); }
                else { return buffer[index].node; }
            }
            set
            {
                if (index < 0 || index >= count) { throw new IndexOutOfRangeException(); }
                else { buffer[index].node = value; }
            }
        }

        // Метод для получения индекса элемента по индексу в IndexList
        public int GetIndex(int index)
        {
            return buffer[index].index;
        }

        // Метод для получения узла по индексу в IndexList
        public DoublyLinkedList.Node GetNode(int index)
        {
            return buffer[Find(index)].node;
        }

        // Метод для установки узла по индексу в IndexList
        public void SetNode(DoublyLinkedList.Node node, int index)
        {
            buffer[Find(index)].node = node;
            buffer[Find(index)].index = index;
        }
    }
}