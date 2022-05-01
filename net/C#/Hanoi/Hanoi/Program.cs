// See https://aka.ms/new-console-template for more information

class Hanoi
{
    public static int count;

    public static void Main()
    {
        count = 0;

        HanoiR(5, "Left", "Center", "Right");
    }

    public static void HanoiR(int n, string from, string to, string work)
    {
        if(n > 0)
        {
            HanoiR(n - 1, from, work, to);
            Console.WriteLine(++count + ")" + n + ":" + from + "->" + to);
            HanoiR(n - 1, work, to, from);
        }
    }
}
