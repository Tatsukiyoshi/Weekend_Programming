using Timer = System.Windows.Forms.Timer;

namespace Sample3
{
    class Ball
    {
        public Color Color;
        public Point Point;
    }

    public partial class Form1 : Form
    {
        private readonly Ball bl;
        private readonly Image im;
        private int dx, dy;
        private int t;

        public Form1()
        {
            InitializeComponent();

            // �ݒ肩��w�i�摜�̊i�[����擾
            Properties.Settings settings = new();
            im = Image.FromFile(settings.strImagePath + "sky.bmp");

            // �{�[�����X�^�[�g�ꏊ�ɔz�u
            bl = new Ball();
            Point p = new(0, 300);
            Color c = Color.White;
            bl.Point = p;
            bl.Color = c;

            // �ړ������Ǝ��Ԃ�������
            dx = 0; 
            dy = 0;
            t = 0;

            // �`��p�^�C�}���J�n�i100ms�Ԋu�j
            Timer tm = new()
            {
                Interval = 100
            };
            tm.Start();

            this.Paint += new PaintEventHandler(Fm_Paint);
            tm.Tick += new EventHandler(Tm_Tick);
        }

        private void Tm_Tick(object? sender, EventArgs e)
        {
            Point p = bl.Point;

            t++;

            if(p.X > this.ClientSize.Width)
            {
                dx = 0;
                dy = 0;
                t = 0;
                p.X = 0;
                p.Y = 300;
            }

            // ����80�A�p�x1/3��
            // �P�ʎ��Ԃ�����̐��������̈ړ�����
            dx = (int)(80 * Math.Cos(Math.PI / 3));

            // �P�ʎ��Ԃ�����̉��������̈ړ�����
            dy = (int)(80 * Math.Sin(Math.PI / 3) - 9.8 * t);

            p.X += dx;
            p.Y -= dy;

            bl.Point = p;
            this.Invalidate();
        }

        private void Fm_Paint(object? sender, PaintEventArgs e)
        {
            Graphics g = e.Graphics;

            g.DrawImage(im, 0, 0, im.Width, im.Height);

            Point p = bl.Point;
            Color c = bl.Color;
            SolidBrush br = new SolidBrush(c);

            g.FillEllipse(br, p.X, p.Y, 10, 10);
        }
    }
}
