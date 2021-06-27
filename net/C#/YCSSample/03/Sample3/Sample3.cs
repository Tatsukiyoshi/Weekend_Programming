using System.Drawing;
using System.Windows.Forms;

class Sample3
{
    private const string strImagePath = "..\\..\\..\\..\\data\\";

    public static void Main()
    {
        int w;
        Form fm = new Form();
        fm.Text = "サンプル";

        w = 100;

        PictureBox pb = new PictureBox();
        pb.Image = Image.FromFile(strImagePath + "car.bmp");
        pb.Top = w;
        pb.Left = pb.Width;

        pb.Parent = fm;

        Application.Run(fm);
    }
}
