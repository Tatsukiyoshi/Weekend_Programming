namespace Sample8
{
    public partial class Form1 : Form
    {
        private Image im;
        private int i;

#if (NET5_0_OR_GREATER)
        private const string strImagePath = "..\\..\\..\\..\\..\\..\\data\\";
#else
        private const string strImagePath = "..\\..\\..\\..\\..\\data\\";
#endif
        private const string strImageFile = "car.bmp";
        private string strImageFullPath = Directory.GetCurrentDirectory() + "\\" + strImagePath + strImageFile;

        public Form1()
        {
            InitializeComponent();

            im = Image.FromFile(strImageFullPath);

            i = 0;
        }

        private void Form1_Paint(object sender, PaintEventArgs e)
        {
            Graphics g = e.Graphics;

            g.DrawImage(im, new Rectangle(0, 0, i, im.Height),
                0, 0, i, im.Height, GraphicsUnit.Pixel);
        }

        private void tm_Tick(object sender, EventArgs e)
        {
            if(i > im.Width + 200)
            {
                i = 0;
            }
            else
            {
                i = i + 10;
            }

            this.Invalidate();
        }
    }
}
