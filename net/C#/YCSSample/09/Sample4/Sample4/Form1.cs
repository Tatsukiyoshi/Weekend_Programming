using Timer = System.Windows.Forms.Timer;

namespace Sample4
{
    class Ball
    {
        public Image? Image;
        public Point Point;
    }

    class Cart
    {
        public Image? Image;
        public Point Point;
    }

    public partial class Form1 : Form
    {
        private readonly Ball bl;
        private readonly Cart ct;
        private Image im;
        private int dx, dy;
        private bool isOver;
        private bool isIn;
        private Timer tm;

        public Form1()
        {
            InitializeComponent();

            // �ݒ肩��w�i�摜���擾
            Properties.Settings settings = new();
            im = Image.FromFile(settings.strImagePath + "sky.bmp");

            // �Q�[����Ԃ�������
            isOver = false;
            isIn = false;

            // �����S�̏�����
            bl = new Ball();
            Point blp = new(0, 0);
            Image bim = Image.FromFile(settings.strImagePath + "apple.png");
            bl.Point = blp;
            bl.Image = bim;

            // �ړ��ʂ̏�����
            dx = 4;
            dy = 4;

            // �J�[�g�̏�����
            ct = new Cart();
            Point ctp = new(this.ClientSize.Width / 2, this.ClientSize.Height - 80);
            Image? cim = Image.FromFile(settings.strImagePath + "cart.png");
            ct.Point = ctp;
            ct.Image = cim;

            tm = new Timer
            {
                Interval = 100
            };
            tm.Start();

            this.Paint += new PaintEventHandler(Fm_Paint);
            tm.Tick += new EventHandler(Tm_Tick);
            this.KeyDown += new KeyEventHandler(Fm_KeyDown);
            this.Click += new EventHandler(Fm_Click);
        }

        private void Fm_Click(object? sender, EventArgs e)
        {
            // �t�H�[�����N���b�N����ƁA�ĊJ����
            if (isOver == true)
            {
                bl.Point.X = 0;
                bl.Point.Y = 0;
                isOver = false;
                tm.Start();
                this.Invalidate();
            }
        }

        private void Fm_KeyDown(object? sender, KeyEventArgs e)
        {
            Point ctp = ct.Point;
            Image? cim = ct.Image;

            if(cim != null)
            {
                if (e.KeyCode == Keys.Right)
                {
                    ctp.X += 2;
                    if (ctp.X > this.ClientSize.Width - cim.Width)
                        ctp.X = this.ClientSize.Width - cim.Width;
                }
                else if (e.KeyCode == Keys.Left)
                {
                    ctp.X -= 2;
                    if (ctp.X < 0) ctp.X = 0;
                }
                ct.Point = ctp;
            }
            this.Invalidate();
        }

        private void Tm_Tick(object? sender, EventArgs e)
        {
            Point blp = bl.Point;
            Point ctp = ct.Point;
            Image? bim = bl.Image;
            Image? cim = ct.Image;

            if(bim != null && cim != null && sender != null)
            {
                // ���E�̕ǂɓ��������ꍇ
                if (blp.X < 0 || blp.X > this.ClientSize.Width - bim.Width)
                    dx = -dx;

                // ��̕ǂɓ��������ꍇ
                if (blp.Y < 0) dy = -dy;

                // �J�[�g�ɓ����Ă��Ȃ��āA�J�[�g�ɓ��������ꍇ�A���˂��܂��B
                if ((isIn == false) && blp.X > ctp.X - bim.Width
                    && blp.X < ctp.X + cim.Width
                    && (blp.Y > ctp.Y - bim.Height
                    && blp.Y < ctp.Y - bim.Height / 2))
                {
                    isIn = true;    // �A�����ăJ�[�g�ɔ��˂��Ȃ��悤��isIn��true�ɂ���
                    dy = -dy;
                }
                if (blp.Y < ctp.Y - bim.Height)
                {
                    isIn = false;
                }
                if (blp.Y > this.ClientSize.Height)
                {
                    isOver = true;
                    Timer t = (Timer)sender;
                    t.Stop();
                }

                blp.X += dx;
                blp.Y += dy;

                bl.Point = blp;
            }

            this.Invalidate();
        }

        private void Fm_Paint(object? sender, PaintEventArgs e)
        {
            Graphics g = e.Graphics;

            g.DrawImage(im, 0, 0, im.Width, im.Height); // �w�i�̕`��

            Image? bim = bl.Image;
            if(bim != null)
            {
                Point blp = bl.Point;
                g.DrawImage(bim, blp.X, blp.Y, bim.Width, bim.Height); // �����S�̕`��
            }

            Image? cim = ct.Image;
            if(cim != null)
            {
                Point ctp = ct.Point;
                g.DrawImage(cim, ctp.X, ctp.Y, cim.Width, cim.Height); // �J�[�g�̕`��
            }

            // �Q�[���I�[�o�[���̕`��
            if (isOver == true)
            {
                Font f = new("SansSerif", 30);
                SizeF s = g.MeasureString("Game Over", f);

                float cx = (this.ClientSize.Width - s.Width) / 2;
                float cy = (this.ClientSize.Height - s.Height) / 2;

                g.DrawString("Game Over", f, new SolidBrush(Color.Blue), cx, cy);
            }
        }
    }
}
