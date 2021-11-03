namespace Sample3
{
    public partial class Form1 : Form
    {
#if(NET5_0_OR_GREATER)
        private const string strImagePath = "..\\..\\..\\..\\..\\..\\data\\";
#else
        private const string strImagePath = "..\\..\\..\\..\\..\\data\\";
#endif
        private const string strImageFile = "car.bmp";
        private string strFullImagePath = Directory.GetCurrentDirectory() + "\\" + strImagePath + strImageFile;

        public Form1()
        {
            InitializeComponent();

            i = 0;
            bm1 = new Bitmap(strFullImagePath);
            bm2 = new Bitmap(strFullImagePath);

            this.Click += new EventHandler(fm_Click);
            this.Paint += new PaintEventHandler(fm_Paint);
        }

        private void fm_Paint(object? sender, PaintEventArgs e)
        {
            Graphics g = e.Graphics;
            g.DrawImage(bm2, 0, 0, 400, 300);
        }

        private void fm_Click(object? sender, EventArgs e)
        {
            i++;
            if (i >= 4) i = 0;
            Convert();
            this.Invalidate();
        }

        public void Convert()
        {
            for(int x = 0; x < bm1.Width; x++)
            {
                for(int y = 0; y < bm1.Height; y++)
                {
                    Color cbm1 = bm1.GetPixel(x, y);    // ピクセルの色を取得
                    int bm1rgb = cbm1.ToArgb();         // RGB値に変換
                    int bm1a = (bm1rgb >> 24) & 0xFF;   // 透明度
                    int bm1r = (bm1rgb >> 16) & 0xFF;   // 赤成分                                                     
                    int bm1g = (bm1rgb >> 8) & 0xFF;    // 緑成分
                    int bm1b = (bm1rgb >> 0) & 0xFF;    // 青成分

                    switch (i)
                    {
                        case 1:
                            bm1r >>= 2;
                            break;
                        case 2:
                            bm1g >>= 2;
                            break;
                        case 3:
                            bm1b >>= 2;
                            break;
                    }
                    // RGB値に変換
                    bm1rgb = (bm1a << 24) | (bm1r << 16) | (bm1g << 8) | (bm1b << 0);

                    // ピクセルの色を設定
                    cbm1 = Color.FromArgb(bm1rgb);
                    bm2.SetPixel(x, y, cbm1);
                }
            }
        }
    }
}