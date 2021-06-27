using System.Drawing;
using System.Windows.Forms;

class Item1
{
    public static void Main()
    {
        Form fm = new Form();
        fm.Text = "サンプル";
        fm.Width = 300;
        fm.Height = 200;

        Label lb = new Label();
        lb.Text = "こんにちは";
        lb.Top = (fm.Height - lb.Height) / 2;
        lb.Left = (fm.Width - lb.Width) / 2;

        lb.Parent = fm;

        Application.Run(fm);
    }
}
