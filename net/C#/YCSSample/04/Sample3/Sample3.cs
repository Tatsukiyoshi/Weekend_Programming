using System.Windows.Forms;
using System.Drawing;

class Sample3
{
    private const string strImagePath = "..\\..\\..\\..\\data\\";

    public static void Main()
    {
        Form fm = new Form();
        fm.Text = "サンプル";
        fm.Width = 300; fm.Height = 200;

        PictureBox pb = new PictureBox();
        pb.Image = Image.FromFile(strImagePath + "car.bmp");
        pb.Left = 150;

        Label lb = new Label();
        lb.Top = pb.Bottom;
        lb.Text = "車です。";

        switch(pb.Left){
            case 20:
                lb.Text = "西のガソリンスタンドです。";
                break;
            case 150:
                lb.Text = "東のガソリンスタンドです。";
                break;
            default:
                lb.Text = "走行中です。";
                break;
        }

        pb.Parent = fm;
        lb.Parent = fm;

        Application.Run(fm);
    }
}
