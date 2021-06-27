using System.Windows.Forms;
using System.Drawing;

class Sample4
{
    private const string strImagePath = "..\\..\\..\\..\\data\\";

    public static void Main()
    {
        Form fm = new Form();
        fm.Text = "サンプル";
        fm.Width = 300; fm.Height = 200;

        PictureBox pb = new PictureBox();
        pb.Image = Image.FromFile(strImagePath + "car.bmp");
        pb.Left = 100;

        Label lb = new Label();
        lb.Top = pb.Bottom;
        lb.Text = "車です。";

        if (pb.Left >= 0 && pb.Left <= pb.Width)
        {
            lb.Text = "車は画面内にあります。";

        }　elase {
            lb.Text = "車は画面外にあります。";
        }

        pb.Parent = fm;
        lb.Parent = fm;
        
        Application.Run(fm);
    }
}


