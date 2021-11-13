using System.Drawing.Drawing2D;

namespace Sample5
{
    public partial class Form1 : Form
    {
#if(NET5_0_OR_GREATER)
        private const string strImagePath = "..\\..\\..\\..\\..\\..\\data\\";
#else
        private const string strImagePath = "..\\..\\..\\..\\..\\data\\";
#endif
        private const string strImageFile = "car.bmp";
        private string strImageFullPath = Directory.GetCurrentDirectory() + "\\" + strImagePath + strImageFile;

        private readonly Image im;

        public Form1()
        {
            InitializeComponent();

            im = Image.FromFile(strImageFullPath);

            this.Paint += new PaintEventHandler(fm_Paint);
        }

        private void fm_Paint(object? sender, PaintEventArgs e)
        {
            Graphics g = e.Graphics;
            GraphicsPath gp = new GraphicsPath();

            gp.AddEllipse(new Rectangle(0, 0, this.Width, this.Height));
            Region rg = new Region(gp);
            g.Clip = rg;

            g.DrawImage(im, 0, 0, this.Width, this.Height);
        }
    }
}