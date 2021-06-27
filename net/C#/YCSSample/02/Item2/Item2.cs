using System;
using System.Drawing;
using System.Windows.Forms;

class Item2
{
    public static void Main()
    {
        Form fm = new Form();
        fm.Text = "サンプル";

        Label lb = new Label();
        lb.Text = "また会いましょう！";
        lb.Parent = fm;

        Application.Run(fm);
    }
}
