using System.Drawing;
using System.Windows.Forms;

class Item2
{
    public static void Main()
    {
        Form fm = new Form();
        fm.Text = "サンプル";

        Label lb1 = new Label();
        lb1.Text = "こんにちは";
        lb1.Top = 0;
        lb1.Left = 0;

        lb1.Parent = fm;

        Label lb2 = new Label();
        lb2.Text = "さようなら";
        lb2.Top = 0;
        lb2.Left = lb1.Left + 100;

        lb2.Parent = fm;

        Application.Run(fm);
    }
}
