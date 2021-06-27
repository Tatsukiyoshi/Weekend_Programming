using System.Windows.Forms;

class Sample3
{
    public static void Main()
    {
        Form fm = new Form();
        fm.Text = "ようこそC#へ！";

        Label lb = new Label();
        lb.Text = "C#をはじめましょう！";
        lb.Parent = fm;

        Application.Run(fm);
    }
}

