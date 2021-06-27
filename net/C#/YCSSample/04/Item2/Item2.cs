using System.Windows.Forms;
using System.Drawing;

class Item2
{
    private const string strImagePath = "..\\..\\..\\..\\data\\";

    public static void Main()
    {
        Form fm = new Form();
        fm.Text = "サンプル";
        fm.Width = 500; fm.Height = 500;

        PictureBox[,] pb = new PictureBox[5, 5];

        for (int i = 0; i < 5; i++)
        {
            for (int j = 0; j < 5; j++)
            {
                pb[i, j] = new PictureBox();
                pb[i, j].Image = Image.FromFile(strImagePath + "car.bmp");
                pb[i, j].Top = i * pb[i, j].Height;
                pb[i, j].Left = j * pb[i, j].Width;
                pb[i, j].Parent = fm;
            }
        }

        Application.Run(fm);
    }
}


