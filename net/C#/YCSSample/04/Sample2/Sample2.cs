using System.Windows.Forms;
using System.Drawing;

class Sample2
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

        if (pb.Left >= 150)
        {
            lb.Text = "車は東にあります。";
        } else if (pb.Left <= 20)
        {
            lb.Text = "車は西にあります。";
        } else
        {
            lb.Text = "車は中部にあります。";
        }

        pb.Parent = fm;
        lb.Parent = fm;

        Application.Run(fm);
    }
}
