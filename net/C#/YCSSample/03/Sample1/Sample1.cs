using System.Drawing;
using System.Windows.Forms;

class Sample1
{
    private const string strImagePath = "..\\..\\..\\..\\data\\";

    public static void Main()
    {
        Form fm = new Form();
        fm.Text = "サンプル";

        PictureBox pb = new PictureBox();
        pb.Image = Image.FromFile(strImagePath + "car.bmp");
        pb.Top = 100;

        pb.Parent = fm;

        Application.Run(fm);
    }
}
