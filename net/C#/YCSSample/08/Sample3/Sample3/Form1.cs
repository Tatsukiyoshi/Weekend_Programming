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
        private string strImageFullPath = Directory.GetCurrentDirectory() + "\\" + strImagePath + strImageFile;

        public Form1()
        {
            InitializeComponent();

            i = 0;
            bm1 = new Bitmap(strImageFullPath);
            bm2 = new Bitmap(strImageFullPath);

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
                    Color cbm1 = bm1.GetPixel(x, y);    // �s�N�Z���̐F���擾
                    int bm1rgb = cbm1.ToArgb();         // RGB�l�ɕϊ�
                    int bm1a = (bm1rgb >> 24) & 0xFF;   // �����x
                    int bm1r = (bm1rgb >> 16) & 0xFF;   // �Ԑ���                                                     
                    int bm1g = (bm1rgb >> 8) & 0xFF;    // �ΐ���
                    int bm1b = (bm1rgb >> 0) & 0xFF;    // ����

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
                    // RGB�l�ɕϊ�
                    bm1rgb = (bm1a << 24) | (bm1r << 16) | (bm1g << 8) | (bm1b << 0);

                    // �s�N�Z���̐F��ݒ�
                    cbm1 = Color.FromArgb(bm1rgb);
                    bm2.SetPixel(x, y, cbm1);
                }
            }
        }
    }
}