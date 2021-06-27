using System.Drawing;
using System.Windows.Forms;

class Sample5
{
    private const string strImagePath = "..\\..\\..\\..\\data\\";

    public static void Main()
    {
        Form fm = new Form();
        fm.Text = "サンプル";

        PictureBox pb = new PictureBox();
        pb.Image = Image.FromFile(strImagePath + "car.bmp");
        pb.Top = (fm.Height - pb.Height) / 2;
        pb.Left = (fm.Width - pb.Width) / 2;

        pb.Parent = fm;

        Application.Run(fm);
    }
}
