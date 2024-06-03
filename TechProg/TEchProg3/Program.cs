namespace ТП3 
{
    class Program 
    {
     static void Main(string[] args)
{
    int arr_count_except = 0;
    int chain_count_except = 0;
    int double_count_except = 0;
    Base_list<char> array = new Arr_list<char>();
    Base_list<char> chain = new Arr_chain<char>();
    Base_list<char> doublelist = new Dbl_list<char>();
    Random rnd = new Random();

    for (int i = 0; i < 1000; i++)
    {
        int operation = rnd.Next(5);
        char item = (char)('a' + rnd.Next(0, 26));
        int pos = rnd.Next(50);

        switch (operation)
        {
            case 0:
                array.Add(item);
                chain.Add(item);
                doublelist.Add(item);
                break;
            case 1:
                try
                {
                    array.Delete(pos);
                }
                catch (BadIndexException)
                {
                    arr_count_except++;
                    Console.WriteLine("Delete array exception caught");
                }
                try
                {
                    chain.Delete(pos);
                }
                catch (BadIndexException)
                {
                    chain_count_except++;
                    Console.WriteLine("Delete chain exception caught");
                }
                try
                {
                    doublelist.Delete(pos);
                }
                catch (BadIndexException)
                {
                    double_count_except++;
                    Console.WriteLine("Delete doublelist exception caught");
                }
                break;
            case 2:
                try
                {
                    array.Insert(pos, item);
                }
                catch (BadIndexException)
                {
                    arr_count_except++;
                    Console.WriteLine("Insert array exception caught");
                }
                try
                {
                    chain.Insert(pos, item);
                }
                catch (BadIndexException)
                {
                    chain_count_except++;
                    Console.WriteLine("Insert chain exception caught");
                }
                try
                {
                    doublelist.Insert(pos, item);
                }
                catch (BadIndexException)
                {
                    double_count_except++;
                    Console.WriteLine("Insert doublelist exception caught");
                }
                break;
            case 3:
                array.Clear();
                chain.Clear();
                doublelist.Clear();
                break;
            case 4:
                try
                {
                    array[pos] = item;
                }
                catch (BadIndexException)
                {
                    arr_count_except++;
                    Console.WriteLine("Set array exception caught");
                }
                try
                {
                    chain[pos] = item;
                }
                catch (BadIndexException)
                {
                    chain_count_except++;
                    Console.WriteLine("Set chain exception caught");
                }
                try
                {
                    doublelist[pos] = item;
                }
                catch (BadIndexException)
                {
                    double_count_except++;
                    Console.WriteLine("Set doublelist exception caught");
                }
                break;
        }
    }

    array.Clear();
    array.Add('1');
    array.Add('6');
    array.Add('8');
    array.Add('9');
    array.Add('5');
    array.Sort();
    Console.WriteLine("Elements in ArrayList:");
    array.Print();
    string filename = "lab3.txt";
    array.SaveToFile(filename);
    Base_list<char> clone = array.Clone();
    Console.WriteLine($"From file {filename}:");
    clone.Print();
    clone.LoadFromFile(filename);

    
    doublelist.Print();
    clone = array + doublelist+ chain;

    Console.WriteLine($"Exception Array: {arr_count_except}");
    Console.WriteLine($"Exception Chain: {chain_count_except}");
    Console.WriteLine($"Exception Doublelist: {double_count_except}");
}
    }
}